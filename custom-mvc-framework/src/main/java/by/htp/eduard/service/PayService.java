package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.entities.Pay;
import by.htp.eduard.service.exceptions.NegativeBalanceException;

public interface PayService {
	
	List<Pay> getAllPay();
	Pay getPayById(Integer id);
	Pay savePay(Pay pay) throws NegativeBalanceException;
	void deletePay(Integer id);

}
