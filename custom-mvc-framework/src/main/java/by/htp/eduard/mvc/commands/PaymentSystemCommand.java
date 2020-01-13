package by.htp.eduard.mvc.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.entities.PaymentSystem;
import by.htp.eduard.service.PaymentSystemService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.utils.HttpUtils;

public class PaymentSystemCommand {
	
private final PaymentSystemService paymentSystemService;
	
	public PaymentSystemCommand() {
		paymentSystemService = ServiceProvider.getInstance().getPaymentSystemService();
	}
	
	public String showAllPaymentSystems(HttpServletRequest request) {
		List<PaymentSystem> allPaymentSystems = paymentSystemService.getAllPaymentSystems();
		request.setAttribute("allPaymentSystems", allPaymentSystems);
		
		return "/WEB-INF/pages/payment-systems/payment-system-list.jsp";
	}
	
	public String addPaymentSystem(HttpServletRequest request) {		
		return "/WEB-INF/pages/payment-systems/payment-system-details.jsp";
	}
	
	public String savePaymentSystem(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("id", request);
		String name = request.getParameter("newNamePaySyst");
		
		PaymentSystem paymentSystem = new PaymentSystem();
		paymentSystem.setId(id);
		paymentSystem.setName(name);
		
		paymentSystemService.savePaymentSystem(paymentSystem);
		
		return "redirect:payment-system-list";
	}
	
	public String editPaymentSystem(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("systemId", request);
		PaymentSystem paymentSystem = paymentSystemService.getPaymentSystemById(id);
		request.setAttribute("paymentSystem", paymentSystem);
		return "/WEB-INF/pages/payment-systems/payment-system-details.jsp";
	}
	
	public String deletePaymentSystem(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("systemId", request);
		paymentSystemService.deletePaymentSystem(id);
		return "redirect:payment-system-list";
	}
}
