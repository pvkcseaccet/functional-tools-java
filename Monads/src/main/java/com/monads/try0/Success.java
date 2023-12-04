package com.monads.try0;

import java.util.Optional;
import java.util.function.Function;

import com.monads.helpers.Supplier_;

public class Success<T> extends Try<T>
{
	private final T value;

	public Success(T value)
	{
		this.value = value;
	}

	@Override public T get()
	{
		return value;
	}

	@Override public boolean isProcessed()
	{
		return true;
	}

	@Override public boolean isFailed()
	{
		return false;
	}

	@Override public T orElse(T anotherValue)
	{
		return get();
	}

	@Override public T orElseGet(Supplier_<T> f)
	{
		return get();
	}

	@Override public Try<T> recover(Function<? super Throwable, T> function)
	{
		return this;
	}

	@Override public Optional<Try<T>> optional()
	{
		return Optional.of(this);
	}
}
