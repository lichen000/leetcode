package mangolost;

//Suppose we have a class:
//
//public class Foo {
//	public void first() { print("first"); }
//	public void second() { print("second"); }
//	public void third() { print("third"); }
//}
//	The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
//
//
//
//		Example 1:
//
//		Input: [1,2,3]
//		Output: "firstsecondthird"
//		Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
//		Example 2:
//
//		Input: [1,3,2]
//		Output: "firstsecondthird"
//		Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.
//
//
//		Note:
//
//		We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.

import java.util.concurrent.Semaphore;

/**
 *
 */
public class Solution1114 {

	public static void main(String[] args) {
		Foo foo = new Foo();
		Thread[] threads = new Thread[3];
		threads[0] = new Thread(() -> {
			try {
				foo.first(() -> {
					System.out.println("One");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		threads[1] = new Thread(() -> {
			try {
				foo.second(() -> {
					System.out.println("Two");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		threads[2] = new Thread(() -> {
			try {
				foo.third(() -> {
					System.out.println("Three");
				});
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		int[] input = {3,2,1};
		for (int i = 0; i < 3; i++) {
			threads[input[i] - 1].start();
		}
	}
}

class Foo {

	public Semaphore semaphore_first_second = new Semaphore(0);

	public Semaphore semaphore_second_third = new Semaphore(0);

	public Foo() {

	}

	public void first(Runnable printFirst) throws InterruptedException {

		// printFirst.run() outputs "first". Do not change or remove this line.
		printFirst.run();
		semaphore_first_second.release();
	}

	public void second(Runnable printSecond) throws InterruptedException {
		semaphore_first_second.acquire();
		// printSecond.run() outputs "second". Do not change or remove this line.
		printSecond.run();
		semaphore_second_third.release();
	}

	public void third(Runnable printThird) throws InterruptedException {
		semaphore_second_third.acquire();
		// printThird.run() outputs "third". Do not change or remove this line.
		printThird.run();
	}
}