package com.heima.dao;

import com.heima.utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public interface PageDao {

    int findTotalPage(int currentNum) throws SQLException;

    List findProducts(int startIndex, int pageSize) throws SQLException;
}
