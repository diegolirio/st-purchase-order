package com.diegolirio.st.service.purchase.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.OrderProduct;
import com.diegolirio.st.domain.orm.PurchaseOrder;
import com.diegolirio.st.resourcers.CustomerResource;
import com.diegolirio.st.resources.POReportDetail;
import com.sun.mail.util.BASE64EncoderStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component("PurchaseFilePDFBase64")
public class PurchaseFilePDFBase64 implements PurchaseFile {

	@Autowired
	private ResourceLoader resourceLoader;


	@Override
	public String toFile(PurchaseOrder purchaseOrder) {
		// TODO: Report with JasperReport
		byte[] fileReport = null; 
		try {
			//String path = this.getClass().getClassLoader().getResource("").getPath();
			//String pathToReportPackage = path + "com/diegolirio/st/service/purchase/file/";
			Resource resource = resourceLoader.getResource("classpath:po.jrxml");
	        File poIReport = resource.getFile();

	        String absolutePath = poIReport.getAbsolutePath();
	        System.out.println(absolutePath);
	        
			JasperReport report = JasperCompileManager.compileReport(absolutePath);
			List<POReportDetail> list = this.toResourcesReport(purchaseOrder);
			JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(list));
			fileReport = JasperExportManager.exportReportToPdf(print);
		} catch (JRException e) {
			e.printStackTrace(); 
		} catch (IOException e) {
			e.printStackTrace();
		}
		// TODO: Convert byteOrFile in Base64 String 
		byte[] encoded = BASE64EncoderStream.encode(fileReport); 
		String encodedString = new String(encoded);
		return encodedString;
	}
	
	private List<POReportDetail> toResourcesReport(PurchaseOrder purchaseOrder) {
		if (purchaseOrder.getOrdersProducts() == null || purchaseOrder.getOrdersProducts().size() < 1)
			return null;
		List<POReportDetail> list = new ArrayList<POReportDetail>();
		//CustomerResource sender = this.customerService.get(ordersProducts.get(0).getOrder().getCustomerAddressSender().getPeople().getId());
		//Customer recipient = this.customerService.get(ordersProducts.get(0).getOrder().getCustomerAddressRecipient().getPeople().getId());
		CustomerResource resourceSender = null;
		for (OrderProduct op : purchaseOrder.getOrdersProducts()) {
			POReportDetail mirror = new POReportDetail(op, resourceSender, resourceSender);
			list.add(mirror);
		}
		return list;
	}	
	
}
