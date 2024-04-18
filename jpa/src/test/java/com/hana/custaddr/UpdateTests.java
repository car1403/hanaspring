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
class UpdateTests {

	@Autowired
	CustAddrService custAddrService;

	@Test
	void contextLoads() {
		CustEntity cust = CustEntity.builder().id("id02").build();
		CustAddrEntity custAddr = CustAddrEntity.builder()
				.id(2L)
				.name("가원집3")
				.addr("Seoul Korea3")
				.cust(cust)
				.build();
		custAddrService.update(custAddr);
		log.info("OK----------------------");
	}

}



