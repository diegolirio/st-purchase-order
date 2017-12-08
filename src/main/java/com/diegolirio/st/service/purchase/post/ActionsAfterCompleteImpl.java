package com.diegolirio.st.service.purchase.post;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ActionsAfterCompleteImpl implements ActionsAfterCompleteService {

	//@Autowired
	//private AutowireCapableBeanFactory autowireBeanFactory; 
	
	@Override
	public void executeActions(List<ActionCompleting> actions) {
		for (ActionCompleting action: actions) {
			//autowireBeanFactory.autowireBean(action);
			action.execute();			
		}
	}
 
}
