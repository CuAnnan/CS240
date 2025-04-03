package Philosopher;

import Semaphore.BinarySemaphore;

public class DiningPhilosophers
{
	public static void main(String[] args)
	{
		BinarySemaphore chopsticks[] = new BinarySemaphore[5];
		NaivePhilosopher philosophers[] = new NaivePhilosopher[5]; 
		
		for(int i = 0; i < 5; i++)
		{
			chopsticks[i] = new BinarySemaphore();
		}
		
		for(int i = 0; i < 5; i++)
		{
			philosophers[i] = new NaivePhilosopher(chopsticks[i], chopsticks[(i+1)%5], "Philosopher "+(i+1));
			philosophers[i].start();
		}
		
		
	}
}
