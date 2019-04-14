package strategypattern;

import java.util.ArrayList;
import java.util.Collections;

public class SortByAuthor implements BookLibrarian {
	@Override
	public void setSortMethod(ArrayList bookObjects)
	{
		Collections.sort(bookObjects, BookInformation.compareAuthor);
		for(int i=0; i<bookObjects.size(); i++)
		{
			System.out.printf("Object : %s\tTitle : %s\t\tAuthor : %s\tYearPub : %d\tSummary : %s\n",bookObjects.get(i), ((BookInformation) bookObjects.get(i)).getBookTitle(), ((BookInformation) bookObjects.get(i)).getBookAuthor(), ((BookInformation) bookObjects.get(i)).getBookYearPub(), ((BookInformation) bookObjects.get(i)).getBookSummary());
		}
	}

}
