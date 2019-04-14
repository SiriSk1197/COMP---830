package statemachine;
import java.util.Scanner;
public class LoadBalanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoadBalancerState ready = null;
		LoadBalancerState unknown = null;
		LoadBalancerState down = null;
		LoadBalancerState disabled = null; 

		LoadBalancerMachine loadbalance = new LoadBalancerMachine();
		StateUnknown stateunk = new StateUnknown(loadbalance);
		StateReady stateready = new StateReady(loadbalance);
		StateDisabled statedis = new StateDisabled(loadbalance);
		StateDown statedown = new StateDown(loadbalance);

		String transition;
		System.out.println("Please Enter the State Transition: \n Select Type a for - Health check is good "
				+ "\n Select Type b for - Service health check times out" + "\n Select Type c for - Health check is bad"
				+ "\n Select Type d for - Service Enabled \n Select Type e for - Service disabled by user");
		while (true) {
			Scanner reader = new Scanner(System.in);

			transition = reader.nextLine();

			if (transition.equals("a")) {

				stateunk.serviceHealthCheckGood();
				transition = reader.nextLine();

				if (transition.equals("b")) {

					stateready.serviceTimeout();
					unknown = stateunk;
				}

				else if (transition.equals("c")) {

					stateready.serviceHealthCheckBad();
					down = statedown;
					transition = reader.nextLine();
					if (transition.equals("a")) {
						statedown.serviceHealthCheckGood();

					} else {
						System.out.println("Sorry! Cannot change state");
					}

				}

				else if (transition.equals("d") || transition.equals("e")) {

					System.out.println("Sorry! Cannot change state");

				}

			}

			else if (transition.equals("b") || transition.equals("c")) {

				stateunk.serviceTimeout();
				transition = reader.nextLine();

				if (transition.equals("a")) {
					statedown.serviceHealthCheckGood();
					transition = reader.nextLine();
					if (transition.equals("e")) {

						stateready.serviceDisabled();
						transition = reader.nextLine();

						if (transition.equals("d")) {

							statedis.serviceEnabled();
						}

					}

				} else {
					System.out.println("Sorry! Cannot change state");
				}

			}

			else {

				System.out.println("This is not a valid transition. Please try again!");
			}
			//reader.close();
		}
	}
	
	}


