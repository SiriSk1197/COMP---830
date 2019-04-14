package question3;

public class Cookie implements BakedGoods  {

	private int price = 10;
	private String description = "Cookie";
	private String sellByDate = "04/19/2019";
	
	public Cookie(int price, String Description, String SellByDate) {
		this.price = price;
		this.description = description;
		this.sellByDate = sellByDate;
		
	}
	
	public Cookie() {
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
