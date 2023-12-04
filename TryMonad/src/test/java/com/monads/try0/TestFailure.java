package com.monads.try0;

import org.junit.jupiter.api.Test;

public class TestFailure
{
	@Test
	public void returnsFailureOnException()
	{
		assert (Try.of(TestTry.Data.FAILURE) instanceof Failure);
	}

	@Test
	public void throwsRuntimeExceptionOnFailure()
	{
		try
		{
			Try.of(TestTry.Data.FAILURE).get();
			assert (false);
		}
		catch(Exception ex)
		{
			assert (true);
		}
	}
}
