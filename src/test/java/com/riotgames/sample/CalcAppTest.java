package com.riotgames.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple CalcApp.
 */
public class CalcAppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalcAppTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( CalcAppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
	String[] testString={"2","x","5","(","4","+","2",")"};
	CalcApp.main(testString);

	String[] testString2={"1","+","2","x","3"};
	CalcApp.main(testString2);

	String[] testString3={"1","+","3","x","3"};
	CalcApp.main(testString3);
	String[] testString4={"(", "6","x","4", ")"};
	CalcApp.main(testString4);
	String[] testString5={"7","/","0","+","1"};
	CalcApp.main(testString5);
	String[] testString6={"(","+","+","+",")"};
	CalcApp.main(testString6);
	
        assertTrue( true );
    }
}
