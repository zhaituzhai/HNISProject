package com.zhaojm.user;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.github.pagehelper.PageInfo;
import com.zhaojm.bean.PageRequestDTO;
import com.zhaojm.bean.UseraccountDTO;
import com.zhaojm.service.IUseraccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {
    
    @Autowired
    IUseraccountService useraccountService;
    
    @Test
    public void testLogin() throws Exception {
        UseraccountDTO loginUser = new UseraccountDTO();
        loginUser.setUserName("admin");
        loginUser.setPassword("1234");
        UseraccountDTO user = useraccountService.verificationLoginUser(loginUser);
        System.out.println(user);
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
    public void addUser() {
        UseraccountDTO user = new UseraccountDTO();
        user.setUserName("test");
        user.setPassword("1234");
        user.setUserPhone("12345879641");
        user.setUserType("2");
        int i = useraccountService.creadUseraccount(user);
        assertTrue(i>0);
        
    }
    
/*    @Test
    public void test() {
        UseraccountDTO user = useraccountMapper.selectByPrimaryKey(1);
        System.out.println(user);
        
    }*/

}
