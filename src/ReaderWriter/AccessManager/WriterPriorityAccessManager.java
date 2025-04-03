package ReaderWriter.AccessManager;


import Semaphore.BinarySemaphore;

public class WriterPriorityAccessManager extends AccessManager
{
	BinarySemaphore writerMutex, readerMutex;
	BinarySemaphore writerCountMutex, readerCountMutex;
	BinarySemaphore contentionMutex;
	int readerCount, writerCount;
	
	public WriterPriorityAccessManager()
	{
		this.writerMutex = new BinarySemaphore();
		this.readerMutex = new BinarySemaphore();
		this.writerCountMutex = new BinarySemaphore();
		this.readerCountMutex = new BinarySemaphore();
		this.contentionMutex = new BinarySemaphore();
		this.readerCount = 0;
		this.writerCount = 0;
	}
	
	public void acquireReadLock()
	{
		this.contentionMutex.acquire();
		this.readerMutex.acquire();
		
		this.readerCountMutex.acquire();
		if(++this.readerCount == 1)
		{
			this.writerMutex.acquire();
		}
		this.readerCountMutex.release();
		
		this.readerMutex.release();
		this.contentionMutex.release();
	}
	
	public void releaseReadLock()
	{
		this.readerCountMutex.acquire();
		if(--this.readerCount == 0)
		{
			this.writerMutex.release();
		}
		this.readerCountMutex.release();
		
	}
	
	public void acquireWriteLock()
	{
		this.writerCountMutex.acquire();
		
		if(++this.writerCount == 1)
		{
			this.readerMutex.acquire();
		}

		this.writerCountMutex.release();
		this.writerMutex.acquire();
	}
	
	public void releaseWriteLock()
	{
		this.writerCountMutex.acquire();
		
		if(--this.writerCount == 0)
		{
			this.readerMutex.release();
		}
		
		this.writerCountMutex.release();
		this.writerMutex.release();
	}
	
}
