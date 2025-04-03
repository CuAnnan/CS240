import Buffer.Buffer;
import PCP.Consumer;
import PCP.Producer;

public class SemaphoreTest
{
	public static void main(String[] args)
	{
		Buffer b = new Buffer();
		
		Thread producer1 = new Thread(new Producer(b));
		Thread consumer1 = new Thread(new Consumer(b));
		
		producer1.start();
		consumer1.start();
		
	}
}
