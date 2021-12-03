package com.lingDream.celerityIT.tool.overrideClass.mybatisPlus;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.query.QueryCelerityItWrapper;
import com.lingDream.celerityIT.tool.overrideClass.mybatisPlus.update.UpdateCelerityItWrapper;

import java.util.Map;

public class WrapperFactory {
    /**
     * 根据传过来的名称,直接返回对应的wrapper
     */
    public static Wrapper<Map<String, Object>> getWrapper(String wrapperType) {
        switch (wrapperType) {
            case "query":
                return new QueryCelerityItWrapper();
            case "update":
            case "delete":
            case "insert":
                return new UpdateCelerityItWrapper();
        }
        return null;
    }
}
