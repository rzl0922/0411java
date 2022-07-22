package com.offcn.dao;

import com.offcn.bean.City;
import com.offcn.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CityDaoImpl implements CityDao {
    @Override
    public List<City> selectCity(int countryId) {
        QueryRunner qr = new QueryRunner(JDBCUtil.getDataSource());
        String sql = "select * from city where country_id = ?";
        List<City> list = null;
        try {
            list = qr.query(sql, new BeanListHandler<>(City.class), countryId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
