import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

public class learningAssertions {

    @Rule
    public ErrorCollector ec = new ErrorCollector();

    @Test
    public void testTitle(){
        String actualTitle = "Google.cz";
        String expectedTitle = "Google.com";

        try {
            Assert.assertEquals(actualTitle, expectedTitle);
        }
        catch (Throwable t){
            System.out.println("Error captured.");
            ec.addError(t);
        }


        System.out.println("after assertion...");
    }


}

