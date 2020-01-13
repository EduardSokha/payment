package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.entities.Currency;

public interface CurrencyService {
	List<Currency> getAllCurrencies();
	Currency getNameCurrencyById(Integer id);
	Currency saveCurrency(Currency currency);
	void deleteCurrency(Integer id);
}
