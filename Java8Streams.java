import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Streams {
	
	public static void main(String s[]) {
		System.out.println("Welcome to streams!");
		
		//There are multiple ways to create streams
		Stream<Integer> stream = Stream.of(new Integer[]{1,2,3,4}); 
		Stream<Integer> intStream = Stream.of(1,2,3,4);


		// Using streams to find sum of a integer list
		List<Integer> intlist= new ArrayList<Integer>();
		intlist.add(2);
		intlist.add(7);
		intlist.add(12);
		intlist.add(17);
		Stream<Integer> streamnew = intlist.stream(); 
		
		// No more looping through the array
		Integer sum = intlist.stream().mapToInt(i->i).sum();
		System.out.println("Sum is :"+sum);
		
		// Lets check if the array contains even number, without looping
		boolean anyEven= intlist.stream().anyMatch(i->i%2==0);
		System.out.println(anyEven);
		
		// Check if all elements are even in the list
		boolean allEven = intlist.stream().allMatch(i->i%2==0);
		System.out.println(allEven);
		
		// Find first even number from the list
		Optional<Integer> firsteven= intlist.stream().filter(i->i%2==0).findFirst();
		System.out.println(firsteven);
		
		// Now lets sum all even numbers
		int sumeven = intlist.stream().filter(i->i%2==0).mapToInt(i->i).sum();
		System.out.println(sumeven);
		
		// Lets use forEach to do operations on each element, say add a constant number to even numbers and print
		intlist.stream().forEach(i->{
			if(i%2==0) {
				i = i+100;
				System.out.print(i+",");
			}
		});
		System.out.println();
		//Better way to achieve the above
		intlist.stream().filter(i->i%2==0).forEach(i->{
			i = i+100;
			System.out.print(i+",");
		});
		
		System.out.println();
		// Simliar to filter, we gave map function
		List newlist = intlist.stream().map(i->{
			return i+100;
		}).collect(Collectors.toList());
		System.out.println(newlist);
		
		// Use reduce to perform some custom operation
		Optional<Integer> output = intlist.stream().map(i->{
			return i+10;
		}).reduce((i,j)->{
			return i*j;
		});
		System.out.println(output);
		
		
		
		
	}

}
