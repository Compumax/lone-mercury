package com.dsitelecom.xmontero.compumax.lonemercury;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;

public class Debug
{
	public String message;

	private Boolean enabled = false;

	public void paint( Canvas canvas )
	{
		if( enabled )
		{
			TextPaint textPaint = new TextPaint();

			textPaint.setColor( Color.WHITE );
			textPaint.setTextSize( 20 );
			textPaint.setTypeface( Typeface.MONOSPACE );

			StaticLayout textLayout = new StaticLayout( message, textPaint, canvas.getWidth(), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false );

			canvas.save();

			int textX = 5;
			int textY = 5;

			canvas.translate( textX, textY );
			textLayout.draw( canvas );

			canvas.restore();
		}
	}

	public Boolean getEnabled()
	{
		return enabled;
	}

	public void setEnabled( Boolean enabled )
	{
		this.enabled = enabled;
	}

	public void clear()
	{
		message = "";
	}

	public void addMessage( String newMessage )
	{
		message += newMessage + "\n";
	}
}
