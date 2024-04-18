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
class InsertTests {

	@Autowired
	CustAddrService custAddrService;

	@Test
	void contextLoads() {
		CustEntity cust = CustEntity.builder().id("id02").build();
		CustAddrEntity custAddr = CustAddrEntity.builder()
				.name("우리집3")
				.addr("Seoul Korea3")
				.cust(cust)
				.build();
		custAddrService.insert(custAddr);
		log.info("OK----------------------");
	}

}



