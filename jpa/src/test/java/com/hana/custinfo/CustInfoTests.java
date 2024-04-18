package com.hana.custinfo;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.data.entity.CustInfoEntity;
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
		CustEntity cust = CustEntity.builder().id("id02").build();

//		CustInfoEntity custInfo = CustInfoEntity.builder()
//				.cust(cust)
//				.addr("Seoul Korea")
//				.age(30)
//				.build();
//		custInfoService.insert(custInfo);
		log.info("OK----------------------");

		CustInfoEntity custInfo1 = custInfoService.get(2L).get();
		log.info(custInfo1.toString());
		log.info(custInfo1.getCust().getId());
	}

}








