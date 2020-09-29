package com.ksu.dam.service;

import com.ksu.dam.constant.MongoConstants;
import com.ksu.dam.entity.CwlogsStream;
import com.ksu.dam.repository.DamRespository;
import com.ksu.dam.rules.DamRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class Analyzedam {


   @Autowired
   private DamRespository damRespository ;

   @Autowired
   private DamRules damRules ;

    public List<CwlogsStream> damByatype(String atype){

        List<CwlogsStream> listOfAtype= damRespository.findByAtype(atype);
       return listOfAtype;
    }

    public void getDamList() {
        System.out.println(damRespository.findAll());
    }

    public void getActiveIndicator() {
            damRules.authFailed();
            damRules.truncateValidation();
            damRules.validateAtype();
        List<CwlogsStream> cwlogsStreams = damRespository.findByActiveIndicator("Y");
        for(CwlogsStream activeIndicator : cwlogsStreams)
        {
            activeIndicator.setActiveIndicator("N");
            damRespository.save(activeIndicator);
        }
        }

}
