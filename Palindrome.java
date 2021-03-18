package learnjava;

public class Palindrome {

	public static void main(String[] args) {
		String str = "MADAM";
		String rev ="";
		char[] charArray = str.toCharArray();
		for (int i = charArray.length-1; i >=0 ; i--) {
			rev = rev + charArray[i]+"";
			
			
		}
		if (str.equals(rev)) {
			System.out.println("Palindrome");
			
		}
		else 
			System.out.println("Not an Palindrome");

	}

}
