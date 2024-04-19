package com.hana.custaddr;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.service.CustAddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SelectTests {
	@Autowired
	CustAddrService service;
	@Test
	void contextLoads() {
		service.get().forEach(c->
				{
					log.info(c.toString());
					log.info(c.getCust().getId());
				}
		);
		log.info("OK");
	}

}
