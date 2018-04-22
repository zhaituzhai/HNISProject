package com.zhaojm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.InformationDTO;
import com.zhaojm.mapper.IInformationMapper;
import com.zhaojm.service.IInformationService;

@Service
public class InformationServiceImpl implements IInformationService {
    
    @Autowired
    IInformationMapper informationMapper;

    @Override
    public int creatInformation(InformationDTO information) {
        if(informationMapper.insert(information)>0)
            return 1;
        return 0;
    }

    @Override
    public int delInformation(Integer infoId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public InformationDTO updateInformation(InformationDTO information) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public PageInfo<InformationDTO> getInfoList(InformationDTO information) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public InformationDTO getInformation(Integer infoId) {
        // TODO Auto-generated method stub
        return null;
    }

}
