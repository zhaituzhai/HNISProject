package com.zhaojm.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhaojm.service.IDictionaryService;

@RestController
public class DictionaryController {
    
    @Autowired
    IDictionaryService dictionaryService;
    
    @RequestMapping(value="/getDictionary/{type}",method=RequestMethod.GET)
    public Map<Integer, String> getDictionaryByType(@PathVariable("type") String type){
        return dictionaryService.getCodeName(type);
    }

}
