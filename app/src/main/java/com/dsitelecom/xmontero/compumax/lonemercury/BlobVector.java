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

	public void interpolate( BlobVector start, BlobVector stop, float time, Blob.InterpolationMode interpolationMode, Debug debug )
	{
		float interval = stop.time - start.time;
		float elapsed = time - start.time;
		float linearFactor = elapsed / interval;
		float interpolationFactor;

		switch( interpolationMode )
		{
			case Linear:

				interpolationFactor = linearFactor;
				break;

			case Sinus:

				double interpolationAngle = Math.PI / 2 * linearFactor;
				interpolationFactor = ( float ) Math.sin( interpolationAngle );
				debug.addMessage( "interpolationAngle/Factor: " + interpolationAngle + "/" + interpolationFactor );
				break;

			default:

				interpolationFactor = 1;
				break;
		}

		centerX = interpolateDimension( start.centerX, stop.centerX, interpolationFactor );
		centerY = interpolateDimension( start.centerY, stop.centerY, interpolationFactor );
		angle = interpolateDimension( start.angle, stop.angle, interpolationFactor );
		zoom = interpolateDimension( start.zoom, stop.zoom, interpolationFactor );
		alpha = interpolateDimension( start.alpha, stop.alpha, interpolationFactor );

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
