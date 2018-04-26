package com.zhaojm.service;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;

public interface IMedicineService {
    
    /**
     * 增
     */
    int addMedicine (MedicineDTO medicine);
    /**
     * 删
     */
    int delMedicineByPrimkey (Integer medicineId);
    /**
     * 改
     */
    int updateMedicine(MedicineDTO medicine);
    /**
     * 查
     */
    PageInfo<MedicineDTO> queryMedicineList(PageRequestDTO<MedicineDTO> medincine);
    /**
     * 验证
     */
    int verfiy(MedicineDTO medicine);

}
