package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.entities.Account;
import by.htp.eduard.entities.Card;

public interface CardService {
	List<Card> getAllCards();
	List<Card> getCardByIdAccount(Integer id);
	Card getCardById(Integer id);
	Card saveCard(Card card);
	void deleteCard(Integer id);
	boolean createAccountAndCard(Account account, Card card);
}
