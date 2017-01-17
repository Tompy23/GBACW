package com.tompy.threedog.cli;

import java.util.Map;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tompy.threedog.Command;
import com.tompy.threedog.Constants;
import com.tompy.threedog.GameController;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;

public class GameControllerCliImpl implements GameController
{
    private Scanner scan = new Scanner( System.in );
    private Map< String, Command > commandMap = null;
    private Game game = null;
    private Player player = null;
    private Player opponent = null;

    private boolean play = true;
    private String prompt = "NoGame>";

    private Logger log = LogManager.getLogger( GameControllerCliImpl.class );

    @Override
    public int playGame( String[] args )
    {
        log.info( "Starting game." );
        int returnValue = play();
        scan.close();

        return returnValue;
    }

    @Override
    public void stop()
    {
        log.info( "Stopping game." );
        play = false;
    }

    private int play()
    {
        int returnValue = 0;

        if ( login() )
        {
            log.info( "Login success." );
            while ( play )
            {
                String commandReturn = parseCommand( getInput( prompt ) );
                if ( null != commandReturn )
                {
                    System.out.println(  commandReturn );
                    log.debug( commandReturn );
                    if ( null != game )
                    {
                        prompt = player.getName() + "/" + game.getDescription() + ">";
                    }
                }
            } // while play
        } // if login
        else
        {
            returnValue = 1;
        }

        return returnValue;
    }

    public String getInput( String prompt )
    {
        String input;

        System.out.print( prompt + " " );
        input = scan.nextLine();

        return input;
    }

    private boolean login()
    {
        String user = getInput( "User>" );
        // String password = new String( System.console().readPassword( "Enter
        // Password:" ) );

        log.info( "Attempting to log in as [" + user + "]." );

        commandMap.get( "LOGIN" ).doCommand( 0, 0, 0, new String[] { "LOGIN", user } );

        return ( null != player );
    }

    // This is where we'll call an appropriate implementation based on the
    // command.
    private String parseCommand( String command )
    {
        log.info( "Command: [" + command + "]" );

        boolean inQuotes = false;
        byte[] details = command.getBytes();
        for ( int i = 0; i < details.length; i++ )
        {
            if ( !inQuotes )
            {
                if ( details[ i ] == ' ' )
                {
                    details[ i ] = ':';
                }
            }

            if ( details[ i ] == '\"' )
            {
                inQuotes = !inQuotes;
            }
        }
        


        String x = new String( details );
        x = x.replaceAll( "\"", "" );
        String[] commandList = x.split( ":" );
        String key = null;

        switch ( commandList[ 0 ].toUpperCase() )
        {
            case "QUIT":
            case "Q":
                key = "QUIT";
                break;

            // Creates Game
            // Creates First turn and sets game to this
            // Status: TURN_NOT_STARTED
            case "GAMESTART":
            case "GST":
                key = "GAMESTART";
                commandList = addCommands( commandList, Integer.toString( Constants.NOTHING ) );
                break;

            // Load a game by ID
            // GLO <Game Id>
            case "GAMELOAD":
            case "GLO":
                key = "GAMELOAD";
                break;

            // List the games for this player, show ID and name
            case "GAMELIST":
            case "GLI":
                key = "GAMELIST";
                break;

            // This loads the Turn Init/Eff/Activation tables for that player
            // Rolls Initiative (modifies by previous turn and in-command OC)
            // Distributes EM (from pool)
            // Status: TURN_STARTED_TMP | TURN_STARTED
            // (TURN_NOT_STARTED | TURN_STARTED_TMP)
            case "STARTTURN":
            case "STU":
                key = "STARTTURN";
                break;

            // If OC "in command" and "on map", can distribute a bonus to Corps
            // leader(s)
            // TUI <Corps Leader ID> [<Corps Leader ID>...]
            // (TURN_STARTED)
            case "GIVEINITIATIVE":
            case "GIN":
                key = "GIVEINITIATIVE";
                break;

            // Can add "am bonus" to Division Leaders if appropriate
            // TUE <Division Leader ID> [<Division Leader ID>...]
            // (TURN_STARTED)
            case "GIVEEFFICIENCY":
            case "GEF":
                key = "GIVEEFFICIENCY";
                break;

            // Calculates the AM for each Division based on previous commands
            // Populates the Turn Activation
            // Populates Turn AM Pool
            // As if called NEXTAM and parameter AM was drawn (see below)
            // Player with Initiative must run this command with parameter, or
            // no AM will start
            // Both players must run this command. If in "TMP", then the
            // "activation procedure" will start
            // TUA <Division AM Leader ID to start>
            // Status: TURN_ACTIVATION_TMP | TURN_ACTIVATION
            // (TURN_STARTED | TURN_ACTIVATION_TMP)
            case "STARTACTIVATION":
            case "SAC":
                key = "STARTACTIVATION";
                break;

            // TODO
            // Ends the current turn.
            // Creates the next turn.
            // Will not happen if AM pool is not "empty"
            // Between ENDTURN and STARTTURN is when all status/orders/command
            // should be changed
            // Status: TURN_NOT_STARTED_TMP | TURN_NOT_STARTED
            // (TURN_ACTIVATION | TURN_NOT_STARTED_TMP)
            case "ENDTURN":
            case "ETU":
                key = "ENDTURN";
                break;

            // Marks the current AM as "picked"
            // Displays the next AM and marks it as "current"
            // (TURN_ACTIVATION)
            case "NEXTAM":
            case "NAM":
                key = "NEXTAM";
                break;

            // List all the leaders for the game and current turn and all
            // activations
            // (> NOTHING)
            case "LISTDETAILS":
            case "LDE":
                key = "LISTDETAILS";
                break;

            // (> NOTHING)
            case "SETSTATUS":
            case "SST":
                key = "SETSTATUS";
                break;

            // (> NOTHING)
            case "SETORDERS":
            case "SOR":
                key = "SETORDERS";
                break;

            // (> NOTHING)
            case "SETCOMMAND":
            case "SCO":
                key = "SETCOMMAND";
                break;

            // (> NOTHING)
            case "SETFATIGUE":
            case "SFA":
                key = "SETFATIGUE";
                break;

            // (> NOTHING)
            case "ADDNOTES":
            case "ANO":
                key = "ADDNOTES";
                break;

            // (> NOTHING)
            case "CLEARNOTES":
            case "CNO":
                key = "CLEARNOTES";
                break;

            // ACT <Brigade ID> <Type> <Notes>
            // (TURN_ACTIVATION)
            case "ACTIVATE":
            case "ACT":
                key = "ACTIVATE";
                break;
        }

        return ( null != key ? commandMap.get( key ).doCommand( ( null != game ) ? game.getId() : 0, ( null != player ) ? player.getId() : 0,
                ( null != opponent ) ? opponent.getId() : 0, commandList ) : "Bad command" );

    }

    private String[] addCommands( String[] commandList, String... newCommands )
    {
        String[] returnValue = commandList;
        int j = 0;

        if ( null != newCommands )
        {
            returnValue = new String[ commandList.length + newCommands.length ];

            for ( int i = 0; i < commandList.length; i++ )
            {
                returnValue[ i ] = commandList[ i ];
                j = i;
            }
            for ( int i = j + 1; i - j - 1 < newCommands.length; i++ )
            {
                returnValue[ i ] = newCommands[ i - j - 1 ];
            }
        }

        return returnValue;
    }

    public void setCommandMap( Map< String, Command > commandMap )
    {
        this.commandMap = commandMap;
    }

    public Game getGame()
    {
        return game;
    }

    public void setGame( Game game )
    {
        this.game = game;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setPlayer( Player player )
    {
        this.player = player;
    }

    public void setOpponent( Player opponent )
    {
        this.opponent = opponent;
    }
}
