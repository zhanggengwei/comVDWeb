package test.com.Utils;

import com.User.model.UserInfo;
import com.Utils.TokenUtils;
import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * TokenUtils Tester.
 *
 * @author <Authors name>
 * @since <pre>10/17/2017</pre>
 * @version 1.0
 */
public class TokenUtilsTest {

    @org.junit.Test
    public void createToken()
    {
        UserInfo info = new UserInfo() ;
        String token = TokenUtils.createToken("");

        System.out.println("token--"+token);
    }
}
