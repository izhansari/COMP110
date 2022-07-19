package comp110;

public class HotlineBling {
  public static void main(String[] args) {
    /*
     * Create new instance of Phone, name it testPhone, and pass in any brand, a
     * power of 0.5 (meaning 50%), and PIN of 110. Note: do this before the
     * print statement
     */
    // TODO: A.4 Declare a variable named testPhone of type Phone.
	  Phone testPhone;
	  testPhone = new Phone("Apple", 0.5, 110);
    // TODO: A.4 Uncomment this next line:
     System.out.println("A new phone of brand " + testPhone.getBrand() + " has been constructed. Current power: " 
     + testPhone.getPower() + ".");

    /*
     * charge() Charge your phone for 10 minutes and print your power.
     */
    // TODO: B.0.2 test charge here
    System.out.println("The power after charging for 10 minutes is:");
    testPhone.charge(10);
    System.out.println(testPhone.getPower()); // TODO: call getPower method on your phone and print the power
    System.out.println("");

    /*
     * charge() Charge your test phone for 50 minutes and print your power.
     */
    // TODO: B.0.2 test charge here
    System.out.println("The power after charging for another 50 minutes is:");
    testPhone.charge(50);
    System.out.println(testPhone.getPower()); // TODO: print power here
    System.out.println("");

    /*
     * drain() Drain your test phone's power by 60 percent and print its power.
     */
    // TODO: B.1.1 decrease power here
    System.out.println("The power after decreasing the power by 60 percent is:");
    testPhone.drain(0.60);
    System.out.println(testPhone.getPower()); // TODO: print power here
    System.out.println("");

    // TODO: Print your own debug messages for the next lines:
    // TODO: B.1.1 drain power past 0.0 and check to ensure power is 0.0
    // TODO: B.0.2 increase power back up to a useful amount
    System.out.println("If the battery decreases by an extra 70 percent, the power level will be:");
    testPhone.drain(0.70);
    System.out.println(testPhone.getPower());
    System.out.println("");
    testPhone.charge(100);

    /*c
     * unlock() Unlock your phone with the PIN 121. How did this affect your
     * phone's power?
     */
    // TODO: B.2.2 unlock phone with 121
    System.out.println("You have charged your phone back to 100%. The power after using 121 to unlock phone: ");
    System.out.println(testPhone.unlock(121)); // TODO: print whether the phone is unlocked
    System.out.println(testPhone.getPower()); // TODO: print power
    System.out.println("");


    /*
     * unlock() Unlock your phone with the PIN 110. How did this affect your
     * phone's power?
     */
    // TODO: B.2.2 unlock phone with 110
    System.out.println("The power after using 110 to unlock phone: ");
    System.out.println(testPhone.unlock(110)); // TODO: print whether the phone is unlocked
    System.out.println(testPhone.getPower()); // TODO: print power
    System.out.println("");


    // TODO: B.3.1 test the lock method
	System.out.println("You have locked your phone:");
	testPhone.lock();
	System.out.println(testPhone.getPower());
	System.out.println("");

    /*
     * changePin() Change your phone's PIN to any number! Remember the power
     * should be decreasing.
     * 
     * How would you check to be sure that your PIN changed?
     */
    // TODO: B.4.2 change PIN
    System.out.println("The power after chainging PIN: ");
    testPhone.changePin(110, 101);
    System.out.println(testPhone.getPower()); // TODO: print power
    System.out.println("");

    // TODO: B.4.2 change PIN with the wrong old PIN and test for yourself
    System.out.println("The power after trying to change PIN with wrong initial PIN:");
    testPhone.changePin(999, 111);
    System.out.println(testPhone.getPower());
    System.out.println("");


    /*
     * sendText() Send a nice message to any number you would like to brighten
     * their day by calling sendText.
     */
    // TODO: call sendText method
    System.out.println("A message will be sent to a 7 digit number:");
    testPhone.unlock(101);
    testPhone.sendText(7717863, "suck me bro");
    
    
    
    
    boolean bool;
    bool= true;
    if (bool){
    	System.out.println("if");
    }
    else {
    	System.out.println("else");
    }
    
    System.out.println(testPhone.displacement(2, 3, 4));
    
    String StringA= "yoooo ";
    String StringB= "suhhhhh";
    System.out.println(StringA.toUpperCase() + StringB.toUpperCase());
    
    
  }
}
