package com.diegolirio.st.service.purchase;

import java.util.List;

public interface ActionsAfterCompleteService {

	void executeActions(List<ActionCompleting> actions);

}
