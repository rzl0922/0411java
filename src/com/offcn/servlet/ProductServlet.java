package com.offcn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.Product;
import com.offcn.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String productname = request.getParameter("productname");
        // 调用方法
        ProductServiceImpl ps = new ProductServiceImpl();
        List<Product> list = ps.selectProductName(productname);
        System.out.println(list);
        response.setContentType("text/html;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(list);
        response.getWriter().print(str);
    }
}
