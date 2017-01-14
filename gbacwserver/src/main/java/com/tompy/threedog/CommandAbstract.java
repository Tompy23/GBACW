package com.tompy.threedog;

import com.tompy.threedog.spring.service.GameLeaderService;
import com.tompy.threedog.spring.service.GamePlayerService;
import com.tompy.threedog.spring.service.GameService;
import com.tompy.threedog.spring.service.LeaderService;
import com.tompy.threedog.spring.service.LookupService;
import com.tompy.threedog.spring.service.PlayerService;
import com.tompy.threedog.spring.service.TurnService;

public abstract class CommandAbstract implements Command
{
    protected GameService gameService;
    protected PlayerService playerService;
    protected LookupService lookupService;
    protected TurnService turnService;
    protected GamePlayerService gamePlayerService;
    protected LeaderService leaderService;
    protected GameLeaderService gameLeaderService;
    protected GameController controller;

    @Override
    public String undoCommand( int gameId, int playerId, String[] args )
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void setGameService( GameService gameService )
    {
        this.gameService = gameService;
    }

    public void setController( GameController controller )
    {
        this.controller = controller;
    }

    public void setLookupService( LookupService lookupService )
    {
        this.lookupService = lookupService;
    }

    public void setPlayerService( PlayerService playerService )
    {
        this.playerService = playerService;
    }

    public void setTurnService( TurnService turnService )
    {
        this.turnService = turnService;
    }

    public void setGamePlayerService( GamePlayerService gamePlayerService )
    {
        this.gamePlayerService = gamePlayerService;
    }

    public void setLeaderService( LeaderService leaderService )
    {
        this.leaderService = leaderService;
    }

    public void setGameLeaderService( GameLeaderService gameLeaderService )
    {
        this.gameLeaderService = gameLeaderService;
    }

}
