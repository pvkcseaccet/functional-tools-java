package com.monads.helpers;

@FunctionalInterface
public interface Supplier_<T>
{
	T get() throws Exception;
}
