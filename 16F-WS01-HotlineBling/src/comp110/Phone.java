package comp110;

/**
 * Author: Izhan Ansari
 *
 * ONYEN: Izhan	
 *
 * Collaborator ONYEN(s): 
 *
 * UNC Honor Pledge: I certify that no unauthorized assistance has been received
 * or given in the completion of this work. I certify that I understand and
 * could now rewrite on my own, without assistance from collaborators or course
 * staff, the problem set code I am submitting.
 */
public class Phone {

	private String _brand;
	private double _power;
	private int _pin;
	private boolean _locked;
	
	public Phone ( String brand, double power, int pin) {
		_locked = true;
		_brand = brand;
		_power = power;
		_pin = pin;
	}
	//getters
		public String getBrand() {
			return _brand;
		}
		public double getPower() {
			return _power;
		}
		public boolean getLocked(){
			return _locked;
		}
		
	//methods
		public void charge (int minutes){
			_power = _power + minutes * 0.01;
			if (_power > 1.0){
				_power = 1.0;
				System.out.println("Yo, your battery got too much sauceeee!");
			}
		}
		
		public void drain (double amount){
			_power = _power - amount;
			if (_power < 0){
				_power = 0;
				System.out.println("burh...you got too LITTLE sauceeee :(");
			}
		}
		
		public boolean unlock (int pin){
			if (pin == _pin){
				_locked = false;
				return true;
			}
			else {
				_locked = true;
				this.drain(0.01);
				System.out.println("You taking L's fam. Wrong PIN resulted in battery decreasing.");
				return false;
			}
		}
		
		public void lock(){
			_locked = true;
			this.drain(0.005);
			System.out.println(_locked);
			
		}
		
		public void changePin(int oldPin, int newPin){
			if (oldPin == _pin){
				_pin = newPin;
				System.out.println("PIN has been successfully changed.");
				this.drain(0.02);
			}
			else{
				System.out.println("DJ Khaled got the keys, but you aint even got the right PIN. Try a different PIN input.");
			}
		}
		
		public int addSquares(int x, int y){
			return (x*x)+(y*y);
		}
		
		public double displacement(double vi, double vf, double t){
			double d = 0.5*(vi + vf)*t;
			return d;
		}
		
		public void sendText (int number, String message){
			if (_locked == true){
				System.out.println("Sorry! This phone is locked.");
			}
			else if(number < 1000000 || number >= 10000000){
				System.out.println("Message failed to send.");
			}
			else if(number >= 1000000 || number <10000000){
				System.out.println("You have sent ''" + message + "'' to "+ number + ".");
				this.drain(0.01);
				System.out.println("Your battery has gone down to " + _power);
			}
				
		}

	
}