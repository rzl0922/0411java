package com.offcn.service;

import com.offcn.bean.City;
import com.offcn.dao.CityDao;
import com.offcn.dao.CityDaoImpl;

import java.util.List;

public class CityServiceImpl implements CityService {
    private CityDao cd = new CityDaoImpl();
    @Override
    public List<City> selectCity(int countryId) {
        return cd.selectCity(countryId);
    }
}
