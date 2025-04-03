package ReaderWriter.AccessManager;

public abstract class AccessManager
{
	public abstract void acquireReadLock();
	public abstract void acquireWriteLock();
	public abstract void releaseReadLock();
	public abstract void releaseWriteLock();
}
