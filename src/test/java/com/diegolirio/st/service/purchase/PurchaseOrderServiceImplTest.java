package com.diegolirio.st.service.purchase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.StatusType;
import com.diegolirio.st.fixture.FixtureTests;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PurchaseOrderServiceImplTest {

	private PurchaseOrder purchase;

	@Autowired
	private PurchaseOrderService purchaseOrderService;
	
	@Mock
	private PurchaseOrderRepository purchaseOrderServiceImpl;
	
	@Autowired
	private FixtureTests fixture;
	
	@Before
	public void before() {
		purchase = fixture.fixturePurchaseSaveFirst();
	}
	
	@Test	
	public void testSaveDeveSalvarPOEConterStatusPendenteEDataCadastro() {
		when(purchaseOrderServiceImpl.save(purchase)).thenReturn(purchase);
		PurchaseOrder saved = purchaseOrderService.save(purchase);
		assertEquals(StatusType.PENDING, saved.getStatus());
		assertNotNull(saved.getCreatedDate()); 
		//assertTrue(saved.getCreatedDate().getTimeInMillis() <= Calendar.getInstance().getTimeInMillis());
	}
	
}
