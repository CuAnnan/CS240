package Semaphore;

public class Semaphore
{
	private int value;
	
	public Semaphore(int value)
	{
		this.value = value;
	}
	
	public synchronized void acquire()
	{
		while(this.value <= 0)
		{
			try
			{
				wait();
			}
			catch(InterruptedException e) {}
		}
		this.value --;
	}
	
	public synchronized void release()
	{
		this.value ++;
		notify();
	}
}
