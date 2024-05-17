package com.hana.common.frame;



import java.util.List;

public interface HanaService<K, V, R> {

    R get(K k);

    R save(V v);

    R modify(V v) throws Exception;

    Boolean delete(K k) throws Exception;

    List<R> get();

}