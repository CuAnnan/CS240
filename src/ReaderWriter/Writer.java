package ReaderWriter;

import ReaderWriter.AccessManager.AccessManager;

public class Writer extends Thread
{
	AccessManager manager;
	String name;
	
	public Writer(AccessManager manager, String name)
	{
		this.manager = manager;
		this.name  = name;
	}
	
	public void write()
	{
		this.manager.acquireWriteLock();
		int writeLength = (int)(Math.random() * 2000);
		System.out.println(this.name + " writing for "+writeLength+" seconds");
		try
		{
			sleep(writeLength);
		}
		catch(InterruptedException e) {}
		this.manager.releaseWriteLock();
	}
	
	public void run()
	{
		while(true)
		{
			this.write();
		}
	}
}
