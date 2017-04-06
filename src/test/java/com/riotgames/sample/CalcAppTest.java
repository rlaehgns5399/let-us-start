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
	String[] testString={"2","+","5","+","4"};
	CalcApp.main(testString);
        assertTrue( true );
    }
}
