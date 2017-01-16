package com.tompy.threedog;

import com.tompy.threedog.spring.model.Game;
import com.tompy.threedog.spring.model.Player;

public interface GameController
{
    public int playGame( String[] args );

    public void setGame( Game game );

    public Game getGame();

    public void setPlayer( Player player );

    public Player getPlayer();

    public void stop();

    public String getInput( String prompt );

}
