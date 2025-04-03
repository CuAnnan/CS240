package Philosopher;

import Semaphore.BinarySemaphore;

public class GreedyPhilosopher extends Philosopher
{
	int left, right;
	boolean chopsticks[];
	BinarySemaphore mutex;
	int id;
	
	public void eat()
	{
		this.mutex.acquire();
		
		if(!this.chopsticks[this.left] && !this.chopsticks[this.right])
		{
			this.chopsticks[this.left]= true;
			this.chopsticks[this.right]=true;
		}
		int eatLength = (int)(Math.random() * 20000);
		System.out.println(this.name + " eating for "+eatLength+" seconds");
		try
		{
			sleep(eatLength);
		}
		catch(InterruptedException e) {}
		
		this.mutex.release();
	}
	
	public GreedyPhilosopher(String name, int id, boolean chopsticks[], BinarySemaphore mutex)
	{
		super(name);
		this.id = id;
		this.left = this.id;
		this.right = (this.left + 1)%this.chopsticks.length;
		
		this.mutex = mutex;
		this.chopsticks = chopsticks;
	}
	
	
	
	
}
