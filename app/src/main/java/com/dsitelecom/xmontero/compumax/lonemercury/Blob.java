package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Blob
{
	public String name;
	public boolean enabled = true;

	public float centerX = 0;
	public float centerY = 0;
	public float angle = 0;
	public float zoom = 1;
	public float alpha = 1;

	public float speedX = 0;
	public float speedY = 0;
	public float angularSpeed = 0;
	public float zoomSpeed = 0;
	public float alphaSpeed = 0;

	public Blob( String name )
	{
		this.name = name;
	}

	public void update( ScreenDemo demo )
	{
		float speed = 10; // px/sec
		float deltaPixels = speed * demo.demoTimeLine.getIterationElapsedInSeconds();
		centerX += deltaPixels;
		demo.debug.addMessage( name + ".centerX: " + centerX );
	}

	public void paint( Canvas canvas )
	{
		Paint paint = new Paint();
		paint.setColor( Color.YELLOW );
		paint.setStyle( Paint.Style.STROKE );

		int x = Math.round( centerX );
		canvas.drawRect( x, 0, getWidth() + x, getHeight(), paint );
	}

	public int getWidth()
	{
		return 100;
	}

	public int getHeight()
	{
		return 200;
	}
}
