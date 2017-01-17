package com.tompy.threedog;

public interface Command
{
    public String doCommand( int gameId, int playerId, int opponentId, String[] args );

    public String undoCommand();
}
