package com.zhaojm.service;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.CaseDTO;
import com.zhaojm.bean.PageRequestDTO;

public interface ICaseService {
    
    PageInfo<CaseDTO> getCaseList(PageRequestDTO<CaseDTO> page);
    
    int creatCase(CaseDTO caseInfo);
    
    int updateCase(CaseDTO caseInfo);
    
    CaseDTO getCase(Integer caseId);

}
