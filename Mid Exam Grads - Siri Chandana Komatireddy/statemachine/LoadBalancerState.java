package statemachine;

public interface LoadBalancerState {
	void serviceEnabled();
	void serviceDisabled();
	void serviceHealthCheckGood();
	void serviceHealthCheckBad();
	void serviceTimeout();
	
}

