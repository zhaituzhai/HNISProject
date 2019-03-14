package com.zhaojm.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SessionTime {
    
    public static int MAX_INACTIVEIN_TERVALIN_SECONDS;  
    
    @Value("${app.session.outtime}")
    public void setMAX_INACTIVEIN_TERVALIN_SECONDS(int sessionTime) {
        SessionTime.MAX_INACTIVEIN_TERVALIN_SECONDS = sessionTime;
    }
    
    public static void main(String[] args) {
        System.out.println(SessionTime.MAX_INACTIVEIN_TERVALIN_SECONDS);
    }
    
}
