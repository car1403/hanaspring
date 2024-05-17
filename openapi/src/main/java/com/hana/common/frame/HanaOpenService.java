package com.hana.common.frame;



import org.springframework.http.ResponseEntity;

public interface HanaOpenService<V,K> {

    ResponseEntity<?> get(K k);

    ResponseEntity<?> save(V v);

    ResponseEntity<?> modify(V v) throws Exception;

    ResponseEntity<?> delete(K k) throws Exception;

    ResponseEntity<?> getall();

}