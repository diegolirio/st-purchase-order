package com.diegolirio.st.report;

import java.io.File;
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

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Component("purchaseReportPDF")
class PurchaseReportPDF implements PurchaseReport {

	@Autowired
	private ResourceLoader resourceLoader;

	
	@Override
	public byte[] generate(PurchaseOrder purchaseOrder) {
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
			return JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
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
