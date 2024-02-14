package id.ac.ui.cs.advprog.eshop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.springframework.boot.SpringApplication;

@SpringBootTest
class EshopApplicationTests {

	@Test
	void contextLoads() {
		EshopApplication.main(new String[] {});
	}
}
