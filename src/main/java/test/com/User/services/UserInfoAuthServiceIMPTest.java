package test.com.User.services;

import com.User.services.UserInfoAuthService;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * UserInfoAuthServiceIMP Tester.
 *
 * @author <Authors name>
 * @since <pre>10/18/2017</pre>
 * @version 1.0
 */
@Component
public class UserInfoAuthServiceIMPTest extends TestCase {

    @Autowired
    UserInfoAuthService userInfoAuthService;


    public UserInfoAuthServiceIMPTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public static Test suite()
    {
        return new TestSuite(UserInfoAuthServiceIMPTest.class);
    }
    @org.junit.Test
    public void testMapper()
    {
        userInfoAuthService.searchAuthByToken("33");

    }
}
