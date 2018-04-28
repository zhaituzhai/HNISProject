package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.mapper.IDoctorMapper;
import com.zhaojm.service.IDoctorService;

@Service
public class DoctorServiceImpl implements IDoctorService {
    
    @Autowired
    IDoctorMapper doctorMapper;

    @Override
    public int creatDoctor(DoctorDTO doctor) {
        if(doctorMapper.insert(doctor)>0)
            return 1;
        else
            return 0;
    }

    @Override
    public DoctorDTO updateDoctor(DoctorDTO doctor) {
        if(doctorMapper.updateByPrimaryKeySelective(doctor)>0)
            return doctorMapper.selectByPrimaryKey(doctor.getDoctorId());
        else
            return null;
    }

    @Override
    public PageInfo<DoctorDTO> DoctorList(PageRequestDTO<DoctorDTO> pageDoctor) {
        PageHelper.startPage(pageDoctor.getPageNum(), pageDoctor.getPageSize());
        List<DoctorDTO> list = doctorMapper.queryDoctorList(pageDoctor.getParam());
        return new PageInfo<DoctorDTO>(list);
    }

    @Override
    public int delete(Integer doctorId) {
        if(doctorMapper.deleteByPrimaryKey(doctorId)>0)
            return 1;
        else
            return 0;
    }

}
