package br.com.mystudies.scalability.thread.safety;

import java.io.File;

public abstract class BaseTest {

	protected File path() throws Exception {
		return new File(TotalFileSizeSequencialTest.class.getResource("/dir").toURI());
	}
	
}
