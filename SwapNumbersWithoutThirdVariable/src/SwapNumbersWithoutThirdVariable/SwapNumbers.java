package SwapNumbersWithoutThirdVariable;

import java.util.Random;
import java.util.Scanner;

public class SwapNumbers {
	static int n1 = 0, n2 = 0;

	public static void main(String[] args) throws InterruptedException {
		System.out.println("ENTER TWO NUMBERS !!!\n");
		takeNumbers();
		System.out.println("\nNumber one = " + n1 + "\n" + "Number two = " + n2+"\n");
		swapNumbers();

	}

	private static void takeNumbers() {
		Scanner in = new Scanner(System.in);
		try {
			n1 = in.nextInt();
			n2 = in.nextInt();
			in.close();
		} catch (Exception e) {
			System.out.println("Please enter digits only !!!");
			takeNumbers();
		}

	}

	private static void swapNumbers() throws InterruptedException {
		System.out.print("Processing ");
		Thread.sleep(700);
		Random r = new Random();
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < r.nextInt(10) + 5; i++) {
					System.out.print(".");
					try {
						Thread.sleep(700);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				n1 = n1 + n2;
				n2 = n1 - n2;
				n1 = n1 - n2;
			}
		});
		t.start();
		t2.start();
		t.join();
		t2.join();

		System.out.println("\n\nNumber one = " + n1 + "\n" + "Number two = " + n2);

	}

}
