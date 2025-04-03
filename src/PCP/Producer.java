package PCP;

import java.util.Date;

import Buffer.Buffer;

public class Producer implements Runnable
{
	private Buffer buffer;
	public Producer(Buffer b)
	{
		buffer = b;
	}
	
	public void run()
	{
		Date message;
		
		while(true)
		{
			message = new Date();
			try
			{
				Thread.sleep(1000);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			buffer.add(message);
			System.out.println("Added message "+message);
		}
	}
}
