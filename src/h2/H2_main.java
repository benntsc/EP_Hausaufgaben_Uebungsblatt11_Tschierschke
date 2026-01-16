package h2;

public class H2_main {
	// globales Cache-Array konstanter Länge
	private static long[] cache = new long[1000];

	public static void main(String[] args) {

	}

	public static void benchmark(int n) {

		long start, end, result;

		start = System.nanoTime();
		result = fibonacci(n);
		end = System.nanoTime();
		System.out.println("Fibonacci (rekursiv): " + result);
		System.out.println("Elapsed nanoseconds (fibonacci): " + (end - start));

		cache = new long[1000];

		start = System.nanoTime();
		result = fibonacciCached(n);
		end = System.nanoTime();
		System.out.println("Fibonacci (cached): " + result);
		System.out.println("Elapsed nanoseconds (fibonacciCached): " + (end - start));

		start = System.nanoTime();
		result = fibonacciIterative(n);
		end = System.nanoTime();
		System.out.println("Fibonacci (iterativ): " + result);
		System.out.println("Elapsed nanoseconds (fibonacciIterative): " + (end - start));
	}

	public static long fibonacci(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static long fibonacciCached(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		if (cache[n] != 0) {
			return cache[n];
		}

		cache[n] = fibonacciCached(n - 1) + fibonacciCached(n - 2);
		return cache[n];
	}

	public static long fibonacciIterative(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		long prev = 1;
		long curr = 1;

		for (int i = 3; i <= n; i++) {
			long next = prev + curr;
			prev = curr;
			curr = next;
		}

		return curr;
	}
}
