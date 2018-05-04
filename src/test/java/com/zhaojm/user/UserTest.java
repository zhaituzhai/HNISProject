package com.zhaojm.user;

import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.DiseaseDetailDTO;
import com.zhaojm.bean.DoctorDTO;
import com.zhaojm.bean.MedicineDTO;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.controller.MedicineController;
import com.zhaojm.mapper.IDiseaseDetailMapper;
import com.zhaojm.mapper.IDoctorMapper;
import com.zhaojm.mapper.IUseraccountMapper;
import com.zhaojm.service.IMedicineService;
import com.zhaojm.service.IUseraccountService;
import com.zhaojm.util.ResultDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {
    
    @Autowired
    IUseraccountService useraccountService;
    
    @Autowired
    IUseraccountMapper useraccountMapper;
    
    @Autowired
    IMedicineService medicineService;
    
    @Autowired
    IDiseaseDetailMapper diseaseDetailMapper;
    
    @Autowired
    IDoctorMapper doctorMapper;
    
    @Autowired
    MedicineController medicineController;
    
    @Test
    public void testUpload() throws FileNotFoundException{
        FileInputStream file = new FileInputStream("E:\\Aisino\\药品导入模板.xlsx");
//        ResultDTO<Integer> result = medicineController.importMedicine((MultipartFile) file);
//        byte[] xmlByte = file.?
        int result = medicineService.toParse(file);
        
        assertTrue(result > 0);
    }
    
    
    @Test
    public void testLogin() throws Exception {
        UseraccountDTO loginUser = new UseraccountDTO();
        loginUser.setUserName("admin");
        loginUser.setPassword("1234");
        UseraccountDTO user = useraccountService.verificationLoginUser(loginUser);
        System.out.println(user);
//        DoctorDTO doctor = doctorMapper.selectByPrimaryKey(doctorId)
        
    }
    
    @Test
    public void testList() {
        PageRequestDTO<UseraccountDTO> query = new PageRequestDTO<UseraccountDTO>();
        query.setPageNum(1);
        query.setPageSize(10);
        UseraccountDTO user = new UseraccountDTO();
        user.setUserName("t");
        query.setParam(user);
        PageInfo<UseraccountDTO> userList = useraccountService.queryUserList(query);
        assertTrue(userList!=null);
    }
    @Test
    public void testMedicine() {
        MedicineDTO me = new MedicineDTO();
        PageRequestDTO<MedicineDTO> page = new PageRequestDTO<>();
        page.setPageNum(1);
        page.setPageSize(10);
        page.setParam(me);
        PageInfo<MedicineDTO> list = medicineService.queryMedicineList(page);
        assertTrue(list.getSize()>0);
    }
    
    @Test
    public void addMedicine() {
        MedicineDTO medicine = new MedicineDTO();
        medicine.setMedicineName("咽喉片");
        medicine.setMainComponents("地黄、板蓝根、青果");
        medicine.setUserRange("喉咙痛");
        medicine.setUserWay("口服");
        medicine.setUserAttention("过敏者不可复用");
        medicine.setSaveWay("干燥处");
        medicine.setSpecifications("20片一版，一盒两版");
        medicine.setPrice(200.00);
        
        int isSave = medicineService.addMedicine(medicine);
        assertTrue(isSave>0);
    }
    
    @Test
    public void testDisease() {
        
        DiseaseDetailDTO dis = new DiseaseDetailDTO();
//        dis.setDepartment("0");
        dis.setDiseaseType("白眼疾病");
        List<DiseaseDetailDTO> list = diseaseDetailMapper.queryDiseaseList(dis);
        assertTrue(list.size()>0);
        
//        List<String> list = diseaseDetailMapper.getDiseaseDepartment("眼");
        
//        List<String> typeList = diseaseDetailMapper.getDiseaseType("眼");
        
//        assertTrue(list.size()>0);
    }
    
    @Test
    public void addUser() {
//        UseraccountDTO user = useraccountMapper.selectName("matte");
//        assertTrue(user!=null);
        /*UseraccountDTO user = new UseraccountDTO();
        user.setUserName("test");
        user.setPassword("1234");
        user.setUserPhone("12345879641");
        user.setUserType("2");
        int i = useraccountService.creadUseraccount(user);
        assertTrue(i>0);*/
        
    }
    
/*    @Test
    public void test() {
        UseraccountDTO user = useraccountMapper.selectByPrimaryKey(1);
        System.out.println(user);
        
    }*/

}
