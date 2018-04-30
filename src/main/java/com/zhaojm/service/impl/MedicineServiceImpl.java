package com.zhaojm.service.impl;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.mapper.IMedicineMapper;
import com.zhaojm.service.IMedicineService;

@Service
public class MedicineServiceImpl implements IMedicineService {
    
    @Autowired
    IMedicineMapper medicineMapper;

    @Override
    public int addMedicine(MedicineDTO medicine) {
        
        return medicineMapper.insertSelective(medicine);
        
    }

    @Override
    public int delMedicineByPrimkey(Integer medicineId) {
        
        return medicineMapper.deleteByPrimaryKey(medicineId);
    }

    @Override
    public int updateMedicine(MedicineDTO medicine) {
        
        return medicineMapper.updateByPrimaryKeySelective(medicine);
    }

    @Override
    public PageInfo<MedicineDTO> queryMedicineList(PageRequestDTO<MedicineDTO> page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize());
        List<MedicineDTO> list = medicineMapper.queryMedicineList(page.getParam());
        return new PageInfo<MedicineDTO>(list);
    }

    @Override
    public int verfiy(MedicineDTO medicine) {
        MedicineDTO trueMedicine = medicineMapper.selectByVerfiy(medicine);
        if(null != trueMedicine)
            return 1;
        else
            return 0;
    }

    @Override
    public MedicineDTO queryMeidcineFull(Integer medicineId) {
        
        return medicineMapper.selectByPrimaryKey(medicineId);
    }

    @Override
    public int toParse(FileInputStream xmlByte) {
        int total = 0;
        List<MedicineDTO> importList = doParse(xmlByte);
        for (MedicineDTO medicine : importList) {
            total += medicineMapper.insertSelective(medicine);
        }
        return total;
    }

    private List<MedicineDTO> doParse(FileInputStream xmlByte) {
        Workbook workbook = getWorkBook(xmlByte);
        List<MedicineDTO> list = new ArrayList<MedicineDTO>();
        for (int i = 0; i < 1; i++) {
            Sheet sheet0 = workbook.getSheetAt(i);
            list.addAll(parseSheet(sheet0,1));
        }
        return list;
    }
    
    private List<MedicineDTO> parseSheet(Sheet sheet, int starRow) {
        List<MedicineDTO> list = new ArrayList<MedicineDTO>();
        MedicineDTO medicine = new MedicineDTO();
        if(null == sheet)
            return list;
        //循环解析
        int rowNum = sheet.getLastRowNum();
        for(int i = starRow;i <= rowNum;i++){
            Row hss = sheet.getRow(i);
            if(null != hss && hss.getPhysicalNumberOfCells() > 0){ //去除空行判断 https://www.tapd.cn/20490491/bugtrace/bugs/view?bug_id=1120490491001005787
                medicine.setMedicineName(String.valueOf(hss.getCell(0)));
                medicine.setMainComponents(String.valueOf(hss.getCell(1)));
                medicine.setUserRange(String.valueOf(hss.getCell(2)));
                medicine.setUserWay(String.valueOf(hss.getCell(3)));
                medicine.setUserAttention(String.valueOf(hss.getCell(4)));
                medicine.setSaveWay(String.valueOf(hss.getCell(5)));
                medicine.setSpecifications(String.valueOf(hss.getCell(6)));
                medicine.setPrice(Double.parseDouble(String.valueOf(hss.getCell(7))));
                list.add(medicine);
            }else{
                break;
            }
        }
        return list;
    }

    public Workbook getWorkBook(InputStream inputStream){
        
        Workbook workbook = null;
        try{
            if(!inputStream.markSupported()){
                inputStream = new PushbackInputStream(inputStream, 8);
            }
            if (POIFSFileSystem.hasPOIFSHeader(inputStream)) {// 2003
                workbook = new HSSFWorkbook(inputStream);
            } else if (POIXMLDocument.hasOOXMLHeader(inputStream)) {// 2007
                workbook = new XSSFWorkbook(inputStream);
            }
            return workbook;
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        
    }
    

}
