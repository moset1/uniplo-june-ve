package com.barcode.uniplo.dao;

import com.barcode.uniplo.domain.OrderDto;
import com.barcode.uniplo.domain.OrderProductDto;

public interface OrderDao {
    int insertOrder(OrderDto order);
    int insertOrderProduct(OrderProductDto orderProduct);
}