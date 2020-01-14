package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.dto.CardDto;
import by.htp.eduard.entities.Account;
import by.htp.eduard.entities.Card;

public interface CardService {
	List<CardDto> getAllCards();
	List<CardDto> getCardByIdAccount(Integer id);
	CardDto getCardById(Integer id);
	CardDto saveCard(CardDto cardDto);
	void deleteCard(Integer id);
	boolean createAccountAndCard(Account account, Card card);
}
