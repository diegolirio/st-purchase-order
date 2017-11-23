package com.diegolirio.st.service.purchase;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.People;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.State;
import com.diegolirio.st.domain.orm.StatusType;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Override
	public List<PurchaseOrder> findAll() {
		State state = State.builder().abbreviation("SP").id("s5c1s5sc1v").name("SÃO PAULO").build();
		People peopleRecipient = Customer.builder().build(); //.active(true).cpfCnpj("3535458669").email("diegolirio.dl@gmail.com").id("sd51s4vc4sv").name("DIEGO LIRIO").build();
		 
		Address customerAddressRecipient = Address.builder().id("q5d1wcwe").active(true).cep("08544640").city("SÃO PAULO").neighborhood("CENTRO").number(1).people(peopleRecipient).publicPlace("Rua Ribeira Iguape").state(state).build();
		 
		PurchaseOrder po = PurchaseOrder.builder().id("354e852f93f")
								.contactRecipient("DIEGO")
								.createdDate(Calendar.getInstance())
								.customerAddressRecipient(customerAddressRecipient)
								.customerAddressSender(customerAddressRecipient)
								.customerAddressShippingCompany(customerAddressRecipient)
								.paymentsTerms("3X")
								.phoneRecipient("11961409798")
								.phoneSender("11961409798")
								.pohoneShippingCompany("11965255225")
								.remark("Obs...")
								.representative("DIEGO")
								.status(StatusType.PENDING)
								.build();
		
		return Arrays.asList(po);
	}

}
