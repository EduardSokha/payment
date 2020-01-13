package by.htp.eduard.service.impl;

import java.util.List;

import by.htp.eduard.dao.AccountDao;
import by.htp.eduard.dao.CardDao;
import by.htp.eduard.dao.mysql.provider.DaoProvider;
import by.htp.eduard.entities.Account;
import by.htp.eduard.entities.Card;
import by.htp.eduard.service.CardService;

public class CardServiceImpl implements CardService {

	private final CardDao cardDao;
	private final AccountDao accountDao;

	public CardServiceImpl() {
		cardDao = DaoProvider.getInstance().getCardDao();
		accountDao = DaoProvider.getInstance().getAccountDao();
	}

	@Override
	public List<Card> getAllCards() {
		return cardDao.getAllCards();
	}

	@Override
	public List<Card> getCardByIdAccount(Integer id) {
		return cardDao.getCardByIdAccount(id);
	}

	@Override
	public Card getCardById(Integer id) {
		return cardDao.getCardById(id);
	}

	@Override
	public Card saveCard(Card card) {
		return cardDao.saveCard(card);
	}

	@Override
	public void deleteCard(Integer id) {
		cardDao.deleteCard(id);
	}

	@Override
	public boolean createAccountAndCard(Account account, Card card) {
		Account newAccount = accountDao.saveAccount(account);
		card.setIdAccount(newAccount.getId());
		cardDao.saveCard(card);
		return true;
	}
}
