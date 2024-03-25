package com.hana.app.frame;

import com.hana.exception.DuplicatedIdException;

import java.util.List;

public interface Dao<K,V> {
    /**
     * 2024.3.13
     * JMLEE
     * @param v: CustDto
     * @return int
     */
    int insert(V v) throws DuplicatedIdException;
    int delete(K k) throws Exception;
    int update(V v) throws Exception;;
    V select(K k) throws Exception;;
    List<V> select() throws Exception;;
}
