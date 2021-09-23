package com.stream;

import java.util.Arrays;
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

	}
}
