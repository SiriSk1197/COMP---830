package statemachine;

public class LoadBalancerMachine {

	LoadBalancerState unknown, ready, disabled, down;
	LoadBalancerState state = null;
	
	public LoadBalancerMachine() {

		unknown = new StateUnknown(this);
		ready = new StateReady(this);
		disabled = new StateDisabled(this);
		down = new StateDown(this);

		state = unknown;
	}

	public void serviceEnabled() {

		state.serviceEnabled();

	}

	
   public void serviceDisabled() {	

		state.serviceDisabled();
        
	}

	public void serviceHealthCheckGood() {

		state.serviceHealthCheckGood();

	}
   
	
	public void serviceHealthCheckBad() {
		
		
		state.serviceHealthCheckBad();
	}
	
	
	public void serviceTimeout() {
		
		state.serviceTimeout(); 
	}
	

	public LoadBalancerState setState(LoadBalancerState state) { // Allows other objects to transition the machine to a different state

		this.state = state;
		return state;
	}
 
}
