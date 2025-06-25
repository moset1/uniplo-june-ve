package com.barcode.uniplo.dao;

import com.barcode.uniplo.dao.CartDao;
import com.barcode.uniplo.domain.CartDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepository implements CartDao {
    @Autowired
    private SqlSession sqlSession;

    private final String namespace = "com.barcode.uniplo.repository.CartRepository";

    public int insertCart(CartDto cart) {
        return sqlSession.insert(namespace + ".insertCart", cart);
    }

    public List<CartDto> getCartList(String userId) {
        return sqlSession.selectList(namespace + ".getCartList", userId);
    }

    public CartDto getCartItem(CartDto cartDto) {
        return sqlSession.selectOne(namespace + ".getCartItem", cartDto);
    }

    public int deleteCartItem(CartDto cart) {
        return sqlSession.delete(namespace + ".deleteCartItem", cart);
    }

    public boolean isDuplicate(CartDto cart) {
        int count = sqlSession.selectOne(namespace + ".checkDuplicate", cart);
        return count > 0;
    }

    public int updateCnt(CartDto cart) {
        return sqlSession.update(namespace + ".updateCnt", cart);
    }
}