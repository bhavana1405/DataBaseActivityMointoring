package com.ksu.dam.rules;

import com.ksu.dam.constant.MongoConstants;
import com.ksu.dam.entity.CwlogsStream;
import com.ksu.dam.repository.DamRespository;
import com.ksu.dam.service.SesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Configuration
@Component
public class DamRules {

    @Autowired
    private DamRespository damRespository;

    @Autowired
    private SesService sesService ;

    public void authFailed() {

        List<CwlogsStream> listActiveIndicator =
                damRespository.findByActiveIndicatorAndAtypeAndError(MongoConstants.INDICATOR, MongoConstants.AUTHENTICATE, MongoConstants.ERROR);
        if (listActiveIndicator.size() > MongoConstants.EMAIL_SENDER_THRESHOLD) {
            System.out.println("Call ses to send mail for authentication failed");
            sesService.sendEmail("authentication attempted which was failed : "+MongoConstants.EMAIL_SENDER_THRESHOLD + " times");
        }

    }

    public void truncateValidation() {

        List<CwlogsStream> listOfAtype = damRespository.findByActiveIndicator("Y");
        int count = 0 ;
        for (CwlogsStream atypes : listOfAtype) {
            if ((atypes.getAtype().equals("dropCollection")) || (atypes.getAtype().equals("dropIndex"))
                    || (atypes.getAtype().equals("dropDatabase"))) {
                 count++;
            }

        }
        if(count>0){
            System.out.println("call ses to send mail for truncate validation");
            sesService.sendEmail("truncate happened in Nosql ");
        }
    }

    public void validateAtype() {

        List<CwlogsStream> listOfAtype = damRespository.findByActiveIndicator("Y");
        int count =0 ;
        for (CwlogsStream atypes : listOfAtype) {
            if (!(atypes.getAtype().equals("dropCollection"))
                    && !(atypes.getAtype().equals("dropIndex"))
                    && !(atypes.getAtype().equals("dropDatabase"))
                    && !(atypes.getAtype().equals("authenticate"))
                    && !(atypes.getAtype().equals("createCollection"))
                    && !(atypes.getAtype().equals("createIndex"))
                    && !(atypes.getAtype().equals("createDatabase"))
            ) {
                count++ ;
            }
        }
        if(count > 0) {
            System.out.println("call ses to send mail for non occurring verb");
            sesService.sendEmail("non occurred verb happened , please check for no sql injection ");
        }


    }

}
