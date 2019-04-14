package observerpattern;

public interface Publisher {
	
public void addObserver(Observer o);
	
	public void removeObserver(Observer o);
	
	public void notifyObserver(Event e);

	
}
