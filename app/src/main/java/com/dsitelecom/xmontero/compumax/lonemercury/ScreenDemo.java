package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Canvas;
import android.graphics.Color;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Screen;
import com.kilobolt.framework.implementation.AndroidGraphics;

public class ScreenDemo extends Screen
{
	LoneMercury game;

	public TimeLine demoTimeLine;
	public TimeLine stageTimeLine;

	public int currentStage;
	public int currentSubStage;

	public Debug debug;

	Background background;
	Blob mercury = new Blob();
	Blob compumax = new Blob();
	Blob presents = new Blob();

	//HashMap< String, Blob > blobs = new HashMap< String, Blob >();

	public ScreenDemo( Game game )
	{
		super( game );

		this.game = ( LoneMercury ) game;

		demoTimeLine = new TimeLine( System.nanoTime() );
		stageTimeLine = new TimeLine( demoTimeLine.getStartTime() );

		currentStage = 1;
		currentSubStage = 1;

		debug = new Debug();
		debug.setEnabled( true );

		background = new Background( this );

		mercury.image = Assets.planet;
		compumax.image = Assets.compumax;
		presents.image = Assets.presents;
	}

	@Override
	public synchronized void update( float deltaTime )
	{
		debug.clear();

		demoTimeLine.setCurrentTime( System.nanoTime() );
		stageTimeLine.setCurrentTime( demoTimeLine.getCurrentTime() );

		debug.addMessage( "demo elapsed: " + Float.toString( demoTimeLine.getTotalElapsedInSeconds() ) );
		debug.addMessage( "stage, sub: " + currentStage + ", " + currentSubStage );
		debug.addMessage( "stage elapsed: " + Float.toString( stageTimeLine.getTotalElapsedInSeconds() ) );

		background.update( this );
		mercury.update( this );

		switch( currentStage )
		{
			case 1:

				updateStage1();
				break;

			case 2:

				updateStage2();
				break;

			case 3:

				updateStage3();
				break;

			case 4:

				updateStage4();
				break;

			case 5:

				updateStage5();
				break;

			case 6:

				updateStage6();
				break;

			case 7:

				updateStage7();
				break;

			case 8:

				updateStage8();
				break;

			default:

				break;
		}

		/*
		for( HashMap.Entry< String, Blob > entry : blobs.entrySet() )
		{
			Blob blob = entry.getValue();
			blob.update( this );
		}
		*/
	}

	@Override
	public synchronized void paint( float deltaTime )
	{
		AndroidGraphics gfx = ( AndroidGraphics ) game.getGraphics();

		gfx.clearScreen( Color.rgb( background.red, background.green, background.blue ) );
		Canvas canvas = gfx.getCanvas();

		/*
		for( HashMap.Entry< String, Blob > entry : blobs.entrySet() )
		{
			Blob blob = entry.getValue();
			blob.paint( gfx );
		}
		*/

		debug.paint( canvas );
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
	// Private updaters                                                    //
	//---------------------------------------------------------------------//

	//-- Stage 1 ----------------------------------------------------------//

	private void updateStage1()
	{
		switch( currentSubStage )
		{
			case 1:

				updateStage1SubStage1();
				break;

			case 2:

				updateStage1SubStage2();
				break;
		}
	}

	private void updateStage1SubStage1()
	{
		// Create Planet
		//Blob planet = new Blob( Assets.planet );
		//blobs.put( "planet", planet );
		currentSubStage = 2;
	}

	private void updateStage1SubStage2()
	{
		// Move and zoom planet
	}

	//-- Stage 2 ----------------------------------------------------------//

	private void updateStage2()
	{
	}

	//-- Stage 3 ----------------------------------------------------------//

	private void updateStage3()
	{
	}

	//-- Stage 4 ----------------------------------------------------------//

	private void updateStage4()
	{
	}

	//-- Stage 5 ----------------------------------------------------------//

	private void updateStage5()
	{
	}

	//-- Stage 6 ----------------------------------------------------------//

	private void updateStage6()
	{
	}

	//-- Stage 7 ----------------------------------------------------------//

	private void updateStage7()
	{
	}

	//-- Stage 8 ----------------------------------------------------------//

	private void updateStage8()
	{
	}
}
