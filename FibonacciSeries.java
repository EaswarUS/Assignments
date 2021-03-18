package learnjava;

public class FibonacciSeries {

	public static void main(String[] args) {

		int fm = 0;
		int sm = 1;

		for (int i = 1; i < 9; i++) {
			System.out.print(fm + " ");
			int sum = fm + sm;
			fm = sm;
			sm = sum;

		}

	}

}
