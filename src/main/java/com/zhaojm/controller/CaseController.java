package com.zhaojm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zhaojm.bean.CaseDTO;
import com.zhaojm.bean.CaseInfoDTO;
import com.zhaojm.bean.PatientDTO;
import com.zhaojm.service.ICaseMedicineDetailService;
import com.zhaojm.service.ICaseService;
import com.zhaojm.service.IPatientService;
import com.zhaojm.service.IUseraccountService;
import com.zhaojm.util.ResultDTO;

@RestController
@RequestMapping
public class CaseController {
    
    @Autowired
    ICaseService caseService;
    
    @Autowired
    IPatientService patientService;
    
    @Autowired
    IUseraccountService  useraccountService;
     
    @Autowired
    ICaseMedicineDetailService caseMedicineDetailService;
    
    //case/saveCase
    @RequestMapping(value = "/case/saveCase",method=RequestMethod.POST)
    public ResultDTO<Integer> saveCase(@RequestBody CaseInfoDTO caseInfo){
        
        PatientDTO patient = new PatientDTO();
        patient.setPatientName(caseInfo.getPatientName());
        if(useraccountService.queryPatientName(patient).size() < 1) {
            patient.setPatientSex(caseInfo.getPatientSex().equals("男") ? "M":"F");
            patient.setPatientBorn(caseInfo.getPatientAge());
            patientService.creatPatient(patient);
        }
        CaseDTO caseInset = new CaseDTO();
        caseInset.setIllnessDesc(caseInfo.getIllnessDesc());
        caseInset.setPatientName(caseInfo.getPatientName());
        caseInset.setDoctorName(caseInfo.getDoctorName());
        caseInset.setIllnessTime(caseInfo.getIllnessTime());
        caseInset.setCureCycle(caseInfo.getCureCycle());
        caseService.creatCase(caseInset);
        int caseId = caseInset.getCaseId();
        
        int detail = caseMedicineDetailService.creatCaseDeatil(caseId,caseInfo.getDetailList());
        if(caseId > 0 && detail >0 ) 
            return ResultDTO.valueOfSuccess();
        else
            return ResultDTO.valueOfError("新建处方单时出现错误");
    }
    

}
