package com.zhaojm.service;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.PageRequestDTO;

public interface IDoctorService {
    
    int creatDoctor(DoctorDTO doctor);
    
    DoctorDTO updateDoctor(DoctorDTO doctor);
    
    PageInfo<DoctorDTO> DoctorList(PageRequestDTO<DoctorDTO> pageDoctor);
    
    int delete (Integer doctorId);

}
