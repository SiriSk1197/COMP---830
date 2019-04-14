package unittests;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestInventoryItem {
	private InventoryItem testItem1;
	private InventoryItem testItem2;
	
	@BeforeEach
	public void setUp()
	{
		testItem1 = new InventoryItem("Computer", 7, "Laptop", 10);
		testItem2 = new InventoryItem("Stationary", 1, "Pencil", 50);
	}
	
	@Test
	public void testGetters()
	{
		InventoryItem spy = Mockito.spy(testItem1);
		InventoryItem mock = Mockito.mock(InventoryItem.class);
		Mockito.when(mock.getName()).thenReturn("Laptop");
		Mockito.when(mock.getWeight()).thenReturn(7);
		Mockito.when(mock.getType()).thenReturn("Computer");
		Mockito.when(mock.getCount()).thenReturn(10);
		
		assertEquals(mock.getName(), spy.getName());
		assertEquals(mock.getWeight(), spy.getWeight());
		assertEquals(mock.getCount(), spy.getCount());
		assertEquals(mock.getType(), spy.getType());
		
		Mockito.verify(spy).getName();
		Mockito.verify(spy).getWeight();
		Mockito.verify(spy).getCount();
		Mockito.verify(spy).getType();
	}
	
	@Test
	public void testInventoryItem()
	{
		InventoryItem mock = Mockito.mock(InventoryItem.class);
		Mockito.when(mock.toString()).thenReturn("Pencil type (Stationary), wt: 1, there are 50 left");
		String test_variable = testItem2.toString();
		assertEquals(test_variable, mock.toString());
	}
}
