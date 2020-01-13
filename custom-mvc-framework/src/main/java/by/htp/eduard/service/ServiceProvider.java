package by.htp.eduard.service;

import by.htp.eduard.service.impl.AccountServiceImpl;
import by.htp.eduard.service.impl.AuthenticationServiceImpl;
import by.htp.eduard.service.impl.CardServiceImpl;
import by.htp.eduard.service.impl.CurrencyServiceImpl;
import by.htp.eduard.service.impl.DozerEntityDtoConverter;
import by.htp.eduard.service.impl.NameCardServiceImpl;
import by.htp.eduard.service.impl.PayServiceImpl;
import by.htp.eduard.service.impl.PaymentSystemServiceImpl;
import by.htp.eduard.service.impl.RoleServiceImpl;
import by.htp.eduard.service.impl.UserServiceImpl;

public class ServiceProvider {
	
private static final ServiceProvider instance = new ServiceProvider();
	
	private ServiceProvider() {}
	
	private UserService userService = new UserServiceImpl();
	
	private PaymentSystemService paymentSystemService = new PaymentSystemServiceImpl();
	
	private NameCardService nameCardService = new NameCardServiceImpl();
	
	private CurrencyService currencyService = new CurrencyServiceImpl();

	private RoleService roleService = null;

	private CardService cardService = new CardServiceImpl();

	private AccountService accountService = null;

	private PayService payService = new PayServiceImpl();
	
	private AuthenticationService authenticationService = new AuthenticationServiceImpl();
	
	private EntityDtoConverter entityDtoConverter = null;
	
	public static ServiceProvider getInstance() {
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public PaymentSystemService getPaymentSystemService() {
		return paymentSystemService;
	}

	public NameCardService getNameCardService() {
		return nameCardService;
	}

	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	public RoleService getRoleService() {
		if(roleService == null) {
			roleService = new RoleServiceImpl();
		}
		
		return roleService;
	}

	public CardService getCardService() {
		return cardService;
	}

	public AccountService getAccountService() {
		if(accountService == null) {
			accountService = new AccountServiceImpl();
		}
		
		return accountService;
	}

	public PayService getPayService() {
		return payService;
	}

	public AuthenticationService getAuthenticationService() {
		return authenticationService;
	}

	public EntityDtoConverter getEntityDtoConverter() {
		if(entityDtoConverter == null) {
			entityDtoConverter = new DozerEntityDtoConverter();
		}
		
		return entityDtoConverter;
	}
}
