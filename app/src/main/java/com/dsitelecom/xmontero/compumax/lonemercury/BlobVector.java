package com.dsitelecom.xmontero.compumax.lonemercury;

public class BlobVector
{
	public float centerX;
	public float centerY;
	public float angle;
	public float zoom;
	public float alpha;
	public float time;

	public BlobVector()
	{
		resetAsPosition();
	}

	public void resetAsPosition()
	{
		centerX = 0;
		centerY = 0;
		angle = 0;
		zoom = 1;
		alpha = 1;
	}

	public void interpolate( BlobVector start, BlobVector stop, float time )
	{
		float interval = stop.time - start.time;
		float elapsed = time - start.time;
		float factor = elapsed / interval;

		centerX = interpolateDimension( start.centerX, stop.centerX, factor );
		centerY = interpolateDimension( start.centerY, stop.centerY, factor );
		angle = interpolateDimension( start.angle, stop.angle, factor );
		zoom = interpolateDimension( start.zoom, stop.zoom, factor );
		alpha = interpolateDimension( start.alpha, stop.alpha, factor );
	}

	static public float interpolateDimension( float start, float stop, float factor )
	{
		return start + ( stop - start ) * factor;
	}

	public String toString()
	{
		String printableCenterX = Integer.toString( Math.round( centerX * 10 ) / 10 );
		String printableCenterY = Integer.toString( Math.round( centerY * 10 ) / 10 );
		String printableAngle = Integer.toString( Math.round( angle * 100 ) / 100 );
		String printableZoom = Integer.toString( Math.round( zoom * 100 ) / 100 );
		String printableAlpha = Integer.toString( Math.round( alpha * 100 ) / 100 );
		String printableTime = Integer.toString( Math.round( time * 100 ) / 100 );

		return printableCenterX + "/" + printableCenterY + "/" + printableAngle + "/" + printableZoom + "/" + printableAlpha + "/" + printableTime;
	}
}
