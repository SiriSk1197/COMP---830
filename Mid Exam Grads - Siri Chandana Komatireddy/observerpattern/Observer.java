package observerpattern;

public interface Observer {

public long getID();
	
	public Event notify(Event e);
}

public