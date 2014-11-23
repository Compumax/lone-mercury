package com.dsitelecom.xmontero.compumax.lonemercury;

import java.util.ArrayList;

import android.graphics.Color;
import android.graphics.Point;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Screen;
import com.kilobolt.framework.Graphics.ImageFormat;

public class ScreenLoader extends Screen
{
	boolean painted = false;

	public ScreenLoader( Game game )
	{
		super( game );
	}

	@Override
	public void update( float deltaTime )
	{
		if( painted )
		{
			Assets.load( game );
		}

		/*
		Graphics g = game.getGraphics();
		Assets.splash = g.newImage( "splash.jpg", ImageFormat.RGB565 );
		*/

		game.setScreen( new ScreenDemo( game ) );
	}

	@Override
	public void paint( float deltaTime )
	{
		//-----------------------------------------------------------------//
		// Draw "LOADING..." prior to loading any file, just with lines.   //
		//-----------------------------------------------------------------//

		synchronized( game )
		{
			Graphics g = game.getGraphics( );
			int position = 0;

			g.clearScreen( Color.BLUE );

			drawLetter( 'L', position++, g );
			drawLetter( 'O', position++, g );
			drawLetter( 'A', position++, g );
			drawLetter( 'D', position++, g );
			drawLetter( 'I', position++, g );
			drawLetter( 'N', position++, g );
			drawLetter( 'G', position++, g );
			drawLetter( '.', position++, g );
			drawLetter( '.', position++, g );
			drawLetter( '.', position++, g );

			painted = true;
		}
	}

	@Override
	public void pause( )
	{
	}

	@Override
	public void resume( )
	{
	}

	@Override
	public void dispose( )
	{
	}

	@Override
	public void backButton( )
	{
		android.os.Process.killProcess( android.os.Process.myPid( ) );
	}

	//---------------------------------------------------------------------//
	// Private.                                                            //
	//---------------------------------------------------------------------//

	private void drawLetter( char letter, int position, Graphics g )
	{
		int offsetX = 200;
		int offsetY = 200;
		int spacing = 50;
		int spacing2 = spacing * 2;

		class Line
		{
			Point start;
			Point stop;

			public Line( int startX, int startY, int stopX, int stopY )
			{
				start = new Point( startX, startY );
				stop = new Point( stopX, stopY );
			}
		}

		ArrayList< Line > lines = new ArrayList< Line >( );

		switch( letter )
		{
			case 'L':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 0, 2, 1, 2 ) );
				break;

			case 'O':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 0, 2, 1, 2 ) );
				lines.add( new Line( 1, 2, 1, 0 ) );
				lines.add( new Line( 1, 0, 0, 0 ) );
				break;

			case 'A':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 1, 0, 0, 0 ) );
				lines.add( new Line( 1, 0, 1, 2 ) );
				lines.add( new Line( 0, 1, 1, 1 ) );
				break;

			case 'D':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 0, 0, 1, 1 ) );
				lines.add( new Line( 0, 2, 1, 1 ) );
				break;

			case 'I':

				lines.add( new Line( 0, 0, 0, 2 ) );
				break;

			case 'N':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 1, 0, 1, 2 ) );
				lines.add( new Line( 0, 0, 1, 2 ) );
				break;

			case 'G':

				lines.add( new Line( 0, 0, 0, 2 ) );
				lines.add( new Line( 0, 2, 1, 2 ) );
				lines.add( new Line( 1, 2, 1, 1 ) );
				lines.add( new Line( 1, 0, 0, 0 ) );
				break;

			case '.':

				lines.add( new Line( 0, 2, 1, 2 ) );
				break;
		}

		for( int i = 0; i < lines.size( ); i++ )
		{
			Line line = lines.get( i );
			g.drawLine(
					offsetX + line.start.x * spacing + position * spacing2, offsetY + line.start.y * spacing, offsetX + line.stop.x * spacing + position * spacing2, offsetY + line.stop.y * spacing, Color.WHITE
			);
		}
	}
}
