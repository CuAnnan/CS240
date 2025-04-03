package Philosopher;

public abstract class Philosopher extends Thread
{
	String name;
	
	public Philosopher(String name)
	{
		this.name = name;
	}
	
	public abstract void eat();
	
	
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
