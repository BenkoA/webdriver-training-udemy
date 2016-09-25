package dd_util;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

/**
 * Created by adrianbenko on 25/09/2016.
 */
public class SendMailUsingAuthentication {

    public static final String SMTP_HOST_NAME = "smtp.google.com";
    public static final String SMTP_AUTH_USER = "abc@google.com";
    public static final String SMTP_AUTH_PWD = "secretPassword";

    public static final String emailMsgTxt = "text of the mail";
    public static final String emailSubjectText = "Subject of the email";
    public static final String emailFromAddress = "abc@gmail.com";

    public static final String[] emailList = {"abd#gmail.com"};

    public void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
        System.out.println("Sending email with subject: " + subject
        + " with message text: " + message + ", from  " + from + " to recipients: " + recipients.toString());

    }

}
