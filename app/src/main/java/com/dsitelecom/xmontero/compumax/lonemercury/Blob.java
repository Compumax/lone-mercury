package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Blob
{
	public String name;
	public boolean enabled = true;

	public BlobVector initialPosition = new BlobVector();
	public BlobVector currentPosition = new BlobVector();
	public BlobVector targetPosition = new BlobVector();

	public Blob( String name )
	{
		this.name = name;
	}

	public void update( ScreenDemo demo )
	{
		float currentTime = demo.demoTimeLine.getTotalElapsedInSeconds();
		currentPosition.interpolate( initialPosition, targetPosition, currentTime );

		demo.debug.addMessage( name + ".initial/current/targetPosition: " + initialPosition.toString() + " / " + currentPosition.toString() + " / " + targetPosition );
	}

	public void paint( Canvas canvas )
	{
		Paint paint = new Paint();
		paint.setColor( Color.YELLOW );
		paint.setStyle( Paint.Style.STROKE );

		int x = Math.round( currentPosition.centerX );
		int y = Math.round( currentPosition.centerY );

		canvas.drawRect( x - getWidth() / 2, y - getHeight() / 2, x + getWidth() / 2, y + getHeight() / 2, paint );
	}

	public int getWidth()
	{
		return 100;
	}

	public int getHeight()
	{
		return 100;
	}
}
