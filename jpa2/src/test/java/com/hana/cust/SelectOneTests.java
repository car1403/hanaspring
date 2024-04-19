package com.hana.cust;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.service.CartService;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
class SelectOneTests {
	@Autowired
	CustService service;
	@Autowired
	CartService cartService;

	@Test
	void contextLoads() {
		Optional<CustEntity> op = service.get("id01");
		if(op.isPresent()) {
			CustEntity cust = op.get();
			log.info(cust.toString());
			cartService.findByCustId(cust.getId()).forEach(c->log.info(c.toString()));
		}
		log.info("OK");
	}

}
