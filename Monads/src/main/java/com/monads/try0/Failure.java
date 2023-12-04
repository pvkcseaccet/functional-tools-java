package com.monads.try0;

import java.util.Optional;
import java.util.function.Function;

import com.monads.helpers.Supplier_;

public class Failure<T> extends Try<T>
{
	private final Throwable throwable;

	public Failure(Throwable throwable)
	{
		this.throwable = throwable;
	}

	@Override public T get()
	{
		throw new RuntimeException(throwable);
	}

	@Override public boolean isProcessed()
	{
		return false;
	}

	@Override public boolean isFailed()
	{
		return true;
	}

	@Override public T orElse(T anotherValue)
	{
		return anotherValue;
	}

	@Override public T orElseGet(Supplier_<T> f)
	{
		return Try.of(f).get();
	}

	@Override public Try<T> recover(Function<? super Throwable, T> function)
	{
		try
		{
			return new Success<>(function.apply(this.throwable));
		}
		catch(Exception ex)
		{
			return new Failure<>(ex);
		}
	}

	@Override public Optional<Try<T>> optional()
	{
		return Optional.empty();
	}
}
