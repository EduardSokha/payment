package by.htp.eduard.service.converters;

import org.dozer.DozerConverter;

public class AccountStatusIdNameConverter extends DozerConverter<Integer, String> {

	
	
	public AccountStatusIdNameConverter() {
		super(Integer.class, String.class);
//		accountDao = DaoProvider.getInstance().getAccountDao();
	}

	@Override
	public String convertTo(Integer source, String destination) {
//		Account account = accountDao.getAccountById(source);
		
		return "допиши статусы для дао";
	}

	@Override
	public Integer convertFrom(String source, Integer destination) {
		throw new UnsupportedOperationException();
	}

}
