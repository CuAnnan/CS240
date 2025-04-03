package PCP;

import java.util.Date;

import Buffer.Buffer;

public class Consumer implements Runnable
{
	private Buffer buffer;
	
	public Consumer(Buffer b)
	{
		buffer = b;
	}
	
	public void run()
	{
		Date message;
		
		while(true)
		{
			try
			{
				Thread.sleep(200);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			message = (Date)buffer.remove();
			System.out.println("Got a message of "+message);
		}
	}
}
