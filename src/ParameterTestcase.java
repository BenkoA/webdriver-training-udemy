import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterTestcase {

    String firstName;
    String lastName;
    String password;
    int age;

    public ParameterTestcase(String firstName, String lastName, String password, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> getData() {
        Object[][] data = new Object[2][4];

        data[0][0] = "Joy";
        data[0][1] = "Smith";
        data[0][2] = "abcd123";
        data[0][3] = 18;

        data[1][0] = "Jane";
        data[1][1] = "Doo";
        data[1][2] = "xyz123";
        data[1][3] = 28;

        return Arrays.asList(data);
    }

    @Test
    public void doLogin(){
        System.out.println(firstName + " " + lastName + ", " + password + " " + age);
    }

}
