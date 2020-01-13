package by.htp.eduard.service;

import java.util.List;

import by.htp.eduard.dto.AccountDto;

public interface AccountService {
	List<AccountDto> getAllAccounts();
	List<AccountDto> getAccountByIdUser(Integer id);
	AccountDto getAccountById(Integer id);
	AccountDto saveAccount(AccountDto accountDto);
	AccountDto lockUnlockAccount(AccountDto accountDto);
	AccountDto updateBalanceAccount(AccountDto accountDto);
	void deleteAccount(Integer id);
}
