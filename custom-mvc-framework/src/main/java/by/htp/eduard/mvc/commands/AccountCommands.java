package by.htp.eduard.mvc.commands;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.dto.AccountDto;
import by.htp.eduard.dto.CurrencyDto;
import by.htp.eduard.entities.NameCard;
import by.htp.eduard.entities.PaymentSystem;
import by.htp.eduard.entities.Status;
import by.htp.eduard.entities.User;
import by.htp.eduard.service.AccountService;
import by.htp.eduard.service.CurrencyService;
import by.htp.eduard.service.NameCardService;
import by.htp.eduard.service.PaymentSystemService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.service.StatusService;
import by.htp.eduard.service.UserService;
import by.htp.eduard.utils.HttpUtils;

public class AccountCommands {
	
	private final AccountService accountService;
	private final CurrencyService currencyService;
	private final NameCardService nameCardService;
	private final PaymentSystemService paymentSystemService;
	private final UserService userService;
	private final StatusService statusService;

	public AccountCommands() {
		accountService = ServiceProvider.getInstance().getAccountService();
		currencyService = ServiceProvider.getInstance().getCurrencyService();
		nameCardService = ServiceProvider.getInstance().getNameCardService();
		paymentSystemService = ServiceProvider.getInstance().getPaymentSystemService();
		userService = ServiceProvider.getInstance().getUserService();
		statusService = ServiceProvider.getInstance().getStatusService();
	}
	
	public String showAllAccounts(HttpServletRequest request) {
		List<AccountDto> allAccounts = accountService.getAllAccounts();
		request.setAttribute("allAccounts", allAccounts);
		
		return "/WEB-INF/pages/accounts/accounts-list.jsp";
	}
	
	public String addAccount(HttpServletRequest request) {	
		List<CurrencyDto> allCurrencies = currencyService.getAllCurrencies();
		request.setAttribute("allCurrencies", allCurrencies);
		
		List<User> allUsers = userService.getAllUsers();
		request.setAttribute("allUsers", allUsers);
		
		return "/WEB-INF/pages/accounts/accounts-details.jsp";
	}
	
	public String saveAccount(HttpServletRequest request) {
		
		Integer id = HttpUtils.getIntParam("id", request);
		Double balance = HttpUtils.getDoubleParam("balance", request);
		Integer idUser = HttpUtils.getIntParam("idUser", request);
		Integer idStatus = HttpUtils.getIntParam("idStatus", request);
		Integer idCurrency = HttpUtils.getIntParam("idCurrency", request);
		
		AccountDto account = new AccountDto();
		account.setId(id);
		account.setBalance(balance);
		account.setDate(new Date());
		account.setIdUser(idUser);
		account.setIdStatus(idStatus);
		account.setIdCurrency(idCurrency);
		
		accountService.saveAccount(account);
		
		return "redirect:accounts-list";
	}

	public String editAccount(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("accountId", request);
		AccountDto account = accountService.getAccountById(id);
		request.setAttribute("account", account);
		
		List<Status> allStatus = statusService.getAllStatus();
		request.setAttribute("allStatus", allStatus);
		
		return "/WEB-INF/pages/accounts/accounts-edit.jsp";
	}
	
	public String deleteAccount(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("accountId", request);
		accountService.deleteAccount(id);
		return "redirect:accounts-list";
	}
	
	public String lockUnlockAccount(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("accountId", request);
		Integer idStatus = HttpUtils.getIntParam("idStatus", request);
		
		AccountDto account = new AccountDto();		
		account.setId(id);
		account.setIdStatus(idStatus);
		accountService.lockUnlockAccount(account);
		return "redirect:accounts-list";
	}
	
	public String addCard(HttpServletRequest request) {
		
		Integer id = HttpUtils.getIntParam("accountId", request);
		AccountDto account = accountService.getAccountById(id);
		request.setAttribute("account", account);
		
		List<NameCard> allTradeNamesCards = nameCardService.getAllNamesCard();
		request.setAttribute("allTradeNamesCards", allTradeNamesCards);
		
		List<PaymentSystem> allPaymentSystems = paymentSystemService.getAllPaymentSystems();
		request.setAttribute("allPaymentSystems", allPaymentSystems);
		
		List<AccountDto> allAccounts = accountService.getAllAccounts();
		request.setAttribute("allAccounts", allAccounts);
		
		return "/WEB-INF/pages/cards/card-details.jsp";
	}
	
}
