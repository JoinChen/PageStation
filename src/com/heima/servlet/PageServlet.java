package com.heima.servlet;

import com.heima.service.PageService;
import com.heima.service.impl.PageServiceImpl;
import com.heima.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PageServlet",urlPatterns = "/PageServlet")
public class PageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String num = request.getParameter("num");
        int currentNum = Integer.parseInt(num);
        PageService pageService=new PageServiceImpl();
        //调用业务层查询当前页功能,返回PageModel对象(1_当前页数据2_分页参数)
        PageModel pm=null;
        try {
            pm = pageService.findProducts(currentNum);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //将PageModel对象放入request
        request.setAttribute("page", pm);
        //request.getRequestDispatcher("/product_list.jsp").forward(request, response);
        request.getRequestDispatcher("/product_list2.jsp").forward(request, response);
    }
}
