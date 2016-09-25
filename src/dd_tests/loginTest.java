package dd_tests;

import dd_core.testCore;
import dd_util.TestUtil;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;

@RunWith(Parameterized.class)
public class loginTest extends testCore {

    String username;
    String password;
    String is_correct;

    private int testCount = 0;

    public logintTest(String username, String password, String is_correct){
        this.username = username;
        this.password = password;
        this.is_correct = is_correct;
    }

    @Before
    public void init_test() throws Exception{
        app_Logs.debug("Start Login");

        if(TestUtil.isExecutable("loginTest")){
            Assume.assumeTrue(true);;
        }
    }

    @Test
    public void testLogin() throws Exception {
        testCount++;

        System.out.println(username + ": " + password + ": " + is_correct);
        selenium.get("/stockmarketsindia/");
        selenium.findElementByXPath(object.getProperty("signin"));
        Thread.sleep(3000L);

        TestUtil.captureScreenshot();
        Thread.sleep(5000L);

        selenium.findElementByXPath(object.getProperty("username")).sendKeys(username);
        Thread.sleep(3000L);
    }

}
