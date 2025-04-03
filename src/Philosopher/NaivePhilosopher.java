package Philosopher;

import Semaphore.BinarySemaphore;

public class NaivePhilosopher extends AmbidextrousPhilosopher
{
	
	public NaivePhilosopher(BinarySemaphore left, BinarySemaphore right, String name)
	{
		super(left, right, name);
	}
	
	public void eat()
	{
		this.left.acquire();
		this.right.acquire();
		
		
		int eatLength = (int)(Math.random() * 20000);
		System.out.println(this.name + " eating for "+eatLength+" seconds");
		try
		{
			sleep(eatLength);
		}
		catch(InterruptedException e) {}
		
		this.right.release();
		this.left.release();
		
	}
	
	
}
