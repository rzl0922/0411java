package com.offcn.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.offcn.bean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("/Json01Servlet")
public class Json01Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(1,"zhangsan","男");
        User user1 = new User(2,"lisi","男");
        User user2 = new User(3,"wangwu","男");
        User user3 = new User(4,"zhaoliu","男");
        User user4 = new User(5,"hanqi","男");
        User user5 = new User(6,"wangba","男");
        ArrayList<User> ulist = new ArrayList<>();
        ulist.add(user);
        ulist.add(user1);
        ulist.add(user2);
        ArrayList<User> ulist1 = new ArrayList<>();
        ulist1.add(user3);
        ulist1.add(user4);
        ulist1.add(user5);
        HashMap<String, List<User>> map = new HashMap<>();
        map.put("u1",ulist);
        map.put("u2",ulist1);
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(map);
        System.out.println(string);
    }
}
