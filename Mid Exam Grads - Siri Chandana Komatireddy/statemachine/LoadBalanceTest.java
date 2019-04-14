package statemachine;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
public class LoadBalanceTest {
LoadBalancerMachine loadbal = new LoadBalancerMachine();
	
	LoadBalancerState ready = null;
	LoadBalancerState unknown = null;
	LoadBalancerState down = null;
	LoadBalancerState disabled = null;
	
	StateUnknown stateunk = new StateUnknown(loadbal);
	StateReady stateready = new StateReady(loadbal);
	StateDisabled statedis = new StateDisabled(loadbal);
	StateDown statedown = new StateDown(loadbal);
	
	
	@Test
	void test_stateUnknown() {
		//Test case for state Unknown
		
		unknown = stateunk; 
		ready = loadbal.ready;
		down = loadbal.down; 
	
		
		assertEquals(unknown,loadbal.setState(stateunk)); // setState method will return the current state which must be equal to that state's object reference
		loadbal.serviceHealthCheckGood();
		assertEquals(ready,loadbal.state);
		loadbal.setState(stateunk);
		loadbal.serviceTimeout();
		assertEquals(down,loadbal.state);
		loadbal.setState(stateunk);
		loadbal.serviceHealthCheckBad();
		assertEquals(down,loadbal.state);
	}
		@Test
		void test_stateready() {
		
			ready = stateready; 
			unknown = loadbal.unknown;
			down = loadbal.down;
		    disabled = loadbal.disabled;
		
	    assertEquals(ready,loadbal.setState(stateready));
	    loadbal.serviceTimeout();
	    assertEquals(unknown,loadbal.state);
	    loadbal.setState(stateready);
	    loadbal.serviceHealthCheckBad();
	    assertEquals(down,loadbal.state);
	    loadbal.setState(stateready);
	    loadbal.serviceDisabled();
	    assertEquals(disabled,loadbal.state);
	}
}
