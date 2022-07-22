package com.offcn.dao;

import com.offcn.bean.Product;
import com.offcn.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> selectProductName(String productname) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from product where productname like ?";
        List<Product> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Product.class), "%" + productname + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
