package com.hana.custinfo;

import com.hana.app.service.CustInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CustInfoTests {
	@Autowired
	CustInfoService custInfoService;

	@Test
	void contextLoads() {

		log.info("OK----------------------");
	}

}
