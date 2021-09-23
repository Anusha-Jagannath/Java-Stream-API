package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * MainStream class demonstrates stream API
 */
public class MainStream {

	public static void main(String[] args) {
		System.out.println("Welcome to stream API program");

		// iterating list using stream API
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		integers.stream().forEach(n -> {
			System.out.println("Stream forEach value " + n);
		});

		// converting integer list to double list using map function and collecting the
		// result using stream collect
		Function<Integer, Double> doubleFunction = Integer::doubleValue;
		List<Double> doubleList = integers.stream()
										  .map(doubleFunction)
										  .collect(Collectors.toList());
		System.out.println("Printing double list " + doubleList);
		
		//Implicit lambda function to print even no
		Predicate<Integer> isEvenFunction = n -> n % 2 == 0;
		List<Double> evenList = integers.stream()
										   .filter(isEvenFunction)
										   .map(doubleFunction)
										   .collect(Collectors.toList());
		System.out.println("Printing even numbers "+evenList);
		
		//method to peek even number in the list
		List<Double> streamList = integers.stream()
								  .filter(isEvenFunction)
								  .peek(n -> System.out.println("Peak even no: "+n))
								  .map(doubleFunction)
								  .collect(Collectors.toList());
		System.out.println("Printing double list " + streamList);
		
		//method to peek first even number
		Integer first = integers.stream()
								.filter(isEvenFunction)
								.peek(n -> System.out.println("peak even no : "+n))
								.findFirst()
								.orElse(null);
		System.out.println("First even no : "+first);
		
		//find minimum even no
		Integer min = integers.stream()
							  .filter(isEvenFunction)
							  .min((n1,n2) -> n1-n2)
							  .orElse(null);
		System.out.println("Minimum number is "+min);
		
		//find maximum even no
		Integer max = integers.stream()
					          .filter(isEvenFunction)
					          .max(Comparator.comparing(Integer::intValue))
					          .orElse(null);
		System.out.println("Maximum even no "+max);
		
		//find sum and average in the number stream
		Integer sum = integers.stream().reduce(0, Integer::sum);
		long count = integers.stream().count();
		System.out.println("Sum is : "+sum);
		System.out.println("Count is : "+count);
		System.out.println("Average is "+sum/count);
		
		//finding if all numbers are even or atleast one number is even
		boolean allEven = integers.stream().allMatch(isEvenFunction);
		boolean oneEven = integers.stream().anyMatch(isEvenFunction);
		boolean noneMultOfSix = integers.stream().noneMatch(i -> i > 0 && i % 6 == 0);
		System.out.print("All even "+allEven+"\nOne even "+oneEven+"\nnone multiple of six "+noneMultOfSix);
	}
}
