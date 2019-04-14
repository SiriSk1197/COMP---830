package question3;
import java.util.ArrayList;


public class ExamQ3Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cookie cookie = new Cookie();
		CinnamanRoll cinnamanRoll = new CinnamanRoll();
		Brownie brownie = new Brownie();
		
		ArrayList<BakedGoods> bakedGoodsList = new ArrayList<BakedGoods>();
		bakedGoodsList.add(cookie);
		bakedGoodsList.add(cinnamanRoll);
		bakedGoodsList.add(brownie);
		
		for (BakedGoods bakedGood : bakedGoodsList) {
			System.out.println("Price: $" + bakedGood. getPrice());
			System.out.println("Description: " + bakedGood. getDescription());
			System.out.println("SellByDate: " + bakedGood. getSellByDate());
			
		}
	}

}
