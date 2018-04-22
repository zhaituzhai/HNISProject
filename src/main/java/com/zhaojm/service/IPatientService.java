package com.zhaojm.service;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.PatientDTO;

public interface IPatientService {
    
    int creatPatient(PatientDTO patient);
    
    PatientDTO updatePatient(PatientDTO patient);
    
    PageInfo<PatientDTO> PatientList(PageRequestDTO<PatientDTO> pagepatient);
    
    int delete (Integer patientId);


}
