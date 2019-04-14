package unittests;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


public class TestInventory {
private Inventory testObj;
	
	@BeforeEach
	public void setUp()
	{
		testObj = Mockito.spy(new Inventory());
	}
	
	@Test
	public void testAddItem()
	{
		Inventory mock = Mockito.mock(Inventory.class);
		Mockito.when(mock.getWeight()).thenReturn(8);
		Mockito.when(mock.getCount()).thenReturn(2);
		
		InventoryItem item1 = new InventoryItem("Computer", 7, "Laptop", 10);
		InventoryItem item2 = new InventoryItem("Stationary", 1, "Pencil", 50);
		testObj.addItemToInventory(item1);
		testObj.addItemToInventory(item2);
		
		assertEquals(mock.getWeight(), testObj.getWeight());
		assertEquals(mock.getCount(), testObj.getCount());
		
		InventoryItem item3 = new InventoryItem("Stationary", 251, "Books", 15);
		assertEquals(testObj.addItemToInventory(item3), false);
		
		Mockito.verify(testObj).addItemToInventory(item3);
		Mockito.verify(testObj).getWeight();
		Mockito.verify(testObj).getCount();
	}
	
	@Test
	public void testDropItem()
	{
		Inventory mock = Mockito.mock(Inventory.class);
		Mockito.when(mock.getWeight()).thenReturn(7);
		Mockito.when(mock.getCount()).thenReturn(1);
		
		InventoryItem item1 = new InventoryItem("Computer", 7, "Laptop", 10);
		InventoryItem item2 = new InventoryItem("Stationary", 1, "Pencil", 50);
		testObj.addItemToInventory(item1);
		testObj.addItemToInventory(item2);
		testObj.dropInventoryItem(item2);
		
		assertEquals(mock.getWeight(), testObj.getWeight());
		assertEquals(mock.getCount(), testObj.getCount());
		
		assertEquals(testObj.dropInventoryItem(item2), false);
		
	}

}
