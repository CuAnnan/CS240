package Philosopher;

import Semaphore.BinarySemaphore;


public class ChiralPhilosopher extends AmbidextrousPhilosopher
{
	boolean odd;
	
	public void eat()
	{
		if(this.odd)
		{
			this.left.acquire();
			this.right.acquire();
		}
		else
		{
			this.right.acquire();
			this.left.acquire();
		}
		
		
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
	
	public ChiralPhilosopher(BinarySemaphore left, BinarySemaphore right, String name, boolean odd)
	{
		super(left, right, name);
		this.odd = odd;
	}
}
