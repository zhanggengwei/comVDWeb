package test.com.Utils;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SmsCodeUtilsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("this is setUpBeforeClass()...");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("this is tearDownAfterClass()...");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("this is setUp()...");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("this is tearDown()...");
    }

    @Test
    public void test() {
        System.out.println("this is test()...");
    }

}