package question3;

public class Brownie implements BakedGoods {

		private int price = 15;
		private String description = "Browine";
		private String sellByDate = "04/19/2019";
		
		public Brownie(int price, String Description, String SellByDate) {
			this.price = price;
			this.description = description;
			this.sellByDate = sellByDate;
			
		}
		
		public Brownie() {
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
