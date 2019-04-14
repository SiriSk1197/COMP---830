package question3;

public class CinnamanRoll implements BakedGoods  {
	
	private int price = 5;
	private String description = "CinnamanRoll";
	private String sellByDate = "04/19/2019";
	
	public CinnamanRoll(int price, String Description, String SellByDate) {
		this.price = price;
		this.description = description;
		this.sellByDate = sellByDate;
		
	}
	
	public CinnamanRoll() {
	}
	public int getPrice() {
		return price;
	}
	public String getDescription() {
		return description;
	}
	public String getSellByDate() {
		return sellByDate;
		
				
	}
}
