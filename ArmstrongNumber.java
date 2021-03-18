package learnjava;

public class ArmstrongNumber {

	public static void main(String[] args) {
		int orginal = 153;
		int source = orginal;
		int arm = 0;
		 while(orginal>0) {
			 int eachDigit = orginal%10;
			 int eachDigitCube = eachDigit*eachDigit*eachDigit;
			 arm = arm + eachDigitCube;
			 orginal = orginal/10;
			 
		 } 
		 if (arm == source) {
			 System.out.println("The number Is an Armstrong Number");
			
		}
		 else {
			 System.out.println("The number Is not an Armstrong Number");
		 }
		
		

	}

}
