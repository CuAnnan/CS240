package Philosopher;

import Semaphore.BinarySemaphore;

public class DiningPhilosophers
{
	public static void main(String[] args)
	{
		BinarySemaphore chopstickSemaphores[] = new BinarySemaphore[5];
		Philosopher philosophers[] = new Philosopher[5]; 
		
		for(int i = 0; i < 5; i++)
		{
			chopstickSemaphores[i] = new BinarySemaphore();
		}
		
		for(int i = 0; i < 5; i++)
		{
			philosophers[i] = new NaivePhilosopher(chopstickSemaphores[i], chopstickSemaphores[(i+1)%5], "Philosopher "+(i+1));
			philosophers[i].start();
		}
		
		
		
	}
}
