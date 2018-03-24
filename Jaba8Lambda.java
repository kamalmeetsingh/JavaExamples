import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Jaba8Lambda {

	interface Operations{
		public int operate(int a, int b);
	}
	
	public static void main(String s[]) {
		System.out.println("Welcome to Lambdas");
		
		// A simplest form of lambda, same interface, multiple implementations without a class
		Operations sum = (int a, int b)->a+b;
		Operations multiple = (int a, int b)->a*b;
		
		//Java8Lambda obj= new Jaba8Lambda();
		int mysum = sum.operate(2, 3);
		System.out.println(mysum);
		int myproduct = multiple.operate(2, 3);
		System.out.println(myproduct);
		
		// Another example using Thread Runnable
		// Earlier you would create a Runnable
		
		Runnable myrun = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("starting:"+Thread.currentThread().getName());
			}
		};
		
		new Thread(myrun).start();
		
		// With Labdas we can do away with anonymous classes
		Runnable myrunLambda = ()->{
			System.out.println("starting:"+Thread.currentThread().getName());
		};
		new Thread(myrunLambda).start();
		
		// Lambdas can be used with streams as well
		List<Integer> intlist= new ArrayList<Integer>();
		intlist.add(2);
		intlist.add(7);
		intlist.add(12);
		intlist.add(17);
		Stream<Integer> stream = intlist.stream(); 
		stream.forEach(i->{
			if(i%2==0) {
				System.out.println(i+" is even.");
			}
		});

	}
}
