package com.monads.try0;

import java.util.Optional;
import java.util.function.Function;

import com.monads.helpers.Supplier_;

public abstract class Try<T>
{
	public abstract T get();

	public abstract boolean isProcessed();

	public abstract boolean isFailed();

	public abstract T orElse(T anotherValue);

	public abstract T orElseGet(Supplier_<T> f);

	public abstract Try<T> recover(Function<? super Throwable, T> function);

	public abstract Optional<Try<T>> optional();

	//Object Level Defaults Starts...

	public void orElseThrow(Throwable throwable) throws Throwable
	{
		if (isFailed())
		{
			throw throwable;
		}
	}

	//Object Level Defaults Ends...

	//Static Methods Starts...
	public static <T> Try<T> of(Supplier_<T> functor)
	{
		try
		{
			T result = functor.get();
			return new Success<>(result);
		}
		catch(Exception ex)
		{
			return new Failure<>(ex);
		}
	}

	public static <T, R> Try<R> of(Function<T, R> functor, T input)
	{
		try
		{
			R result = functor.apply(input);
			return new Success<>(result);
		}
		catch(Exception ex)
		{
			return new Failure<>(ex);
		}
	}

	public static Try<String> of(Runnable runnable)
	{
		try
		{
			runnable.run();
			return new Success<String>("Success");
		}
		catch(Exception ex)
		{
			return new Failure<>(ex);
		}
	}

	//Static Methods Ends...
}
