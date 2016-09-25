import org.junit.*;

/**
 * Created by adrianbenko on 25/09/2016.
 */
public class testingJunit {

    public static boolean validateDB(){
        return false;
    }

    @BeforeClass
    public static void seleniumSetup(){
        System.out.println("[=== Selenium Setup... ===]");
        Assume.assumeTrue(validateDB());
    }

    @AfterClass
    public static void seleniumShutdown(){
        System.out.println("[=== Selenium Shutdown... ===]");
    }

    @Before
    public void testOpenBrowser(){
        System.out.println("[--> Opening the browser window...");
    }

    @After
    public void testCloseBrowser(){
        System.out.println(" Closing the browser window <--]");
    }

    @Test
    public void testLink(){
        System.out.println("Validating the presence of links...");
    }

    @Test
    public void testNavigation(){
        System.out.println("Opening the website");
    }

    @Test
    public void testLoginDetails(){

        System.out.println("Entering login details");
    }

}
