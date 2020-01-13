package by.htp.eduard.mvc.commands;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.entities.Currency;
import by.htp.eduard.service.CurrencyService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.utils.HttpUtils;

public class CurrencyCommand {
	
	private final CurrencyService currencyService;

	public CurrencyCommand() {
		currencyService = ServiceProvider.getInstance().getCurrencyService();
	}
	
	public String showAllCurrencies(HttpServletRequest request) {
		List<Currency> allCurrencies = currencyService.getAllCurrencies();
		request.setAttribute("allCurrencies", allCurrencies);
		
		return "/WEB-INF/pages/currencies/currencies-list.jsp";
	}
	
	public String addCurrency(HttpServletRequest request) {		
		return "/WEB-INF/pages/currencies/currency-details.jsp";
	}
	
	public String saveCurrency(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("id", request);
		String name = request.getParameter("newCurrency");
		
		Currency currency = new Currency();
		currency.setId(id);
		currency.setName(name);
		
		currencyService.saveCurrency(currency);
		
		return "redirect:currency-list";
	}

	public String editCurrency(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("currencyId", request);
		Currency currency = currencyService.getNameCurrencyById(id);
		request.setAttribute("currency", currency);
		return "/WEB-INF/pages/currencies/currency-details.jsp";
	}
	
	public String deleteCurrency(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("currencyId", request);
		currencyService.deleteCurrency(id);
		return "redirect:currency-list";
	}
}
