package com.dsitelecom.xmontero.compumax.lonemercury;

import com.kilobolt.framework.Screen;
import com.kilobolt.framework.implementation.AndroidGame;

public class LoneMercury extends AndroidGame
{
	// Android game hardcoded at 1280 x 800, later scaled at final paint.

	@Override
	public Screen getInitScreen( )
	{
		return new ScreenLoader( this );
	}

	@Override
	public void onBackPressed( )
	{
		android.os.Process.killProcess( android.os.Process.myPid() );
	}

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
}
