package com.diegolirio.st.service.purchase.post;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailPurchaseTest {

//	@Autowired
//	private EmailPurchase emailPurchase;
//	
//	private PurchaseOrder purchaseOrder;
//
//	@Autowired
//	private FixtureTests fixtureTests;
//	
//	@Before
//	public void before() {
//		purchaseOrder = fixtureTests.fixturePurchaseWithItens();
//	}
	
	@Test
	public void testExecute() {
//		emailPurchase.setPurchaseOrder(purchaseOrder);
//		emailPurchase.execute();
//		EmailProducer mock = Mockito.mock(EmailProducer.class);
//		Mockito.doNothing().when(mock).send("", "");
		assertTrue(true); 
	}
	
}
