package strategypattern;
import java.util.Comparator;
public class BookInformation {
	private String author;
	private String title;
	private int yearPublished;
	private String summary;
		
	
	public BookInformation(String author, String title, int pubDate, String summary)
	{
		this.author = author;
		this.title = title;
		this.yearPublished = pubDate;
		this.summary = summary;
	}
	
	public String getBookTitle()
	{
		return this.title;
	}
	
	public String getBookAuthor()
	{
		return author;
	}
	
	public int getBookYearPub()
	{
		return yearPublished;
	}
	
	public String getBookSummary()
	{
		return summary;
	}
	

	public static Comparator<BookInformation> compareAuthor = new Comparator<BookInformation>() {

		@Override
		public int compare(BookInformation o1, BookInformation o2) {
			String b1 = o1.getBookAuthor().toUpperCase();
			String b2 = o2.getBookAuthor().toUpperCase();
			
			return b1.compareTo(b2);
		}
	};
	
	public static Comparator<BookInformation> compareTitle = new Comparator<BookInformation>() {

		@Override
		public int compare(BookInformation o1, BookInformation o2) {
			String b1 = o1.getBookTitle().toUpperCase();
			String b2 = o2.getBookTitle().toUpperCase();
			
			return b1.compareTo(b2);
		}
	};
	
	public static Comparator<BookInformation> compareYearPub = new Comparator<BookInformation>() {

		@Override
		public int compare(BookInformation o1, BookInformation o2) {
			return o1.yearPublished - o2.yearPublished;
		}
	};

}
