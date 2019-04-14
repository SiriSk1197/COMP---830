package observerpattern;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Worker w1 = new Worker(1);
		Worker w2 = new Worker(2);
		Worker w3 = new Worker(3);
		Worker w4 = new Worker(4);
		WorkManager wm = new WorkManager();
		wm.addObserver(w1);
		wm.addObserver(w2);
		wm.addObserver(w3);
		wm.addObserver(w4);
		
		WorkItem wi1 = new WorkItem(1,1,"This is WorkItem1");
		wm.notifyObserver(wi1);
		
		
		WorkItem wi2 = new WorkItem(3,3,"This is WorkItem3");
		wm.notifyObserver(wi2);
		
		WorkItem wi3 = new WorkItem(5,5,"This is WorkItem5");
		wm.notifyObserver(wi3);

	}

}
