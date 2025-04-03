package Philosopher;

import Semaphore.BinarySemaphore;

public class Philosopher extends Thread
{
	BinarySemaphore left;
	BinarySemaphore right;
	String name;
	
	public Philosopher(BinarySemaphore left, BinarySemaphore right, String name)
	{
		this.left = left;
		this.right = right;
		this.name = name;
	}
	
	public void eat()
	{
		int eatLength = (int)(Math.random() * 20000);
		System.out.println(this.name + " eating for "+eatLength+" seconds");
		try
		{
			sleep(eatLength);
		}
		catch(InterruptedException e) {}
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
			this.left.acquire();
			this.right.acquire();
			
			eat();
			
			this.right.release();
			this.left.release();
			
			think();
			
		}
	}
}
