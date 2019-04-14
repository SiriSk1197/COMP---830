package statemachine;

public class StateReady implements LoadBalancerState {


	LoadBalancerMachine loadbalance;

	public StateReady(LoadBalancerMachine loadbalance) {
		this.loadbalance = loadbalance;

	}
	

	@Override
	public void serviceEnabled() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void serviceDisabled() {
		// TODO Auto-generated method stub
		System.out.println("Changed to state Disabled");
		loadbalance.setState(loadbalance.disabled);
	}


	@Override
	public void serviceHealthCheckGood() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void serviceHealthCheckBad() {
		// TODO Auto-generated method stub
		
		System.out.println("Changed to state Down");
		loadbalance.setState(loadbalance.down);
	}


	@Override
	public void serviceTimeout() {
		// TODO Auto-generated method stub
		
		System.out.println("Changed to state Unknown");
		loadbalance.setState(loadbalance.unknown);
		
	}
	

}
