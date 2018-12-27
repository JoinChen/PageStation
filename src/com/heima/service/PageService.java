package com.heima.service;

import com.heima.utils.PageModel;

import java.sql.SQLException;

public interface PageService {
    PageModel findProducts(int currentNum) throws SQLException;
}
