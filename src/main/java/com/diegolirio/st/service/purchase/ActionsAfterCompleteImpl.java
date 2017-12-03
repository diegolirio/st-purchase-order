package com.diegolirio.st.service.purchase;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ActionsAfterCompleteImpl implements ActionsAfterCompleteService {

	@Override
	public void executeActions(List<ActionCompleting> actions) {
		for (ActionCompleting action: actions) {
			action.execute();			
		}
	}

}
