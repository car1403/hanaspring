package com.hana;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class JpaApplicationTests {

	@Test
	void contextLoads() {
		log.info("OK----------------------");
	}

}
