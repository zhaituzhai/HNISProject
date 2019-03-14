package com.zhaojm.user;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zhaojm.util.SessionTime;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SessionTimeTest {
    
    @Test
    public void sessionTime(){
        int i = SessionTime.MAX_INACTIVEIN_TERVALIN_SECONDS;
        System.out.println(i);
        Assert.assertTrue(i > 0);
    }

}
