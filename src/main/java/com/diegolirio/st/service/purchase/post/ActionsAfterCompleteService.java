package com.diegolirio.st.service.purchase.post;

import java.util.List;

public interface ActionsAfterCompleteService {

	void executeActions(List<ActionCompleting> actions);

}
