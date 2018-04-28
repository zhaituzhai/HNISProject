package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.CaseDTO;
import com.zhaojm.bean.CaseMedicineDetailDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.mapper.ICaseMapper;
import com.zhaojm.mapper.ICaseMedicineDetailMapper;
import com.zhaojm.service.ICaseService;

@Service
public class CaseServiceServiceImpl implements ICaseService{

    @Autowired
    ICaseMapper caseMapper;
    
    @Autowired
    ICaseMedicineDetailMapper caseMedicineDetailMapper;
    
    @Override
    public PageInfo<CaseDTO> getCaseList(PageRequestDTO<CaseDTO> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<CaseDTO> list = caseMapper.queryCaseList(page.getParam());
        return new PageInfo<CaseDTO>(list);
    }

    @Override
    public int creatCase(CaseDTO caseInfo) {
        return caseMapper.insertSelective(caseInfo);        
    }

    @Override
    public int updateCase(CaseDTO caseInfo) {
        return caseMapper.updateByPrimaryKeySelective(caseInfo);
    }

    @Override
    public CaseDTO getCase(Integer caseId) {
        CaseDTO caseInfo = caseMapper.selectByPrimaryKey(caseId);
        if(caseInfo != null) {
            List<CaseMedicineDetailDTO> detailList = caseMedicineDetailMapper.queryDetailList(caseId);
            if(detailList != null)
                caseInfo.setCaseDetail(detailList);
        }
        return caseInfo;
    }

}
