package com.diegolirio.st.fixture;
 
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.People;
import com.diegolirio.st.domain.orm.Product;
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
		createFixturePO(addressSender, addressRecipient, addressShippingCompany);
		return Fixture.from(PurchaseOrder.class).gimme("valid");
	}


	private void createFixturePO(Address addressSender, Address addressRecipient, Address addressShippingCompany) {
		Fixture.of(PurchaseOrder.class).addTemplate("valid", new Rule() {{
			//add("createdDate", Calendar.getInstance());
			add("customerAddressSender", addressSender);
			add("customerAddressRecipient", addressRecipient);
			add("customerAddressShippingCompany", addressShippingCompany);
			add("phoneSender", "11955554444");
			add("phoneRecipient", "11955554444");
			add("phoneShippingCompany", "11955554444");
			add("contactRecipient", "Fulano");
		}});
	}


	public List<PurchaseOrder> fixturePurchaseList() {
		createFixturePO(null, null, null);
		return Fixture.from(PurchaseOrder.class).gimme(5, "valid");
	}


	public PurchaseOrder fixturePurchaseSaveFirst() {
		State state = fixtureState();
		People people = fixtureCustomer();
		Address address = fixtureAddress(people, state);
		Fixture.of(PurchaseOrder.class).addTemplate("saveFirst", new Rule() {{
			add("customerAddressSender", address);
			add("customerAddressRecipient", address);
			add("customerAddressShippingCompany", address);
			add("phoneSender", "11955554444");
			add("phoneRecipient", "11955554444");
			add("phoneShippingCompany", "11955554444");
			add("contactRecipient", "Fulano");
		}});
		return Fixture.from(PurchaseOrder.class).gimme("saveFirst");
	}

	public State fixtureState() {
		Fixture.of(State.class).addTemplate("valid", new Rule() {{
			add("abbreviation","SP");
			add("name", "São Paulo");
		}});
		return Fixture.from(State.class).gimme("valid");
	}

	public Product fixtureProduct() {
		Fixture.of(Product.class).addTemplate("valid", new Rule() {{
			add("code","123");
			add("description", "Notebook");
			add("valueUnit", 500.0d);
		}});
		return Fixture.from(Product.class).gimme("valid");
	}

	public OrderProduct fixtureOrderProduct() {
		Fixture.of(OrderProduct.class).addTemplate("valid", new Rule() {{
			add("purchaseOrder", fixturePurchaseSaveFirst());
			add("product", fixtureProduct());
			add("valueUnit", 500.0d);
			add("amount", 2);
		}});
		return Fixture.from(OrderProduct.class).gimme("valid");
	}


	public List<OrderProduct> fixtureItemList() {
		Fixture.of(OrderProduct.class).addTemplate("valid", new Rule() {{
			add("purchaseOrder", fixturePurchaseSaveFirst());
			add("product", fixtureProduct());
			add("valueUnit", 500.0d);
			add("amount", 2);
		}});
		return Fixture.from(OrderProduct.class).gimme(5, "valid");	
	}


	public PurchaseOrder fixturePurchaseWithItens() {
		State state = fixtureState();
		People people = fixtureCustomer();
		Address address = fixtureAddress(people, state);
		Fixture.of(PurchaseOrder.class).addTemplate("poWithItens", new Rule() {{
			add("id", "51sc51f12d61f62g");
			add("customerAddressSender", address);
			add("customerAddressRecipient", address);
			add("customerAddressShippingCompany", address);
			add("phoneSender", "11955554444");
			add("phoneRecipient", "11955554444");
			add("phoneShippingCompany", "11955554444");
			add("contactRecipient", "Fulano");
			add("paymentsTerms", "Contrato: ABC");
			add("ordersProducts", fixtureItemList());
		}});
		return Fixture.from(PurchaseOrder.class).gimme("poWithItens");
	}		
  	
}
