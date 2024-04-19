package com.hana.cart;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.data.entity.ItemEntity;
import com.hana.app.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SelectTests {
	@Autowired
	CartService service;
	@Test
	void contextLoads() {
		service.get().forEach(c->log.info(c.toString()));
		log.info("OK");
	}

}
