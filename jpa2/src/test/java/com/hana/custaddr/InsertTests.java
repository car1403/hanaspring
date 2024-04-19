package com.hana.custaddr;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.repository.CustAddrRepository;
import com.hana.app.service.CustAddrService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class InsertTests {
	@Autowired
	CustAddrService service;
	@Test
	void contextLoads() {
		CustEntity cust = CustEntity.builder()
				.id("id01")
				.build();
		CustAddrEntity custAddr = CustAddrEntity.builder()
				.cust(cust)
				.addr("서울2")
				.build();
		service.insert(custAddr);
		log.info("OK");
	}

}
