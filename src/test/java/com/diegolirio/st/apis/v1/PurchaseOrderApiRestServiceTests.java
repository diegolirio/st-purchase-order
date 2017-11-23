package com.diegolirio.st.apis.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.People;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.State;
import com.diegolirio.st.fixture.FixtureTests;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PurchaseOrderApiRestServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	private PurchaseOrder purchase;

	@Autowired
	private FixtureTests fixture;
	
	@Before
	public void before() {
		purchase = fixture.fixturePurchase(null, null, null);
	}


	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(get(PurchaseOrderApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
	@Test
	public void testSave() throws Exception {
		Address address = postAddress();
		purchase = fixture.fixturePurchase(address , address, address);
		String json = objectMapper.writeValueAsString(purchase);
		mockMvc.perform(post(PurchaseOrderApiRestService.URL, json )
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}


	private Address postAddress() {
		People customer = postCustomer();
		State state = postState();
		fixture.fixtureAddress(customer, state);
		return null;
	}


	private State postState() {
		// TODO Auto-generated method stub
		return null;
	}


	private People postCustomer() {
		Customer fixtureCustomer = fixture.fixtureCustomer();
		return fixtureCustomer;
	}	
	
}
