package Buffer;

import Semaphore.BinarySemaphore;
import Semaphore.Semaphore;

public class Buffer
{
	private int bufferSize;
	private Object[] contents;
	private int in, out;
	
	private Semaphore full;
	private Semaphore empty;
	private BinarySemaphore mutex;
	
	public Buffer()
	{
		this(5);
	}
	
	public Buffer(int size)
	{
		bufferSize = size;
		contents = new Object[size];
		in = 0;
		out = 0;
		full = new Semaphore(0);
		empty = new Semaphore(size);
		mutex = new BinarySemaphore();
	}
	
	public void add(Object o)
	{
		this.empty.acquire();
		
		this.mutex.acquire();
		this.contents[in] = o;
		in += 1;
		in %= bufferSize;
		this.mutex.release();
		
		
		this.full.release();
	}
	
	public Object remove()
	{
		this.full.acquire();
		
		this.mutex.acquire();
		Object o = this.contents[out];
		out += 1;
		out %= bufferSize;
		this.mutex.release();
		
		this.empty.release();
		
		return o;
	}
	
	
	
	
	
	
}
