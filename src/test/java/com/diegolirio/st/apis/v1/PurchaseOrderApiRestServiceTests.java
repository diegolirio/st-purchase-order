package com.diegolirio.st.apis.v1;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.fixture.FixtureTests;
import com.diegolirio.st.service.purchase.PurchaseOrderService;
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
	
	@Mock
	private PurchaseOrderService purchaseOrderService; 

	@Autowired
	private FixtureTests fixture;
	
	@Before
	public void before() {
		purchase = fixture.fixturePurchase(null, null, null);
	}


	@Test
	public void testFindAll() throws Exception {
		List<PurchaseOrder> list = fixture.fixturePurchaseList(); 
		when(purchaseOrderService.findAll()).thenReturn(list);
		mockMvc.perform(get(PurchaseOrderApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
	@Test
	public void testSave() throws Exception {
		when(purchaseOrderService.save(purchase)).thenReturn(purchase);
		String json = objectMapper.writeValueAsString(purchase);
		mockMvc.perform(post(PurchaseOrderApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.content(json))
						.andExpect(status().isOk());
	}

	@Test
	public void testFindOne() throws Exception {
		String id = "12365154";
		when(purchaseOrderService.findOne(id)).thenReturn(purchase);
		mockMvc.perform(get(PurchaseOrderApiRestService.URL+"/"+id)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
	
}
