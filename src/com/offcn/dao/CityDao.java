package com.offcn.dao;

import com.offcn.bean.City;

import java.util.List;

public interface CityDao {
    List<City> selectCity(int countryId);
}
