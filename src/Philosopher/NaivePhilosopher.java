package Philosopher;

import Semaphore.BinarySemaphore;

public class NaivePhilosopher extends Thread
{
	BinarySemaphore left;
	BinarySemaphore right;
	String name;
	
	public NaivePhilosopher(BinarySemaphore left, BinarySemaphore right, String name)
	{
		this.left = left;
		this.right = right;
		this.name = name;
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
	
	public void think()
	{
		int thinkLength = (int)(Math.random() * 10000);
		System.out.println(this.name  +" thinking for "+thinkLength+" seconds");
		try
		{
			sleep(thinkLength);
		}
		catch(InterruptedException e) {}
	}
	
	public void run()
	{
		while(true)
		{
			
			eat();
			
			think();
			
		}
	}
}
