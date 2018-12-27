package com.heima.service.impl;

import com.heima.dao.PageDao;
import com.heima.dao.impl.PageDaoImpl;
import com.heima.service.PageService;
import com.heima.utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public class PageServiceImpl implements PageService {
    @Override
    public PageModel findProducts(int currentNum) throws SQLException {
        PageDao pageDao = new PageDaoImpl();
        int totalPage = pageDao.findTotalPage(currentNum);
        PageModel pageModel = new PageModel(currentNum,5,totalPage);
        List list = pageDao.findProducts(pageModel.getStartIndex(),pageModel.getPageSize());
        pageModel.setList(list);
        pageModel.setUrl("PageServlet");
        return  pageModel;
    }
}
