package com.capitole.challenge;

import java.time.LocalDateTime;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.capitole.challenge.domian.api.entity.Price;
import com.capitole.challenge.infrastructure.persistence.adapter.PriceAdapter;
import com.capitole.challenge.infrastructure.persistence.entity.PriceEntity;
import com.capitole.challenge.infrastructure.persistence.repository.PriceRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Import(ChallengeApplicationTestsConfig.class)
public class PriceAdapterTest {

	@Autowired
	private PriceAdapter adapter;
	
	@MockBean
	private PriceRepository repository;
	
	@Autowired
	public PriceEntity expectedPriceEntityFirstRow;
	
	@Autowired
	@Qualifier("expectedApplicationDate")
	private LocalDateTime expectedApplicationDate;
	
	@Test
	void testGetPriceProductByDateProductBrandNativeQuery() {
		Mockito.when(this.repository.getPriceProductByDateProductBrand(ArgumentMatchers.any(), 
				ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt()))
		.thenReturn(expectedPriceEntityFirstRow);
		
		Price result = this.adapter.getPriceProductByDateProductBrandNativeQuery(expectedApplicationDate, 
				ChallengeApplicationTestsConfig.PRODUCT_ID, ChallengeApplicationTestsConfig.BRAND_ID);
		
		Assertions.assertThat(result).isNotNull();
		Mockito.verify(this.repository,Mockito.times(1)).getPriceProductByDateProductBrand(expectedApplicationDate, 
				ChallengeApplicationTestsConfig.PRODUCT_ID, ChallengeApplicationTestsConfig.BRAND_ID);
		
	}
}
