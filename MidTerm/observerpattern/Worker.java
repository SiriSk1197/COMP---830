package observerpattern;

public class Worker implements Observer{
		
		private long workerID;
		
		public Worker(long workerID)
		{
			this.workerID = workerID;
		}

		@Override
		public long getID() {
			return this.workerID;
			
		}

		@Override
		public Event notify(Event e) {
			if(e.getItemID() == workerID)
			{
				System.out.printf("Worker %s processed WorkItem %s message %s\n", workerID, e.getItemID(), e.getMessage());
				return e;
			}
			else
			{
				return null;
			}
		}
	
}

