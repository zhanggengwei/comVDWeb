package test.test.com.Utils;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * SmsCodeUtilsTest Tester.
 *
 * @author <Authors name>
 * @since <pre>10/16/2017</pre>
 * @version 1.0
 */
public class SmsCodeUtilsTestTest extends TestCase {
    public SmsCodeUtilsTestTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
        System.out.println("---");
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSetUpBeforeClass() throws Exception {
        //TODO: Test goes here...
    }

    public void testSetUp() throws Exception {
        //TODO: Test goes here...
    }

    public static Test suite() {
        return new TestSuite(SmsCodeUtilsTestTest.class);
    }
}
