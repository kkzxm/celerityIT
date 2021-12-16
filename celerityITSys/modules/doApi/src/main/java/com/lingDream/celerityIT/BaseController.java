package com.lingDream.celerityIT;

import com.lingDream.celerityIT.controller.APIController;
import com.lingDream.celerityIT.entity.APIField;
import com.lingDream.celerityIT.entity.JSONAPI;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;


@Component("dispatcherServlet")
public class BaseController extends DispatcherServlet {
    @Autowired
    APIController apiController;

    @SneakyThrows
    @Override
    public void doService(HttpServletRequest request, HttpServletResponse response) {
        JSONAPI jsonapi = new JSONAPI()
                .setAddress(request.getServletPath().substring(1))//请求地址(不包括协议/ip/端口号)
                .setMethod(RequestMethod.valueOf(request.getMethod()));

        //请求参数
        List<APIField> apiFields = new ArrayList<>();
        request.getParameterMap().forEach((k, v) -> {
            //请求参数中的key直接给到APIField的name,不允许多个参数重名,只取第一个值,如果需要数组类型的,可直接转为字符串传递进来
            apiFields.add(new APIField().setName(k).setValue(v[0]));
        });

        response.getWriter().println(apiController.doController(jsonapi.addRequestField(apiFields.toArray(new APIField[0]))));

    }
}
