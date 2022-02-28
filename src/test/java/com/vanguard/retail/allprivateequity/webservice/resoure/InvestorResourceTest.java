package com.vanguard.retail.allprivateequity.webservice.resoure;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.vanguard.retail.allprivateequity.webservice.exception.MyPrivateEquityException;
import com.vanguard.retail.allprivateequity.webservice.mock.InvestorMock;
import com.vanguard.retail.allprivateequity.webservice.models.Investor;
import com.vanguard.retail.allprivateequity.webservice.models.InvestorRequest;
import com.vanguard.retail.allprivateequity.webservice.resource.InvestorResource;
import com.vanguard.retail.allprivateequity.webservice.service.InvestorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvestorResourceTest {

	@Mock
	InvestorService investorService; 
	@InjectMocks
	InvestorResource investorResource ;
	@Test
	public void  createInvestorsucess() {

	InvestorRequest investorRequest	=InvestorMock.getInvestorRequest();
	 Optional<Investor>  optional	=InvestorMock.getInvestor();
	when(investorService.saveInvestor(any())).thenReturn(optional);
	ResponseEntity<String > responseEntity=investorResource.createInvestor(investorRequest);
		assertNotNull(responseEntity);
	}
	@Test(expected = MyPrivateEquityException.class)
	public void  createInvestorwhenExceptionOccurs() {

	InvestorRequest investorRequest	=InvestorMock.getInvestorRequest();
	 doThrow(MyPrivateEquityException.class).when(investorService).saveInvestor(any());
	ResponseEntity<String > responseEntity=investorResource.createInvestor(investorRequest);
		assertNotNull(responseEntity);
	}

	@Test
	public void  updateInvestorsucess() {

	InvestorRequest investorRequest	=InvestorMock.getInvestorRequest();
	 Optional<Investor>  optional	=InvestorMock.getInvestor();
	when(investorService.updateInvestor(any())).thenReturn(optional);
	ResponseEntity<String > responseEntity=investorResource.updateInvestor(investorRequest);
		assertNotNull(responseEntity);
	}
	
	@Test(expected = MyPrivateEquityException.class)
	public void  updateInvestorwhenExceptionOccurs() {

		InvestorRequest investorRequest	=InvestorMock.getInvestorRequest();
		 doThrow(MyPrivateEquityException.class).when(investorService).updateInvestor(any());
			ResponseEntity<String > responseEntity=investorResource.updateInvestor(investorRequest);
			assertNotNull(responseEntity);
	}
	
	@Test
	public void  getInvestorByIdsucess() {
Integer investorId=1;
	 Optional<Investor>  optional	=InvestorMock.getInvestor();
	when(investorService.getIvestorByID(any())).thenReturn(optional);
	ResponseEntity<Investor> responseEntity=investorResource.getIvestorByID(investorId);
		assertNotNull(responseEntity);
	}
	
	@Test(expected = MyPrivateEquityException.class)
	public void  getInvestorByIdsucess1() {
Integer investorId=1;
	 Optional<Investor>  optional	=Optional.empty();
	when(investorService.getIvestorByID(any())).thenReturn(optional);
	ResponseEntity<Investor> responseEntity=investorResource.getIvestorByID(investorId);
		assertNotNull(responseEntity);
	}

	@Test
	public void getAllInvestorSucess()
	{
	List<Investor> investors	=InvestorMock.getListOfInvestor();
		when(investorService.getAllInvestor()).thenReturn(investors);
		ResponseEntity<List<Investor>> responseEntity=investorResource.getAllInvestor();
			assertNotNull(responseEntity);
		
	}
	
	@Test(expected = MyPrivateEquityException.class)
	public void getAllInvestorexception()
	{
		
		doThrow(MyPrivateEquityException.class).when(investorService).getAllInvestor();
		ResponseEntity<List<Investor>> responseEntity=investorResource.getAllInvestor();
		assertNotNull(responseEntity);

	}
}
