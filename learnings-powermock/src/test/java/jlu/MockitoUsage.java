package jlu;


import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(StaticClass.class)
public class MockitoUsage {

	@Test
	public void test() {
		PowerMockito.mockStatic(StaticClass.class);
		
		Mockito.when(StaticClass.sayHello()).thenReturn("wow powermock");
		
		System.out.println(StaticClass.sayHello());
//		fail("Not yet implemented");
	}

}
