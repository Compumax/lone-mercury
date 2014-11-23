package com.dsitelecom.xmontero.compumax.lonemercury;

public class TimeLine
{
	private long startTime;
	private long lastIterationTime;
	private long currentTime;

	public TimeLine( long startTime )
	{
		this.startTime = startTime;
		this.lastIterationTime = startTime;
		this.currentTime = startTime;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime( long startTime )
	{
		this.startTime = startTime;
	}

	public long getTotalElapsedInNanos()
	{
		return currentTime - startTime;
	}

	public float getTotalElapsedInSeconds()
	{
		return getTotalElapsedInNanos() / 1000000000.0f;
	}

	public long getIterationElapsedInNanos()
	{
		return currentTime - lastIterationTime;
	}

	public float getIterationElapsedInSeconds()
	{
		return getIterationElapsedInNanos() / 1000000000.0f;
	}

	public void setCurrentTime( long currentTime )
	{
		this.lastIterationTime = this.currentTime;
		this.currentTime = currentTime;
	}

	public long getCurrentTime()
	{
		return currentTime;
	}

	public long getLastIterationTime()
	{
		return lastIterationTime;
	}
}
