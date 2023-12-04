package com.monads.helpers;

@FunctionalInterface
public interface Consumer_<T, U>
{
	void accept(T t, U u) throws Exception;
}
