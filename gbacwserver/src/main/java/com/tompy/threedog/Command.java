package com.tompy.threedog;

public interface Command
{
    public String doCommand( int gameId, int playerId, String[] args );

    public String undoCommand( int gameId, int playerId, String[] args );
}
