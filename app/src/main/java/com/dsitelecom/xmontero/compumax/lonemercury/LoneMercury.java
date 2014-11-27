package com.dsitelecom.xmontero.compumax.lonemercury;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.res.Configuration;
import android.util.Log;

import com.kilobolt.framework.Screen;
import com.kilobolt.framework.implementation.AndroidGame;
//import com.dsitelecom.compumax.lonemercury.R;

public class LoneMercury extends AndroidGame
{
	// Android game hardcoded at 1280 x 800, later scaled at final paint.

	public static String scrollText;
	boolean assetsLoaded = false;

	@Override
	public Screen getInitScreen( )
	{
		if( !assetsLoaded )
		{
			Assets.load( this );
			assetsLoaded = true;
		}

		//InputStream inputStream = getResources().openRawResource( R.raw.scroll );
		//scrollText = convertStreamToString( inputStream );

		return new ScreenLoader( this );
	}

	@Override
	public void onBackPressed( )
	{
		android.os.Process.killProcess( android.os.Process.myPid() );
	}

	/*
	private static String convertStreamToString( InputStream inputStream )
	{
		BufferedReader reader = new BufferedReader( new InputStreamReader( inputStream ) );
		StringBuilder stringBuilder = new StringBuilder();

		String line = null;

		try
		{
			while( ( line = reader.readLine() ) != null )
			{
				stringBuilder.append( ( line + "\n" ) );
			}
		}
		catch( IOException e )
		{
			Log.w( "LOG", e.getMessage() );
		}
		finally
		{
			try
			{
				inputStream.close();
			}
			catch( IOException e )
			{
				Log.w( "LOG", e.getMessage() );
			}
		}

		return stringBuilder.toString();
	}
	*/

	@Override
	public void onResume( )
	{
		super.onResume( );
		//Assets.theme.play();
	}

	@Override
	public void onPause( )
	{
		super.onPause( );
		//Assets.theme.pause();
	}

	@Override
	public void onConfigurationChanged( Configuration newConfig )
	{
		super.onConfigurationChanged( newConfig );

		// Checks the orientation of the screen
		if( newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE )
		{
			System.out.println( "Landscape" );
		}
		else
		{
			if( newConfig.orientation == Configuration.ORIENTATION_PORTRAIT )
			{
				System.out.println( "Portrait" );
			}
		}
	}
}
