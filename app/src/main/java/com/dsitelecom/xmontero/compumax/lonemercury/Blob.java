package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

public class Blob
{
	public enum InterpolationMode
	{
		Linear,
		Sinus
	}

	public String name;
	public boolean enabled = true;

	public BlobVector initialPosition = new BlobVector();
	public BlobVector currentPosition = new BlobVector();
	public BlobVector targetPosition = new BlobVector();
	public InterpolationMode interpolationMode = InterpolationMode.Linear;

	public Blob( String name )
	{
		this.name = name;
	}

	public void update( ScreenDemo demo )
	{
		if( enabled )
		{
			float currentTime = demo.demoTimeLine.getTotalElapsedInSeconds();

			if( currentTime < targetPosition.time )
			{
				currentPosition.interpolate( initialPosition, targetPosition, currentTime, interpolationMode, demo.debug );
				demo.debug.addMessage( name + ".initial/current/targetPosition/mode: " + initialPosition.toString() + " / " + currentPosition.toString() + " / " + targetPosition + " / " + interpolationMode.toString() );
			}
			else
			{
				demo.debug.addMessage( name + ".current: " + currentPosition.toString() );
			}
		}
	}

	public void paint( Canvas canvas )
	{
		if( enabled )
		{
			Paint paint = new Paint();
			paint.setColor( Color.YELLOW );
			paint.setStyle( Paint.Style.STROKE );

			int x = Math.round( currentPosition.centerX );
			int y = Math.round( currentPosition.centerY );

			canvas.drawRect( x - getWidth() / 2, y - getHeight() / 2, x + getWidth() / 2, y + getHeight() / 2, paint );
		}
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
