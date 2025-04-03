package ReaderWriter.AccessManager;

import Semaphore.BinarySemaphore;

public class ReaderPriorityAccessManager extends AccessManager
{
	BinarySemaphore wrt;
	BinarySemaphore mutex;
	int readerCount;
	
	public ReaderPriorityAccessManager()
	{
		this.readerCount = 0;
		this.wrt = new BinarySemaphore();
		this.mutex = new BinarySemaphore();
	}
	
	public void acquireReadLock()
	{
		mutex.acquire();
		
		if(++readerCount == 1)
		{
			wrt.acquire();
		}
		
		mutex.release();
	}
	
	public void releaseReadLock()
	{
		mutex.acquire();
		
		if(--readerCount == 0)
		{
			wrt.release();
		}
		
		mutex.release();
	}
	
	public void acquireWriteLock()
	{
		wrt.acquire();
	}
	
	public void releaseWriteLock()
	{
		wrt.release();
	}
}
