package com.tompy.threedog.spring.service;

import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.tompy.threedog.spring.dao.GameDAO;
import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.GameLeader;
import com.tompy.threedog.spring.model.GamePlayer;
import com.tompy.threedog.spring.model.Leader;
import com.tompy.threedog.spring.model.OrdersType;
import com.tompy.threedog.spring.model.Player;
import com.tompy.threedog.spring.model.SideType;
import com.tompy.threedog.spring.model.StateType;
import com.tompy.threedog.spring.model.StatusType;
import com.tompy.threedog.spring.model.Turn;

public class GameServiceImpl implements GameService
{
    private GameDAO gameDAO;
    private PlayerService playerService;
    private TurnService turnService;
    private LeaderService leaderService;
    private LookupService lookupService;

    @Override
    @Transactional
    public Game createGame( String unionPlayerName, String confederatePlayerName, String description, String controlStatus )
    {
        Player unionPlayer = playerService.getPlayerByName( unionPlayerName );
        Player confederatePlayer = playerService.getPlayerByName( confederatePlayerName );
        OrdersType orders = lookupService.getOrdersType( OrdersType.DEFAULT );
        StatusType status = lookupService.getStatusType( StatusType.DEFAULT );

        Game game = new Game();
        game.setDescription( description );
        game.setCurrentTurn( 0 );

        game.addGamePlayer( new GamePlayer( game, unionPlayer, lookupService.getSideType( SideType.DEFAULT_USA ), lookupService.getStateType( StateType.DEFAULT ) ) );
        game.addGamePlayer( new GamePlayer( game, confederatePlayer, lookupService.getSideType( SideType.DEFAULT_CSA ), lookupService.getStateType( StateType.DEFAULT ) ) );

        Set< GameLeader > gameLeaders = game.getGameLeaders();
        List< Leader > leaderList = leaderService.getLeadersForTurn( game.getCurrentTurn() );
        for ( Leader l : leaderList )
        {
            if ( !gameLeaders.contains( l ) )
            {
                gameLeaders.add( new GameLeader( game, l, orders, status ) );
            }
        }

        gameDAO.saveGame( game );

        game.addTurn( turnService.createNextTurn( game.getId() ) );

        gameDAO.saveGame( game );

        return game;
    }

    @Override
    @Transactional
    public void addNextTurn( int gameId, int turnId )
    {
        Game game = getGameById( gameId );
        game.addTurn( turnService.getTurnById( turnId ) );

        gameDAO.saveGame( game );
    }

    @Override
    @Transactional
    public Game getGameById( int gameId )
    {
        return gameDAO.getGameById( gameId );
    }

    public void setGameDAO( GameDAO gameDAO )
    {
        this.gameDAO = gameDAO;
    }

    public void setTurnService( TurnService turnService )
    {
        this.turnService = turnService;
    }

    public void setPlayerService( PlayerService playerService )
    {
        this.playerService = playerService;
    }

    public void setLeaderService( LeaderService leaderService )
    {
        this.leaderService = leaderService;
    }

    public void setLookupService( LookupService lookupService )
    {
        this.lookupService = lookupService;
    }

}
