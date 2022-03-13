package com.capitole.challenge;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.capitole.challenge.domian.api.entity.Price;
import com.capitole.challenge.infrastructure.persistence.adapter.PriceAdapter;
import com.capitole.challenge.infrastructure.persistence.entity.PriceEntity;
import com.capitole.challenge.infrastructure.persistence.mapper.PriceMapper;
import com.capitole.challenge.infrastructure.persistence.repository.PriceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ChallengeApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
		
	@Test
	void whenCallingFindPriceEndpoint_withNotValidParams_thenReturnBadRequest() throws Exception {
		mockMvc.perform(get("/api/findPrice?applicationDate=null&product=null&brand=null")).andExpect(status().isBadRequest());
		
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=null&brand=null")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=null&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=35455&brand=null")).andExpect(status().isBadRequest());

		mockMvc.perform(get("/api/findPrice?applicationDate=null&product=35455&brand=null")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=null&product=35455&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=35455&brand=null")).andExpect(status().isBadRequest());
		
		mockMvc.perform(get("/api/findPrice?applicationDate=null&product=null&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=null&product=35455&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=null&brand=1")).andExpect(status().isBadRequest());
		
		
		mockMvc.perform(get("/api/findPrice?xxxxx=null&product=null&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=null&xxxxx=35455&brand=1")).andExpect(status().isBadRequest());
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-00-16T00:00:00&product=null&xxxx=1")).andExpect(status().isBadRequest());

	}

	@Test
	void whenCallingFindPriceEndpoint_withValidParams_thenReturnNoContent() throws Exception {
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-06-16T21:00:00&product=35455&brand=1")).andExpect(status().isNoContent());

	}
	
	@Test
	void testCaseOne() throws Exception {
		this.mockMvc.perform(get("/api/findPrice?applicationDate=2020-06-14T10:00:00&product=35455&brand=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5));
	}

	@Test
	void testCaseTwo() throws Exception {
		this.mockMvc.perform(get("/api/findPrice?applicationDate=2020-06-14T16:00:00&product=35455&brand=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(25.45));
	}
	
	@Test
	void useCaseThreeTest() throws Exception {
		this.mockMvc.perform(get("/api/findPrice?applicationDate=2020-06-14T21:00:00&product=35455&brand=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(35.5));
	}
	
	@Test
	void testCaseFour() throws Exception {
		this.mockMvc.perform(get("/api/findPrice?applicationDate=2020-06-15T10:00:00&product=35455&brand=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(30.5));
	}
	
	@Test
	void testCaseFive() throws Exception {
		this.mockMvc.perform(get("/api/findPrice?applicationDate=2020-06-16T21:00:00&product=35455&brand=1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.price").value(38.95));
	}
	
	@Test
	void whenCallingFindPriceEndpoint_withValidParams_thenReturnBadRequest() throws Exception {
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-06-16T21:00:00&product=35455&brand=2"))
		.andExpect(status().isBadRequest());
		
		mockMvc.perform(get("/api/findPrice?applicationDate=2022-06-16T21:00:00&product=35451&brand=1"))
		.andExpect(status().isBadRequest());
	}
	
}
