package observerpattern;

public class WorkItem implements Event {
		
		private long itemID;
		private long workerID;
		private String message;
		
		public WorkItem(long itemID, long workerID, String message)
		{
			this.itemID = itemID;
			this.workerID = workerID;
			this.message = message;
		}
		
		@Override
		public long getItemID()
		{
			return this.itemID;
		}
		
		@Override
		public long getWorkerID()
		{
			return this.workerID;
		}
		
		@Override
		public String getMessage()
		{
			return this.message;
		}

		@Override
		public void incrementItemID() {
			itemID ++;
			
		}


}
