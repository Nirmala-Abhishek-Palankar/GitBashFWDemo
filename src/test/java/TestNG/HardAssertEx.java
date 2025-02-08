package TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {
	//HardAssert used for madantory fields
		//Hard Assert is Static in nature
		//If Assert fails stops the execution immd
		//AssertionError
		
		@Test
		public void m1()
		{
			System.out.println("Step1");
			System.out.println("Step2");
			Assert.assertEquals("B", "A");
			System.out.println("Step3");
			System.out.println("Step4");
		}
		
		@Test
		public void m2()
		{
			String ExpData = "Shobha ";
			String actData = "Shobha";
			Assert.assertEquals(actData, ExpData);
		}
		
		@Test
		public void m3()
		{
			int a=10;
			int b=1;
			Assert.assertEquals(b, a);
			System.out.println("Values are Equal");
		}
		
		@Test
		public void m4()
		{
			int a=10;
			int b=1;
			Assert.assertEquals(b, a, "not equal");
			System.out.println("Values are Equal");
		}
		
		@Test
		public void m5()
		{
			int a=10;
			int b=10;
			Assert.assertNotEquals(b,a ,"equal values" );
			System.out.println("Not Equal");
		}
		
		@Test
		public void m6()
		{
			String expData="Qspiders";
			String actDAta="Qspider";
			Assert.assertTrue(actDAta.equalsIgnoreCase(expData), "False=");
			System.out.println("True===");
		}
		
		@Test
		public void m7()
		{
			String expData="Shobha";
			String actDAta="Shobha";
			Assert.assertFalse(actDAta.contains(expData), "Same values==");
			System.out.println("False value");
		}

}
