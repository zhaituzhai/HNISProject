package com.zhaojm.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhaojm.bean.DictionaryDTO;
import com.zhaojm.mapper.IDictionaryMapper;
import com.zhaojm.service.IDictionaryService;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    
    @Autowired
    IDictionaryMapper dictionaryMapper;

    @Override
    public Map<Integer, String> getCodeName(String type) {
        List<DictionaryDTO>  dictionaryList =   dictionaryMapper.getDictionaryByType(type);
        Map<Integer, String>  typeMap = new HashMap<Integer, String>();
        for(DictionaryDTO  dictionary : dictionaryList){
            typeMap.put(dictionary.getDataCode(),dictionary.getDataValue());
        }
        return typeMap;
    }

    @Override
    public Map<String, String> getNameCode(String type) {
        List<DictionaryDTO>  dictionaryList =   dictionaryMapper.getDictionaryByType(type);
        Map<String, String>  typeMap = new HashMap<String, String>();
        for(DictionaryDTO  dictionary : dictionaryList){
            typeMap.put(dictionary.getDataValue(),String.valueOf(dictionary.getDataCode()));
        }
        return typeMap;
    }

}
