package com.offcn.service;

import com.offcn.bean.Product;
import com.offcn.dao.ProductDao;
import com.offcn.dao.ProductDaoImpl;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductDao pd = new ProductDaoImpl();
    @Override
    public List<Product> selectProductName(String productname) {
        return pd.selectProductName(productname);
    }
}
