package com.zhaojm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;
import com.zhaojm.mapper.IPatientMapper;
import com.zhaojm.service.IPatientService;

public class PatientServiceImpl implements IPatientService {

    @Autowired
    IPatientMapper patientMapper;

    @Override
    public int creatPatient(PatientDTO patient) {
        if(patientMapper.insert(patient)>0){
            return 1;
        }
        return 0;
    }

    @Override
    public PatientDTO updatePatient(PatientDTO patient) {
        if(patientMapper.updateByPrimaryKey(patient)>0)
            return patientMapper.selectByPrimaryKey(patient.getPatientId());
        return null;
    }

    @Override
    public PageInfo<PatientDTO> PatientList(PageRequestDTO<PatientDTO> pagePatient) {
        PageHelper.startPage(pagePatient.getPageNum(), pagePatient.getPageSize());
        List<PatientDTO> list = patientMapper.queryPatientList(pagePatient.getParam());
        return new PageInfo<PatientDTO>(list);
    }

    @Override
    public int delete(Integer patientId) {
        if(patientMapper.deleteByPrimaryKey(patientId)>0)
            return 1;
        return 0;
    }
    

}
