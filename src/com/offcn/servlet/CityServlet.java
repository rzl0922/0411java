package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.City;
import com.offcn.service.CityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CityServlet")
public class CityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryId = req.getParameter("countryId");
        CityServiceImpl cs = new CityServiceImpl();
        List<City> list = cs.selectCity(Integer.parseInt(countryId));
        resp.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(list);
        resp.getWriter().print(str);
    }
}
