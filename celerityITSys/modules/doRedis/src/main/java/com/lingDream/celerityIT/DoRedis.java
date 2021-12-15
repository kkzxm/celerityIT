package com.lingDream.celerityIT;

import com.lingDream.celerityIT.service.DoDataService;
import org.springframework.stereotype.Service;

@Service
public class DoRedis {
    private final DoDataService dataService;

    public DoRedis(DoDataService dataService) {
        this.dataService = dataService;
    }
}
