package com.diegolirio.st.fixture;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.People;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.domain.orm.State;
import com.diegolirio.st.domain.orm.Telephone;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

@Component
public class FixtureTests {

	public Customer fixtureCustomer() {
		Fixture.of(Customer.class).addTemplate("valid", new Rule() {{
    		  add("cpfCnpj", String.valueOf(new Random().nextLong()));
    		  add("name", firstName());
    		  add("email", "${name}@email.com");
    		  add("active", true);
    		}});
    	return Fixture.from(Customer.class).gimme("valid");
	}	
	

	public Address fixtureAddress(People people, State state) {
		Fixture.of(Address.class).addTemplate("valid", new Rule() {{
			add("cep", "08544640");
			add("publicPlace", "Rua Ribeira Iguape");
			add("neighborhood", "Vila Nações");
			add("city", "Ferraz de Vasconcelos");
			add("number", 1);
			add("state", state);
			add("people", people);
			add("active", true);
		}});
		return Fixture.from(Address.class).gimme("valid");
	}


	public Telephone fixtureTelephone(People people) {
		Fixture.of(Telephone.class).addTemplate("valid", new Rule() {{
			add("contactType", "COMERCIAL");
			add("number", "11961409798");
			add("people", people);
			add("active", true);
		}});
		return Fixture.from(Telephone.class).gimme("valid");
	}	
	
	public PurchaseOrder fixturePurchase(Address addressSender, Address addressRecipient, Address addressShippingCompany) {
		Fixture.of(PurchaseOrder.class).addTemplate("valid", new Rule() {{
			add("createdDate", "10/10/2017");
			add("customerAddressSender", addressSender);
			add("customerAddressRecipient", addressRecipient);
			add("customerAddressShippingCompany", addressShippingCompany);
			add("phoneSender", "11955554444");
			add("phoneRecipient", "11955554444");
			add("pohoneShippingCompany", "11955554444");
			add("contactRecipient", "Fulano");
		}});
		return Fixture.from(PurchaseOrder.class).gimme("valid");
	}		
	
}
