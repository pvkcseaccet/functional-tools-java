package com.monads.try0;

import org.junit.jupiter.api.Test;

public class TestSuccess
{
	@Test
	public void returnsSuccessWhenSuccess()
	{
		assert (Try.of(TestTry.Data.SUCCESS) instanceof Success);
	}
}
