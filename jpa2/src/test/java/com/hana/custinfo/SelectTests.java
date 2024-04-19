package com.hana.custinfo;

import com.hana.app.service.CateService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SelectTests {
	@Autowired
	CateService service;

	@Test
	void contextLoads() {
		service.get().forEach(c->log.info(c.toString()));
		log.info("OK");
	}

}
