package com.hana.app.frame;

import com.hana.app.exception.DuplicatedIdException;

import java.util.List;

public interface Service<K, V> {
    int add(V v) throws DuplicatedIdException;
    int del(K k) throws Exception;
    int modify(V v) throws Exception;
    V get(K k) throws Exception;
    List<V> get() throws Exception;
}
