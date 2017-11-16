package com.diegolirio.st.apis.v1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PurchaseOrderApiRestServiceTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testFindAll() throws Exception {
		mockMvc.perform(get(PurchaseOrderApiRestService.URL)
							.accept(MediaType.APPLICATION_JSON_UTF8))
						.andExpect(status().isOk());
	}
	
}
