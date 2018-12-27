package com.heima.dao.impl;

import com.heima.dao.PageDao;
import com.heima.domain.Product;
import com.heima.utils.JDBCUtils;
import com.heima.utils.PageModel;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class PageDaoImpl implements PageDao {

    @Override
    public int findTotalPage(int currentNum) throws SQLException {
        String sql = "select count(*) from product ";
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        Long aLong = (Long) runner.query(sql, new ScalarHandler());
        return aLong.intValue();
    }

    @Override
    public List findProducts(int startIndex, int pageSize) throws SQLException {
        String sql = "select * from product limit  ?,?";
        QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
        return runner.query(sql,new BeanListHandler<Product>(Product.class),startIndex,pageSize);
    }
}
