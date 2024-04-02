package com.hana.app.frame;

import java.util.List;

public interface HanaRepository<K,V> {

    int insert(V v) throws Exception;
    int delete(K k) throws Exception;
    int update(V v) throws Exception;;
    V selectOne(K k) throws Exception;;
    List<V> select() throws Exception;;
}
