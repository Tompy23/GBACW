package com.tompy.threedog;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main entry point for CLI
 *
 */
public class AppCli
{
    public static void main( String[] args )
    {
        AppCli ac = new AppCli();
        System.exit( ac.game( args ) );
    }

    @SuppressWarnings("resource")
    public int game( String[] args )
    {
        return ( (GameController) ( ( new ClassPathXmlApplicationContext( args[ 0 ] ) ).getBean( "controller" ) ) ).playGame( args );
    }

}
