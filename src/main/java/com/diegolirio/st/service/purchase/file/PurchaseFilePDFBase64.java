package com.diegolirio.st.service.purchase.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.report.PurchaseReport;
import com.diegolirio.st.report.PurchaseReportFactory;
import com.diegolirio.st.report.ReportType;
import com.sun.mail.util.BASE64EncoderStream;

@Component("PurchaseFilePDFBase64")
public class PurchaseFilePDFBase64 implements PurchaseFile {

	@Autowired
	private PurchaseReportFactory purchaseReportFactory;
	
	@Override
	public String toFile(PurchaseOrder purchaseOrder) {
		PurchaseReport report = this.purchaseReportFactory.getReport(ReportType.PDF);
		byte [] fileReport = report.generate(purchaseOrder);
		// TODO: Convert byteOrFile in Base64 String 
		byte[] encoded = BASE64EncoderStream.encode(fileReport); 
		String encodedString = new String(encoded);
		return encodedString;
	}
	
}
