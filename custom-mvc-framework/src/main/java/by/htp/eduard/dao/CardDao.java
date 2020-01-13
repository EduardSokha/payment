package by.htp.eduard.dao;

import java.util.List;

import by.htp.eduard.entities.Card;

public interface CardDao {
	List<Card> getAllCards();
	List<Card> getCardByIdAccount(Integer id);
	Card getCardById(Integer id);
	Card saveCard(Card card);
	void deleteCard(Integer id);
}
