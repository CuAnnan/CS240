package Philosopher;

import Semaphore.BinarySemaphore;

public abstract class AmbidextrousPhilosopher extends Philosopher
{
	BinarySemaphore left;
	BinarySemaphore right;
	public AmbidextrousPhilosopher(BinarySemaphore left, BinarySemaphore right, String name)
	{
		super(name);
		this.left = left;
		this.right = right;
	}
}
