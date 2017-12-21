package com.diegolirio.st.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PurchaseReportFactory {

	@Autowired
	@Qualifier("purchaseReportPDF")
	private PurchaseReport purchaseReportPDF;

	public PurchaseReport getReport(ReportType reportType) {
		if(ReportType.PDF == reportType)
			return purchaseReportPDF;
		return purchaseReportPDF;
	}
	
}
