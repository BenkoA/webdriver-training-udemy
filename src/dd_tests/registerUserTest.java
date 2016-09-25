package dd_tests;

import dd_core.testCore;
import dd_util.TestUtil;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class registerUserTest extends testCore {

    String name;
    String day;
    String month;
    String year;
    String registerusername;
    String password;
    String repassword;
    String email;
    String mobileno;

    private int testCount = 0;

    public registerUserTest(String name, String day, String month, String year, String registerusername,
            String password, String repassword, String email, String mobileno) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.registerusername = registerusername;
        this.password = password;
        this.repassword = repassword;
        this.email = email;
        this.mobileno = mobileno;
    }

    @Before
    public void init_test() throws Exception{
        init();
        app_Logs.debug("Start registerUserTest");

        if(TestUtil.isExecutable("registerUserTest")){
            Assume.assumeTrue(true);
        }
    }

    @Test
    public void testRegisterUser() throws Exception {
        testCount++;

        selenium.findElementByXPath(object.getProperty("register")).click();
        Thread.sleep(3000L);
        TestUtil.captureScreenshot();

        Thread.sleep(3000L);
        selenium.findElementByXPath(object.getProperty("name")).sendKeys(name);
        Thread.sleep(1000L);

        stopServer();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() throws Exception {
        Object[][] data = TestUtil.getData("registerUserTest");
        return Arrays.asList(data);
    }

}
