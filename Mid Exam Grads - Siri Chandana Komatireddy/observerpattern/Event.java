package observerpattern;

public interface Event {
	
public long getItemID();
	
	public long getWorkerID();
	
	public String getMessage();

	public void incrementItemID();

}

