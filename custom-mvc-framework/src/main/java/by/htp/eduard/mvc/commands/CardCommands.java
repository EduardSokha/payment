package by.htp.eduard.mvc.commands;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import by.htp.eduard.dto.AccountDto;
import by.htp.eduard.dto.CardDto;
import by.htp.eduard.dto.CurrencyDto;
import by.htp.eduard.entities.Account;
import by.htp.eduard.entities.Card;
import by.htp.eduard.entities.NameCard;
import by.htp.eduard.entities.PaymentSystem;
import by.htp.eduard.entities.User;
import by.htp.eduard.service.AccountService;
import by.htp.eduard.service.CardService;
import by.htp.eduard.service.CurrencyService;
import by.htp.eduard.service.NameCardService;
import by.htp.eduard.service.PaymentSystemService;
import by.htp.eduard.service.ServiceProvider;
import by.htp.eduard.service.UserService;
import by.htp.eduard.utils.HttpUtils;

public class CardCommands {
	
	private final CardService cardService;
	private final NameCardService nameCardService;
	private final PaymentSystemService paymentSystemService;
	private final AccountService accountService;
	private final UserService userService;
	private final CurrencyService currencyService;

	public CardCommands() {
		cardService = ServiceProvider.getInstance().getCardService();
		nameCardService = ServiceProvider.getInstance().getNameCardService();
		paymentSystemService = ServiceProvider.getInstance().getPaymentSystemService();
		accountService = ServiceProvider.getInstance().getAccountService();
		currencyService = ServiceProvider.getInstance().getCurrencyService();
		userService = ServiceProvider.getInstance().getUserService();
	}
	
	public String showAllCards(HttpServletRequest request) {
		List<CardDto> cards = cardService.getAllCards();
		request.setAttribute("allCards", cards);
		
		return "/WEB-INF/pages/cards/cards-list.jsp";
	}
	
	public String addCard(HttpServletRequest request) {	
		
		List<NameCard> allTradeNamesCards = nameCardService.getAllNamesCard();
		request.setAttribute("allTradeNamesCards", allTradeNamesCards);
		
		List<PaymentSystem> allPaymentSystems = paymentSystemService.getAllPaymentSystems();
		request.setAttribute("allPaymentSystems", allPaymentSystems);
		
		List<AccountDto> allAccounts = accountService.getAllAccounts();
		request.setAttribute("allAccounts", allAccounts);
				
		return "/WEB-INF/pages/cards/card-details.jsp";
	}
	
	public String saveCard(HttpServletRequest request) {
		Integer idAccount = HttpUtils.getIntParam("idAccount", request);
		Integer idPaymentSystem = HttpUtils.getIntParam("idPaymentSystem", request);
		Integer idTradeNameCard = HttpUtils.getIntParam("idTradeNameCard", request);
		
		CardDto card = new CardDto();
		card.setDate(new Date());	
		card.setIdAccount(idAccount);
		card.setIdPaymentSystem(idPaymentSystem);
		card.setIdTradeNameCard(idTradeNameCard);
		
		cardService.saveCard(card);
		
		return "redirect:cards-list";
	}

	public String editCard(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("cardId", request);
		
		CardDto card = new CardDto();		
		card.setId(id);
		cardService.saveCard(card);
		return "redirect:cards-list";
	}
	
	public String deleteCard(HttpServletRequest request) {
		Integer id = HttpUtils.getIntParam("cardId", request);
		cardService.deleteCard(id);
		return "redirect:cards-list";
	}
	
	public String addCardAndAccount(HttpServletRequest request) {
		List<NameCard> allTradeNamesCards = nameCardService.getAllNamesCard();
		request.setAttribute("allTradeNamesCards", allTradeNamesCards);
		
		List<PaymentSystem> allPaymentSystems = paymentSystemService.getAllPaymentSystems();
		request.setAttribute("allPaymentSystems", allPaymentSystems);
		
		List<AccountDto> allAccounts = accountService.getAllAccounts();
		request.setAttribute("allAccounts", allAccounts);
		
		List<CurrencyDto> allCurrencies = currencyService.getAllCurrencies();
		request.setAttribute("allCurrencies", allCurrencies);
		
		List<User> allUsers = userService.getAllUsers();
		request.setAttribute("allUsers", allUsers);
		
		return "/WEB-INF/pages/cards/add-card-account.jsp";
	}
	
	public String saveCardAndAccount(HttpServletRequest request) {
		Integer idAccount = HttpUtils.getIntParam("idAccount", request);
		Integer idPaymentSystem = HttpUtils.getIntParam("idPaymentSystem", request);
		Integer idTradeNameCard = HttpUtils.getIntParam("idTradeNameCard", request);
		
		Integer id = HttpUtils.getIntParam("id", request);
		Double balance = HttpUtils.getDoubleParam("balance", request);
		Integer idUser = HttpUtils.getIntParam("idUser", request);
		Integer idStatus = HttpUtils.getIntParam("idStatus", request);
		Integer idCurrency = HttpUtils.getIntParam("idCurrency", request);
		
		Card card = new Card();
		card.setDate(new Date());	
		card.setIdAccount(idAccount);
		card.setIdPaymentSystem(idPaymentSystem);
		card.setIdTradeNameCard(idTradeNameCard);
		
		Account account = new Account();
		account.setId(id);
		account.setBalance(balance);
		account.setDate(new Date());
		account.setIdUser(idUser);
		account.setIdStatus(idStatus);
		account.setIdCurrency(idCurrency);
		
		cardService.createAccountAndCard(account, card);
		
		return "redirect:cards-list";
	}
}
