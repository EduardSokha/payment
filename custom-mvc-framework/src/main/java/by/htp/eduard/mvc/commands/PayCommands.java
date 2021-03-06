package by.htp.eduard.mvc.commands;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.dto.CardDto;
import by.htp.eduard.entities.Pay;
import by.htp.eduard.service.CardService;
import by.htp.eduard.service.PayService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.service.exceptions.NegativeBalanceException;
import by.htp.eduard.utils.HttpUtils;

public class PayCommands {
	
	private final PayService payService;
	private final CardService cardService;	
//	private final AccountService accountService;

	public PayCommands() {
//		accountService = ServiceProvider.getInstance().getAccountService();
		payService = ServiceProvider.getInstance().getPayService();
		cardService = ServiceProvider.getInstance().getCardService();
	}
	
	public String showAllPayments(HttpServletRequest request) {
		List<Pay> allPayments = payService.getAllPay();
		request.setAttribute("allPayments", allPayments);
		
		return "/WEB-INF/pages/pay/pay-list.jsp";
	}
	
	public String createPay(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("cardId", request);
		
		CardDto card = cardService.getCardById(id);
		
		request.setAttribute("card", card);
		
		return "/WEB-INF/pages/pay/pay-details.jsp";
	}
	
	public String savePay(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("id", request);
		Double price = HttpUtils.getDoubleParam("price", request);
		Integer idAccount = HttpUtils.getIntParam("idAccount", request);
		String description = request.getParameter("description");
		
		Pay pay = new Pay();
		pay.setId(id);
		pay.setDate(new Date());
		pay.setPrice(price);
		pay.setIdAccount(idAccount);
		pay.setDescription(description);
		
		try {
			payService.savePay(pay);
		} catch (NegativeBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:payments-list";
//		cards-list
	}
	
	public String deletePay(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("payId", request);
		payService.deletePay(id);
		return "redirect:payments-list";
	}

}
