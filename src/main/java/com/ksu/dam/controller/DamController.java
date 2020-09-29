package com.ksu.dam.controller;

import com.ksu.dam.entity.CwlogsStream;
import com.ksu.dam.service.Analyzedam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DamController {

    @Autowired
    private Analyzedam analyzedam ;

    @GetMapping("/dam/{atype}")
    public List<CwlogsStream> analyze(@PathVariable String atype){
       return analyzedam.damByatype(atype);
    }

    @GetMapping("/dam/list")
    public void getAllElem(){
        analyzedam.getDamList();
    }

    @GetMapping("/dam")
    public void getActiveIndicator(){
        analyzedam.getActiveIndicator();

    }

}
