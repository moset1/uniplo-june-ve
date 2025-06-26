package com.barcode.uniplo.repository;

import com.barcode.uniplo.dao.OrderDao;
import com.barcode.uniplo.domain.OrderDto;
import com.barcode.uniplo.domain.OrderProductDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository implements OrderDao {
    @Autowired
    private SqlSession sqlSession;

    private final String namespace = "com.barcode.uniplo.repository.OrderRepository";

    @Override
    public int insertOrder(OrderDto order) {
        return sqlSession.insert(namespace + ".insertOrder", order);
    }

    @Override
    public int insertOrderProduct(OrderProductDto orderProduct) {
        return sqlSession.insert(namespace + ".insertOrderProduct", orderProduct);
    }
}