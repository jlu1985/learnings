package jlu.concurrency;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongWait {
	private static final Logger l = LoggerFactory.getLogger(LongWait.class);

	private static class Sub {
		void doTask(int i) {
			l.debug("Doing {}", i);
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			l.debug("Done {}", i);
		}
	}

	public static void main(String[] args)
			throws InterruptedException, ExecutionException {
		Sub s = new Sub();
		List<Integer> tasks = IntStream.range(0, 50).boxed()
				.collect(Collectors.toList());

		l.info("Sequential start");
		tasks.forEach(i -> s.doTask(i));
		l.info("Sequential done");

		l.info("ParallelStream start");
		tasks.parallelStream().forEach(i -> s.doTask(i));
		l.info("ParallelStream end");

		l.info("ForkJoin start");
		new ForkJoinPool(50)
				.submit(() -> tasks.parallelStream().forEach(i -> s.doTask(i)))
				.get();
		l.info("ForkJoin end");
	}
}
