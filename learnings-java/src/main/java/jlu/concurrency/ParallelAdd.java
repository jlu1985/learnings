package jlu.concurrency;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ParallelAdd {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		OptionalInt sum = IntStream.rangeClosed(1, 1000000)
				.reduce((i1, i2) -> i1 + i2);

		System.out.println(sum);
		System.out.println(System.currentTimeMillis());
	}
}
