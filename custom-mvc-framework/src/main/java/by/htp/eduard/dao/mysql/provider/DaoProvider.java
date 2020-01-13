package by.htp.eduard.dao.mysql.provider;

import by.htp.eduard.dao.AccountDao;
import by.htp.eduard.dao.AuthenticationDao;
import by.htp.eduard.dao.CardDao;
import by.htp.eduard.dao.CurrencyDao;
import by.htp.eduard.dao.NameCardDao;
import by.htp.eduard.dao.PayDao;
import by.htp.eduard.dao.PaymentSystemDao;
import by.htp.eduard.dao.RoleDao;
import by.htp.eduard.dao.UserDao;
import by.htp.eduard.dao.mysql.AccountDaoImpl;
import by.htp.eduard.dao.mysql.AuthenticationDaoImpl;
import by.htp.eduard.dao.mysql.CardDaoImpl;
import by.htp.eduard.dao.mysql.CurrencyDaoImpl;
import by.htp.eduard.dao.mysql.NameCardDaoImpl;
import by.htp.eduard.dao.mysql.PayDaoImpl;
import by.htp.eduard.dao.mysql.PaymentSystemDaoImpl;
import by.htp.eduard.dao.mysql.RoleDaoImpl;
import by.htp.eduard.dao.mysql.UserDaoImpl;

public class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();

	private UserDao userDao = new UserDaoImpl();
	
	private PaymentSystemDao paymentSystemDao = new PaymentSystemDaoImpl();
	
	private NameCardDao nameCardDao = new NameCardDaoImpl();
	
	private CurrencyDao currencyDao = new CurrencyDaoImpl();

	private RoleDao roleDao = new RoleDaoImpl();

	private CardDao cardDao = new CardDaoImpl();

	private AccountDao accountDao = new AccountDaoImpl();
	
	private PayDao payDao = new PayDaoImpl();
	
	private AuthenticationDao authenticationDao = new AuthenticationDaoImpl();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public PaymentSystemDao getPaymentSystemDao() {
		return paymentSystemDao;
	}

	public NameCardDao getNameCardDao() {
		return nameCardDao;
	}

	public CurrencyDao getCurrencyDao() {
		return currencyDao;
	}

	public RoleDao getRoleDao() {
		return roleDao;
	}

	public CardDao getCardDao() {
		return cardDao;
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public PayDao getPayDao() {
		return payDao;
	}

	public AuthenticationDao getAuthenticationDao() {
		return authenticationDao;
	}
}
