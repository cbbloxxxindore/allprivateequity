package com.vanguard.retail.allprivateequity.webservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.retail.allprivateequity.webservice.dao.InvestorRepo;
import com.vanguard.retail.allprivateequity.webservice.mock.InvestorMock;
import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestorServiceTest {
	@Mock
	InvestorRepo investorRepo; 
	@InjectMocks
	InvestorServiceImpl investorServiceImpl ;
	
	
@Test
public 	void saveInvestor()
{
	Investor investor=InvestorMock.getInvestor1();
	InvestorRequest investorRequest	=InvestorMock.getInvestorRequest();
	when(investorRepo.save(any())).thenReturn(investor);

	 Optional<Investor>  optional=investorServiceImpl.saveInvestor(investorRequest);
	 assertNotNull(optional.get());

}
}
