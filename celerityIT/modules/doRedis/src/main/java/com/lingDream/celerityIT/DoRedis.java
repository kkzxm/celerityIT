package com.lingDream.celerityIT;

import com.lingDream.celerityIT.service.CelerityITService;
import org.springframework.stereotype.Service;

@Service
public class DoRedis {
    private final CelerityITService celerityITService;


    public DoRedis(CelerityITService celerityITService) {
        this.celerityITService = celerityITService;
    }
}
