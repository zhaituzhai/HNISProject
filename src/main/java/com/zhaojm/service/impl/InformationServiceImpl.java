package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.InformationDTO;
import com.zhaojm.bean.PageRequestDTO;
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
        if(informationMapper.deleteByPrimaryKey(infoId)>0)
            return 1;
        return 0;
    }

    @Override
    public InformationDTO updateInformation(InformationDTO information) {
        if(informationMapper.updateByPrimaryKey(information)>0)
            return informationMapper.selectByPrimaryKey(information.getInformationId());
        return null;
    }

    @Override
    public PageInfo<InformationDTO> getInfoList(PageRequestDTO<InformationDTO> pageInformation) {
        PageHelper.startPage(pageInformation.getPageNum(), pageInformation.getPageSize());
        List<InformationDTO> list = informationMapper.queryInfoList(pageInformation.getParam());
        return new PageInfo<InformationDTO>(list);
    }

    @Override
    public InformationDTO getInformation(Integer infoId) {
        InformationDTO info = informationMapper.selectByPrimaryKey(infoId);
        if(null != info)
            return info;
        return null;
    }

}
