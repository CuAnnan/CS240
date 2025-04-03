package ReaderWriter;

//import ReaderWriter.AccessManager.ReaderPriorityAccessManager;
import ReaderWriter.AccessManager.WriterPriorityAccessManager;

public class ReaderWriterProblem
{
	public static void main(String[] args)
	{
//		ReaderPriorityAccessManager manager = new ReaderPriorityAccessManager();
		WriterPriorityAccessManager manager = new WriterPriorityAccessManager();
		
		Reader reader1 = new Reader(manager, "Reader 1");
		Reader reader3 = new Reader(manager, "Reader 3");
		Reader reader2 = new Reader(manager, "Reader 2");
		Reader reader4 = new Reader(manager, "Reader 4");
		Writer writer1 = new Writer(manager, "Writer");
		
		reader1.start();
		reader2.start();
		reader3.start();
		reader4.start();
		writer1.start();
		
		
		
		
	}
}
