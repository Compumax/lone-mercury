package com.dsitelecom.xmontero.compumax.lonemercury;

public class TimeLine
{
	private long startTime;
	private long lastIterationTime;
	private long currentTime;
	private int frames;

	public TimeLine( long startTime )
	{
		this.startTime = startTime;
		this.lastIterationTime = startTime;
		this.currentTime = startTime;
		this.frames = 0;
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

	public synchronized void setCurrentTime( long currentTime )
	{
		this.lastIterationTime = this.currentTime;
		this.currentTime = currentTime;
		this.frames++;
	}

	public long getCurrentTime()
	{
		return currentTime;
	}

	public long getLastIterationTime()
	{
		return lastIterationTime;
	}

	public int getFrames()
	{
		return frames;
	}

	public float getFps()
	{
		return frames / getTotalElapsedInSeconds();
	}
}
