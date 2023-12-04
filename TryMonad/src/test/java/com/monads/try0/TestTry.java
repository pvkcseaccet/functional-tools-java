package com.monads.try0;

import org.junit.jupiter.api.Test;

import com.monads.helpers.Supplier_;

public class TestTry
{
	@Test
	public void init()
	{

	}
	public static final class Data
	{
		public static final Supplier_<Integer> SUCCESS = () -> 9 / 1;
		public static final Supplier_<Integer> FAILURE = () -> 9 / 0;
	}
}
