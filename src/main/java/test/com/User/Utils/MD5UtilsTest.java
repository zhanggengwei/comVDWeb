package test.com.User.Utils;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * MD5Utils Tester.
 *
 * @author <Authors name>
 * @since <pre>10/16/2017</pre>
 * @version 1.0
 */
public class MD5UtilsTest extends TestCase {
    public MD5UtilsTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite() {
        return new TestSuite(MD5UtilsTest.class);
    }

    @org.junit.Test
    public void  test()
    {
        System.out.println("test");
    }
}
