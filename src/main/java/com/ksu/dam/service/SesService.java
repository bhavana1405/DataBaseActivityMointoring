package com.ksu.dam.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.*;
import com.ksu.dam.constant.MongoConstants;
import org.springframework.stereotype.Service;

@Service
public class SesService {
    public void sendEmail(String subject){

           try {
               AmazonSimpleEmailService client =
                       AmazonSimpleEmailServiceClientBuilder.standard()
                               // Replace US_WEST_2 with the AWS Region you're using for
                               // Amazon SES.
                               .withRegion(Regions.US_EAST_1).build();
               SendEmailRequest request = new SendEmailRequest()
                       .withDestination(
                               new Destination().withToAddresses(MongoConstants.TO))
                       .withMessage(new Message()
                               .withBody(new Body()
                                       .withHtml(new Content()
                                               .withCharset("UTF-8").withData(MongoConstants.HTMLBODY))
                                       .withText(new Content()
                                               .withCharset("UTF-8").withData(MongoConstants.TEXTBODY)))
                               .withSubject(new Content()
                                       .withCharset("UTF-8").withData(subject)))
                       .withSource(MongoConstants.FROM);
                       // Comment or remove the next line if you are not using a
                       // configuration set
                    //   .withConfigurationSetName(MongoConstants.CONFIGSET);
               client.sendEmail(request);
               System.out.println("Email sent!");
           }catch (Exception ex){
               System.out.println("The email was not sent. Error message: "
                       + ex.getMessage());
           }
        }

    }

