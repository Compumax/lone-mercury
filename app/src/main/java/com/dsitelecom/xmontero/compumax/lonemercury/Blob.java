package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Color;

import com.kilobolt.framework.Graphics;
import com.kilobolt.framework.Image;

public class Blob
{
	public Image image;

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

	public void update( float deltaTime )
	{
		float speed = 10;	// px/sec
		float deltaPixels = speed * deltaTime;
		centerX += deltaPixels;
		System.out.println( "centerX: " + centerX );
	}

	public void paint( Graphics gfx )
	{
		int x = Math.round( centerX );

		gfx.drawRect( x, 0, 100, 100, Color.YELLOW );
	}
}
