package com.wfit.springbootshop.mapper;

import com.wfit.springbootshop.entity.Product;
import com.wfit.springbootshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductMappertests {
    @Autowired
    ProductMapper productMapper;
    @Autowired
    ProductService productService;

//    @Test
//    public void addProduct(){
//        Product product = new Product();
//        product.setId("3");
//        product.setNum(123);
//        product.setPrice(12);
//        product.setImage("/23/234/234/");
//        product.setTitle("钢笔");
//        product.setMerchantid("2");
//
//        productMapper.addProduct(product);
//    }
//
//    @Test
//    public void delProductById(){
//        productMapper.delProductById("3");
//    }
//
//
//    @Test
//    public void queryProductById(){
//        List<Product> list = productMapper.queryProductById("1");
//        for(Product product:list){
//            System.out.println(product);
//        }
//    }
}
