package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.entities.Pay;

public interface PayService {
	
	List<Pay> getAllPay();
	Pay getPayById(Integer id);
	Pay savePay(Pay pay);
	void deletePay(Integer id);

}
