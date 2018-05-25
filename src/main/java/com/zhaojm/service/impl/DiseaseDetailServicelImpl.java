package com.zhaojm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DiseaseDetailDTO;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.mapper.IDiseaseDetailMapper;
import com.zhaojm.mapper.IMedicineMapper;
import com.zhaojm.service.IDiseaseDetailService;

@Service
public class DiseaseDetailServicelImpl implements IDiseaseDetailService {
    
    @Autowired
    IDiseaseDetailMapper diseaseDetailMapper;
    
    @Autowired
    IMedicineMapper medicineMapper;

    @Override
    public int addDiseaseDetail(DiseaseDetailDTO disease) {
        return diseaseDetailMapper.insertSelective(disease);
    }

    @Override
    public int delDiseaseDetailByPrimkey(Integer diseaseId) {
        return diseaseDetailMapper.deleteByPrimaryKey(diseaseId);
    }

    @Override
    public int updateDiseaseDetail(DiseaseDetailDTO disease) {
        return diseaseDetailMapper.updateByPrimaryKeySelective(disease);
    }

    @Override
    public PageInfo<DiseaseDetailDTO> queryDiseaseDetailList(PageRequestDTO<DiseaseDetailDTO> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<DiseaseDetailDTO> list = diseaseDetailMapper.queryDiseaseList(page.getParam());
        if(list.size()>0) {
            for (DiseaseDetailDTO disease : list) {
                List<MedicineDTO> medicineList = new ArrayList<MedicineDTO>();
                String[] medicine = disease.getDiseaseMedicine().split("-");
                for (String s : medicine) {
                    medicineList.add(medicineMapper.selectByPrimaryKey(Integer.parseInt(s)));
                }
                disease.setDiseaseMedicineList(medicineList);
            }
        }
        return new PageInfo<DiseaseDetailDTO>(list);
    }
    
    

    @Override
    public int verfiy(DiseaseDetailDTO disease) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<String> queryDeptList() {
        
        return diseaseDetailMapper.getDiseaseDepartment();
    }

    @Override
    public List<String> queryTypeList() {
        
        return diseaseDetailMapper.getDiseaseType();
    }

    @Override
    public DiseaseDetailDTO queryDiseaseFull(Integer diseaseId) {
        
        return diseaseDetailMapper.selectByPrimaryKey(diseaseId);
    }

}
