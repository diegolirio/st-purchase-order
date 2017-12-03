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

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.fixture.FixtureTests;
import com.diegolirio.st.service.item.OrderProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class OrderProductApiRestServiceTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Mock
	private OrderProductService orderProductService; 

	@Autowired
	private FixtureTests fixture;

	private OrderProduct orderProduct;
	
	@Before
	public void before() throws Exception {
		orderProduct = fixture.fixtureOrderProduct();
	}

	@Test
	public void testSave() throws Exception {
		when(orderProductService.save(orderProduct)).thenReturn(orderProduct);
		String json = objectMapper.writeValueAsString(orderProduct);
		mockMvc.perform(post(OrderProductApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.content(json ))
						.andExpect(status().isOk());
	}
	
	@Test
	public void testFindByPurchaseOrder() throws Exception {
		List<OrderProduct> list = fixture.fixtureItemList();
		when(orderProductService.findByPurchaseOrderId("123")).thenReturn(list);
		String json = objectMapper.writeValueAsString(orderProduct);
		mockMvc.perform(get(OrderProductApiRestService.URL+"/123")
							.accept(MediaType.APPLICATION_JSON_UTF8)
							.contentType(MediaType.APPLICATION_JSON_UTF8)
							.content(json ))
						.andExpect(status().isOk());
	}
	
	
}
