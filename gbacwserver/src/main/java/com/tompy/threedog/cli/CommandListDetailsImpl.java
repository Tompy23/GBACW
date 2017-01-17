package com.tompy.threedog.cli;

import java.util.List;

import com.tompy.threedog.Command;
import com.tompy.threedog.CommandAbstract;
import com.tompy.threedog.Util;
import com.tompy.threedog.spring.model.ActivationBrigade;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.LeaderType;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.Turn;
import com.tompy.threedog.spring.model.TurnAMPool;

public class CommandListDetailsImpl extends CommandAbstract implements Command
{

    @Override
    public String doCommand( int gameId, int playerId, int opponentId, String[] args )
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbO = new StringBuilder();
        Game game = gameService.getGameById( gameId );

        if ( null != game )
        {

            List< GameLeader > gameLeaders = gameLeaderService.getGameLeaders( gameId );
            List< Player > players = gamePlayerService.getPlayers( gameId );

            Player player = playerService.getPlayerById( playerId );
            Player opponent = Util.findOpponent( players, player.getId() );

            SideType playerSide = gamePlayerService.getSide( gameId, playerId );
            SideType opponentSide = gamePlayerService.getSide( gameId, opponent.getId() );

            // details
            sb.append( player.getName() + " - " + playerSide.getDescription() + " - (" + gamePlayerService.getState( gameId, playerId ).getDescription() + ")\n" );
            sbO.append( opponent.getName() + " - " + opponentSide.getDescription() + " - (" + gamePlayerService.getState( gameId, opponent.getId() ).getDescription() + ")\n" );

            // Get overall for both players
            for ( GameLeader gl : gameLeaders )
            {
                if ( gl.getLeader().getRank().getId() == 1 )
                {
                    if ( gl.getLeader().getSide().getId() == playerSide.getId() )
                    {
                        leaderDetails( sb, gl, gameLeaders, playerSide, turnService.getCurrentTurn( gameId ) );
                    }
                    else
                    {
                        leaderDetails( sbO, gl, gameLeaders, playerSide, turnService.getCurrentTurn( gameId ) );
                    }
                }
            }

            sbO.append( "\n\n" );
            sbO.append( sb );
            sbO.append( "\n\n" );
            sbO.append( "Current AM: " + Util.getCurrentAM( turnService.getTurnAMPool( turnService.getCurrentTurn( gameId ).getId() ) ) );
        }
        else
        {
            return "No game.";
        }

        return "\nTurn [" + game.getCurrentTurn() + "]: " + turnService.getCurrentTurn( game.getId() ).getDescription() + "\n\n" + sbO.toString();
        
    }

    private StringBuilder leaderDetails( StringBuilder text, GameLeader gameLeader, List< GameLeader > gameLeaders, SideType playerSide, Turn turn )
    {
        StringBuilder returnValue = text;

        Leader leader = gameLeader.getLeader();

        returnValue = printLeaderDetails( returnValue, gameLeader, leader, playerSide, turn );

        if ( leader.getSubordinates().isEmpty() )
        {
            return returnValue;
        }

        for ( Leader l : leader.getSubordinates() )
        {
            GameLeader gl = Util.getGameLeader( l.getId(), gameLeaders );
            if ( null != gl )
            {
                returnValue = leaderDetails( returnValue, gl, gameLeaders, playerSide, turn );
            }
        }

        return returnValue;
    }

    private StringBuilder printLeaderDetails( StringBuilder sb, GameLeader gl, Leader l, SideType playerSide, Turn turn )
    {
        String indent = String.format( "%1$-" + l.getRank().getId() + "s", " " );
        sb.append( indent + l.getName() + " (" + l.getId() + ") - " + ( "Y".equals( gl.getInCommand() ) ? "In" : "Out of" ) + " Command\n" );
        if ( l.getRank().getId() == LeaderType.LEADER_TYPE_OVERALL )
        {
            sb.append( indent + "Init: " + Util.getInitiative( turnService.getTurnInitiative( turn.getId() ), l ) + "\n" );
        }
        if ( l.getRank().getId() > 1 )
        {
            if ( l.getRank().getId() == LeaderType.LEADER_TYPE_CORPS && l.getSide().getId() == playerSide.getId() )
            {
                sb.append( indent + "EM: " + Util.getEfficiency( turnService.getTurnEfficiency( turn.getId() ), l ) + "\n" );
            }
            if ( l.getRank().getId() == LeaderType.LEADER_TYPE_DIVISION && l.getSide().getId() == playerSide.getId() )
            {
                sb.append( indent + "(" + Util.getActivations( turnService.getTurnActivation( turn.getId() ), l, turnService.getTurnAMPool( turn.getId() ) ) + ")\n" );
            }
            sb.append( indent + " Status: " + gl.getStatus().getDescription() + "\n" );
            if ( l.getRank().getId() > 3 )
            {
                sb.append( indent + " Fatigue: " + gl.getFatigue() + "\n" );
                sb.append( indent + " Orders: " + gl.getOrders().getDescription() + "\n" );
                sb.append( indent + "Activations: \n" );
                sb.append( " " + getBrigadeActivations( turn, gl, indent ) );
            }
        }
        sb.append( indent + "Notes:" );
        String notes = gl.getNotes().replaceAll( "\n", "\n" + indent );
        sb.append( notes + "\n" );
        sb.append( indent + "--------------------\n\n" );
        return sb;
    }

    private StringBuilder getBrigadeActivations( Turn turn, GameLeader gl, String indent )
    {
        StringBuilder sb = new StringBuilder();

        List< ActivationBrigade > activations = turnService.getActivations( turn.getId(), gl.getLeader().getId() );
        for ( ActivationBrigade ab : activations )
        {
            sb.append( indent + ab.getType().getDescription() + " : " + ab.getNotes() + "\n" );
        }

        return sb;
    }

}
