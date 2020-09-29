package com.ksu.dam.constant;

public class MongoConstants {

    public final static String INDICATOR="Y" ;
    public final static String AUTHENTICATE = "authenticate" ;
    public final static String ERROR = "18" ;
    public final static Integer EMAIL_SENDER_THRESHOLD = 3 ;
    //ses
    // Replace sender@example.com with your "From" address.
    // This address must be verified with Amazon SES.
    public static final String FROM = "lucky.kajal1412@gmail.com";

    // Replace recipient@example.com with a "To" address. If your account
    // is still in the sandbox, this address must be verified.
    public static final String TO = "lucky.kajal1412@gmail.com";

    // The configuration set to use for this email. If you do not want to use a
    // configuration set, comment the following variable and the
    // .withConfigurationSetName(CONFIGSET); argument below.
    public static final String CONFIGSET = "ConfigSet";

    // The subject line for the email.
    public static final String SUBJECT = "Dam";

    // The HTML body for the email.
    public static final String HTMLBODY = "<h1>Dam </h1>"
            + "<p>This email is sent when some activity has been seen on the no sql database </p>"
            + "Check your database logs immediately" ;


    // The email body for recipients with non-HTML email clients.
    public  static final String TEXTBODY = "This email is sent when some activity has been seen on the no sql database ";


}
