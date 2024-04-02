package com.hana.app.frame;


import java.util.List;

public interface HanaService<K, V> {
    int add(V v) throws Exception;
    int del(K k) throws Exception;
    int modify(V v) throws Exception;
    V get(K k) throws Exception;
    List<V> get() throws Exception;
}
