package statemachine;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ packageLoadBalance.LoadBalancerMachine.class })
public class TestMockLB {
LoadBalancerMachine loadbalance = new LoadBalancerMachine();
	
	//stateDisabled statedis = new stateDisabled(loadbalance);
	
	@Test
	public void testClassDisabled() {

		LoadBalancerState	disabled = loadbalance.disabled;
		LoadBalancerState	unknown = loadbalance.unknown;
		LoadBalancerState result = null;
		
		try {
			result = Whitebox.invokeMethod(loadbalance, "setState", disabled);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(result,disabled);
		loadbalance.serviceEnabled();
		
		try {
			result = Whitebox.invokeMethod(loadbalance, "setState", unknown);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(result,unknown);
		
		
	}
	@Test
	public void testClassDown() {

		LoadBalancerState	down = loadbalance.down;
		LoadBalancerState	ready = loadbalance.ready;
		LoadBalancerState result = null;
		
		try {
			result = Whitebox.invokeMethod(loadbalance, "setState", down);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(result,down);
		loadbalance.serviceHealthCheckGood();
		
		try {
			result = Whitebox.invokeMethod(loadbalance, "setState", ready);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertEquals(result,ready);
				
	}

}
