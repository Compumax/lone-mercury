package com.dsitelecom.xmontero.compumax.lonemercury;

import java.util.ArrayList;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.implementation.AndroidGraphics;
import com.kilobolt.framework.Screen;

public class ScreenLoader extends Screen
{
	LoneMercury game;
	boolean painted = false;

	public ScreenLoader( Game game )
	{
		super( game );
		this.game = ( LoneMercury ) game;
	}

	@Override
	public void update( float deltaTime )
	{
		if( painted )
		{
			Assets.load( game );
			game.setScreen( new ScreenDemo( game ) );
		}
	}

	@Override
	public synchronized void paint( float deltaTime )
	{
		//-----------------------------------------------------------------//
		// Draw "LOADING..." prior to loading any file, just with lines.   //
		//-----------------------------------------------------------------//

		AndroidGraphics g = ( AndroidGraphics ) game.getGraphics();
		Paint paint;
		Canvas canvas;

		int position = 0;

		g.clearScreen( Color.BLUE );

		canvas = g.getCanvas();
		paint = g.getPaint();

		paint.setColor( Color.WHITE );
		paint.setStrokeWidth( 10 );

		drawLetter( 'L', position++, canvas, paint );
		drawLetter( 'O', position++, canvas, paint );
		drawLetter( 'A', position++, canvas, paint );
		drawLetter( 'D', position++, canvas, paint );
		drawLetter( 'I', position++, canvas, paint );
		drawLetter( 'N', position++, canvas, paint );
		drawLetter( 'G', position++, canvas, paint );
		drawLetter( '.', position++, canvas, paint );
		drawLetter( '.', position++, canvas, paint );
		drawLetter( '.', position++, canvas, paint );

		painted = true;
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void backButton()
	{
		game.end();
	}

	//---------------------------------------------------------------------//
	// Private.                                                            //
	//---------------------------------------------------------------------//

	private void drawLetter( char letter, int position, Canvas canvas, Paint paint )
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

		ArrayList< Line > lines = new ArrayList< Line >();

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

		for( Line line : lines )
		{
			int x1 = offsetX + line.start.x * spacing + position * spacing2;
			int y1 = offsetY + line.start.y * spacing;
			int x2 = offsetX + line.stop.x * spacing + position * spacing2;
			int y2 = offsetY + line.stop.y * spacing;

			canvas.drawLine( x1, y1, x2, y2, paint );
		}
	}
}
