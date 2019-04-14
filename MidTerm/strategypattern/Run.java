package strategypattern;
import java.util.ArrayList;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookInformation obj1 = new BookInformation("J.K. Rowling",         "Harry Potter",        2001, "The magic world");
		BookInformation obj2 = new BookInformation("Jeff Kinney",          "The Meltdown",        2002, "Summary2");
		BookInformation obj3 = new BookInformation("Craig Smith",          "The Wonkey Donkey",   2003, "Summary3");
		BookInformation obj4 = new BookInformation("Stephen King",         "Elevation",           2004, "Summary4");		
		BookInformation obj5 = new BookInformation("Justin Timberlake",    "Hindsight",           2004, "Summary5");	
		BookInformation obj6 = new BookInformation("Allen Downey",         "Think Java",          2010, "Laern Java");
		BookInformation obj7 = new BookInformation("Allen Downey",         "Think Complexity",    2008, "Complexity Science and computational modelling");
		BookInformation obj8 = new BookInformation("Narasimha Karumanchi", "Data Structures",     2007, "Laern data structures");
		BookInformation obj9 = new BookInformation("Robert Sedgewick",     "Algorithms",          2011, "Laern algorithms");
		BookInformation obj10 = new BookInformation("Abraham Silberschatz","Operating Systems",   2004, "Laern OS");
		BookInformation obj11 = new BookInformation("Eric Gamma",          "Object Oriented Programming",     2007, "Laern OOP's");
		BookInformation obj12 = new BookInformation("Matt Wiesfeld",       "Object Oriented Thought Process", 2014, "Laern OOP's");
		BookInformation obj13 = new BookInformation("Sebastian Raschka",   "Python Machine Learning",         2015, "Laern ML");
		BookInformation obj14 = new BookInformation("Prentice Hall",       "Airtificial Intelligence",        1994, "Laern AI");
		BookInformation obj15 = new BookInformation("Sebastian Raschka",   "Learning Tableau",                2009, "Learn Tableau");
		BookInformation obj16 = new BookInformation("Jennifer Widom",      "Database Systems",                2013, "Laern Databases");
		BookInformation obj17 = new BookInformation("Yohan Wadia",         "AWS Administration",              2016, "Laern AWS");
		BookInformation obj18 = new BookInformation("Andrew Tanenbaum",    "Computer Networks",               1981, "Laern Computer Networks");
		BookInformation obj19 = new BookInformation("Brian Kernighan",     "The C language",                  1978, "Laern C");
		BookInformation obj20 = new BookInformation("Bjarne Stroustrup",   "The C++ Language",                1985, "Laern C++");
		
		
		ArrayList<BookInformation> bookObjects = new ArrayList<BookInformation>();
		bookObjects.add(obj1);
		bookObjects.add(obj2);
		bookObjects.add(obj3);
		bookObjects.add(obj4);
		bookObjects.add(obj5);
		bookObjects.add(obj6);
		bookObjects.add(obj7);
		bookObjects.add(obj8);
		bookObjects.add(obj9);
		bookObjects.add(obj10);
		bookObjects.add(obj11);
		bookObjects.add(obj12);
		bookObjects.add(obj13);
		bookObjects.add(obj14);
		bookObjects.add(obj15);
		bookObjects.add(obj16);
		bookObjects.add(obj17);
		bookObjects.add(obj18);
		bookObjects.add(obj19);
		bookObjects.add(obj20);
		
		
		BookLibrarian sortAuthor = new SortByAuthor();
		
		sortAuthor.setSortMethod(bookObjects);
		
		System.out.println("\n\n");
		
		BookLibrarian sortTitle = new SortByTitle();
		
		sortTitle.setSortMethod(bookObjects);
		
		System.out.println("\n\n");
		
		BookLibrarian sortPubYear = new SortByPubYear();
		
		sortPubYear.setSortMethod(bookObjects);
		
	}

}
