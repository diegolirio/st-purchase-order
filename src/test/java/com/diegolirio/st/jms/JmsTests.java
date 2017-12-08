package com.diegolirio.st.jms;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JmsTests {

	@Autowired
	private EmailProducer emailProducer;

	@Autowired
	private EmailReceiver receiver;
	
	//@Autowired
	//private JmsTemplate jmsTemplate;

	@Before
	public void before() {
		//Mockito.reset(jmsTemplate);
		//TextMessage message = mock(TextMessage.class);
		//BDDMockito.willReturn(new SimpleMessageConverter()).given(jmsTemplate).getMessageConverter();
		//BDDMockito.willReturn(message).given(this.jmsTemplate).receiveSelected(isNull());		
	}
	
	@Test
	public void testReceive() throws Exception {
		//emailProducer.send("email.box.q", "Hello Email!");
		 //assertThat(this.jmsTemplate.receiveAndConvert("bar")).isEqualTo("HELLO, WORLD!");
		//receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		//assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}
}
