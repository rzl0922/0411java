package com.offcn.dao;

import com.offcn.bean.Country;
import com.offcn.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CountryDaoImpl implements CountryDao {
    @Override
    public List<Country> selectAllCountry() {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from country";
        List<Country> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(Country.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
