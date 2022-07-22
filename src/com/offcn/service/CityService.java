package com.offcn.service;

import com.offcn.bean.City;

import java.util.List;

public interface CityService {
    List<City> selectCity(int countryId);
}
