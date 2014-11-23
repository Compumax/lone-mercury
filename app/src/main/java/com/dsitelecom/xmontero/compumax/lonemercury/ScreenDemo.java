package com.dsitelecom.xmontero.compumax.lonemercury;

import java.util.HashMap;

import android.graphics.Color;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Screen;

public class ScreenDemo extends Screen
{
	int stage = 1;
	int subStage = 1;

	float x = 0;

	HashMap< String, Blob > blobs = new HashMap< String, Blob >( );

	public ScreenDemo( Game game )
	{
		super( game );
	}

	@Override
	public void update( float deltaTime )
	{
		synchronized( game )
		{
			switch( stage )
			{
				case 1:

					updateStage1( );
					break;

				case 2:

					updateStage2( );
					break;

				case 3:

					updateStage3( );
					break;

				default:

					break;
			}
		}

		for( HashMap.Entry< String, Blob > entry : blobs.entrySet( ) )
		{
			Blob blob = entry.getValue( );
			blob.update( deltaTime );
		}
	}

	@Override
	public void paint( float deltaTime )
	{
		synchronized( game )
		{
			Graphics gfx = game.getGraphics( );

			gfx.clearScreen( Color.BLACK );

			for( HashMap.Entry< String, Blob > entry : blobs.entrySet( ) )
			{
				Blob blob = entry.getValue( );
				blob.paint( gfx );
			}
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
	// Private updaters                                                    //
	//---------------------------------------------------------------------//

	//-- Stage 1 ----------------------------------------------------------//

	private void updateStage1( )
	{
		switch( subStage )
		{
			case 1:

				updateStage1SubStage1( );
				break;

			case 2:

				updateStage1SubStage2( );
				break;
		}
	}

	private void updateStage1SubStage1( )
	{
		// Create Planet
		Blob planet = new Blob( Assets.planet );
		blobs.put( "planet", planet );
		subStage = 2;
	}

	private void updateStage1SubStage2( )
	{
		// Move and zoom planet
	}

	//-- Stage 2 ----------------------------------------------------------//

	private void updateStage2( )
	{
	}

	//-- Stage 3 ----------------------------------------------------------//

	private void updateStage3( )
	{
	}
}
