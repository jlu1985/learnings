package jlu.concurrency;

public class SimpleAdd {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		int sum = 0;
		for (int i = 1 ; i<=1000000; i+=2){
			sum += i;
		}
		
		System.out.println(sum);
		System.out.println(System.currentTimeMillis());
	}
}
