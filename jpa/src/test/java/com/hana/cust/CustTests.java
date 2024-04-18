package com.hana.cust;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.service.CustService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
class CustTests {
	@Autowired
	CustService custService;
	@Test
	void contextLoads() {
		CustEntity cust = CustEntity.builder()
				.id("id02")
				.name("name02")
				.pwd("pwd02")
				.build();
		custService.insert(cust);
		log.info("OK----------------------");

		Optional<CustEntity> op = custService.get("id02");
		if(op.isPresent()){
			log.info(op.get().toString());
		}

		CustEntity cust2 = CustEntity.builder()
				.id("id02")
				.name("xxxx")
				.pwd("pwd02")
				.build();
		custService.update(cust2);
		List<CustEntity> list = custService.get();
		list.forEach(c -> log.info(c.toString()));
	}

}
