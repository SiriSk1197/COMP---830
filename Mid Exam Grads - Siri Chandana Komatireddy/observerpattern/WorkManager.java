package observerpattern;

import java.util.ArrayList;

public class WorkManager implements Publisher {
		
		private ArrayList<Observer> observers = new ArrayList<Observer>(); 

		@Override
		public void addObserver(Observer o) {
			observers.add(o);
		}

		@Override
		public void removeObserver(Observer o) {
			observers.remove(o);
		}

		@Override
		public void notifyObserver(Event e) {
			while(true)
			{
				for (Observer o : observers)
				{
					Event workItem = o.notify(e);
					if (workItem != null)
					{
						System.out.printf("%s : Completed work on WorkItem %s\n", o.getID(), e.getItemID());
						e.incrementItemID();
						if (workItem.getWorkerID() > 4)
							break;
					}
				}
			}
		}
	
}
