package ReaderWriter;

import ReaderWriter.AccessManager.AccessManager;

public class Reader extends Thread
{
	AccessManager manager;
	String name;
	
	public Reader(AccessManager manager, String name)
	{
		this.manager = manager;
		this.name = name;
	}
	
	public void read()
	{
		manager.acquireReadLock();
		int readLength = (int)(Math.random() * 2000);
		System.out.println(this.name + " reading for "+readLength+" seconds");
		try
		{
			sleep(readLength);
		}
		catch(InterruptedException e) {}
		manager.releaseReadLock();
	}
	
	public void run()
	{
		while(true)
		{
			this.read();
		}	
	}
	
}
