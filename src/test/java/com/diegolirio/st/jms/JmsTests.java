package com.diegolirio.st.jms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

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

	@Test
	public void testReceive() throws Exception {
		emailProducer.send("email.box.q", "Hello Email!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		assertThat(receiver.getLatch().getCount()).isEqualTo(0);
	}
}
