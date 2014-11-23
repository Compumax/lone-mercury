package com.dsitelecom.xmontero.compumax.lonemercury;

import java.util.HashMap;

import android.graphics.Color;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Screen;

public class ScreenDemo extends Screen
{
	LoneMercury game;

	public long demoStartTime;
	public long currentStageStartTime;
	public int currentStage;
	public int currentSubStage;

	public String debugMessage;
	public Boolean debug;

	float x = 0;

	Background background;
	Blob mercury = new Blob();
	Blob compumax = new Blob();
	Blob presents = new Blob();

	HashMap< String, Blob > blobs = new HashMap< String, Blob >();

	public ScreenDemo( Game game )
	{
		super( game );

		this.game = ( LoneMercury ) game;

		demoStartTime = System.nanoTime();
		currentStageStartTime = demoStartTime;
		currentStage = 1;
		currentSubStage = 1;

		background = new Background( this );

		debug = true;

		mercury.image = Assets.planet;
		compumax.image = Assets.compumax;
		presents.image = Assets.presents;
	}

	@Override
	public synchronized void update( float deltaTime )
	{
		debugMessage = "";

		background.update( this );

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

		for( HashMap.Entry< String, Blob > entry : blobs.entrySet() )
		{
			Blob blob = entry.getValue();
			blob.update( deltaTime );
		}
	}

	@Override
	public synchronized void paint( float deltaTime )
	{
		Graphics gfx = game.getGraphics();

		gfx.clearScreen( Color.rgb( background.red, background.green, background.blue ) );

		for( HashMap.Entry< String, Blob > entry : blobs.entrySet() )
		{
			Blob blob = entry.getValue();
			blob.paint( gfx );
		}
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
