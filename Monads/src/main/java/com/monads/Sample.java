package com.monads;

import java.util.function.Function;
import java.util.stream.Stream;

import com.monads.try0.Try;

public class Sample
{
	public static void main(String... args)
	{
		//Success -> orElseGet
		Function<Integer, Integer> divideByx = (x) -> 9/x;
		Stream.of(1,2,3,4,5,0)
			.map(x -> Try.of(divideByx, x)
				.orElseGet(() -> x + 10000))
			.forEach(System.out::println);

		//Success -> orElse
		Stream.of(1,2,3,4,5,0)
			.map(x -> Try.of(divideByx, x)
				.orElse(10000))
			.forEach(System.out::println);

		//Success -> Runnable
		Runnable r = () ->  System.out.println(9/1);
		System.out.println(Try.of(r).get());

		//Failure -> throw
		r = () ->  System.out.println(9/0);
		System.out.println(Try.of(r).recover(Throwable::getMessage).get());
	}
}
