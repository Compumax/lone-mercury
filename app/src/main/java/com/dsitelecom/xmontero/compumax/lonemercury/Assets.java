package com.dsitelecom.xmontero.compumax.lonemercury;

import com.kilobolt.framework.Game;
import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Image;
import com.kilobolt.framework.Music;
import com.kilobolt.framework.Sound;
import com.kilobolt.framework.Graphics.ImageFormat;

import java.util.concurrent.TimeUnit;

public class Assets
{
	public static Image planet;
	public static Image compumax, presents, lone, mercury;

	//public static Sound click;
	//public static Music theme;

	public static String scrollText;

	public static void load( Game loneMercury )
	{
		//theme = loneMercury.getAudio().createMusic( "menutheme.mp3" );
		//theme.setLooping( true );
		//theme.setVolume( 0.85f );
		//theme.play();

		System.out.println( "Before GfxLoad" );

		Graphics gfx = loneMercury.getGraphics( );
		Assets.planet = gfx.newImage( "img/planet.png", ImageFormat.ARGB8888 );

		System.out.println( "Before Sleep" );

		try
		{
			TimeUnit.MILLISECONDS.sleep( 500 );
		}
		catch( InterruptedException e )
		{
			Thread.currentThread().interrupt();
		}

		System.out.println( "After Sleep" );

		/*
		Assets.compumax = gfx.newImage( "img/compumax.png", ImageFormat.ARGB4444 );
		Assets.presents = gfx.newImage( "img/presents.png", ImageFormat.ARGB4444 );
		Assets.lone = gfx.newImage( "img/lone.png", ImageFormat.ARGB4444 );
		Assets.mercury = gfx.newImage( "img/mercury.png", ImageFormat.ARGB4444 );
		*/
	}

	// TODO: Read the scroll text from a file.
	// Moved outside the demo.

	//InputStream inputStream = getResources().openRawResource( R.raw.scroll );
	//scrollText = convertStreamToString( inputStream );

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
}
