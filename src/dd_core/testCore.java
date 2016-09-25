package dd_core;

import com.sun.corba.se.impl.protocol.AddressingDispositionException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import dd_util.SendMailUsingAuthentication;
import dd_xlreader.Xls_Reader;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.SeleniumServer;
import org.seleniumhq.jetty9.util.log.Logger;

import java.io.FileInputStream;
import java.util.Properties;

public class testCore {

    public static RemoteWebDriver selenium = null;

    private static final Properties config = new Properties();

    public static final Properties object = new Properties();

    protected static Xls_Reader excel = null;

    public final Logger app_Logs = Logger.getLogger("devpinoyLogger");

    private static final SeleniumServer server = null;

    @Rule
    public ErrorCollector ec = new ErrorCollector();

    public static void init() throws Exception {
        if (selenium == null) {
            SeleniumServer server = new SeleniumServer();
            server.boot();
            // server.start();

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//dd_properties//config.properties");
            config.load(fis);
            app_Logs.debug("Loading config properties file");

            fis = new FileInputStream(System.getProperty("user.dir") + "//src//dd_properties//objects.properties");
            object.load(fis);

            excel = new Xls_Reader(System.getProperty("user.dir") + "//src/dd_properties//testData.xls");

            selenium = new FirefoxDriver();
            selenium.manage().window().maximize();
            selenium.get(config.getProperty("testsite"));

        }
    }

    public static void stopServer() throws AddressingDispositionException, MessagingException {
        System.out.println("Sending mail...");
        SendMailUsingAuthentication mail = new SendMailUsingAuthentication();
        mail.postMail(SendMailUsingAuthentication.emailList, SendMailUsingAuthentication.emailSubjectText,
                SendMailUsingAuthentication.emailMsgTxt, SendMailUsingAuthentication.emailFromAddress);
        System.out.println("Stopping selenium server...");
        server.stop();

    }

}
