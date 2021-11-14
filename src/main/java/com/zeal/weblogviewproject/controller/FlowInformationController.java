package com.zeal.weblogviewproject.controller;

import com.google.gson.Gson;
import com.zeal.weblogviewproject.model.FlowReturnPojo;
import com.zeal.weblogviewproject.service.impl.FlowInformationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZEAL
 */
@WebServlet(name = "FlowInformationController", value = "/flowInformationController")
public class FlowInformationController extends HttpServlet {
    FlowInformationServiceImpl flowInformationServiceImpl = new FlowInformationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FlowReturnPojo flowReturnPojo = flowInformationServiceImpl.getFlowReturnPojo();

        //（二）将pojo对象转换成前端需要的json格式的字符串数据

        Gson gson = new Gson();
        String json = gson.toJson(flowReturnPojo);
        System.out.println(json);

        //(三)将json数据返回给前端页面
        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
