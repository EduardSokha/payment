package by.htp.eduard.service.impl;

import java.util.List;

import by.htp.eduard.dao.CurrencyDao;
import by.htp.eduard.dao.mysql.provider.DaoProvider;
import by.htp.eduard.entities.Currency;
import by.htp.eduard.service.CurrencyService;

public class CurrencyServiceImpl implements CurrencyService {

	private final CurrencyDao currencyDao;
	
	public CurrencyServiceImpl() {
		currencyDao = DaoProvider.getInstance().getCurrencyDao();
	}

	@Override
	public List<Currency> getAllCurrencies() {
		return currencyDao.getAllCurrencies();
	}

	@Override
	public Currency getNameCurrencyById(Integer id) {
		return currencyDao.getNameCurrencyById(id);
	}

	@Override
	public Currency saveCurrency(Currency currency) {
		if(currency.getId() == null) {
			return currencyDao.saveCurrency(currency);
		}
		
		return currencyDao.updateNameCurrency(currency);
	}

	@Override
	public void deleteCurrency(Integer id) {
		currencyDao.deleteCurrency(id);
	}
}
