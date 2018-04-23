package com.zhaojm.service;

import java.util.Map;

public interface IDictionaryService {
    
    Map<Integer, String> getCodeName(String type);
    
    Map<String, String> getNameCode(String type);

}
