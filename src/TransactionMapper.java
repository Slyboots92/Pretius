import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransactionMapper {

	private static final String NAME_PATTERN = "@name:";
	private static final String SURNAME_PATTERN = "@surname:";
	private static final String SRC_IBAN_PATTERN = "@src_iban:";
	private static final String DST_IBAN_PATTERN = "@dst_iban:";
	private static final String AMOUNT_PATTERN = "@amount:";

	public Transaction parseToTransaction(String line) {

		Transaction transaction = new Transaction();
		String name = cutFromStringToString(line, NAME_PATTERN, SURNAME_PATTERN);
		String surname = cutFromStringToString(line, SURNAME_PATTERN, SRC_IBAN_PATTERN);
		String src_iban = cutFromStringToString(line, SRC_IBAN_PATTERN, DST_IBAN_PATTERN);
		String dst_iban = cutFromStringToString(line, DST_IBAN_PATTERN, AMOUNT_PATTERN);

		Amount amount= parseAmount(line);
		transaction.setName(name);
		transaction.setSurname(surname);
		transaction.setSrc_iban(src_iban);
		transaction.setDst_iban(dst_iban);
		transaction.setAmount(amount);
		return transaction;
	}

	private Amount parseAmount(String line) {
		Amount amount=new  Amount();
		String amountStr = cutFromStringToENd(line, AMOUNT_PATTERN);
		String regEx = "([A-Z])";
		Pattern pattern = Pattern.compile(regEx);
		Matcher matcher = pattern.matcher(amountStr);
		matcher.find();
		int regExpIndex=matcher.start();
		String value=amountStr.substring(0,regExpIndex);
		String currency=amountStr.substring(regExpIndex,amountStr.length());
		amount.setCurrency(currency);
		value=value.replaceAll(",", ".");
		amount.setValue(new BigDecimal(value));
		amount.setCurrency(currency);
		return amount;
	}

	private String cutFromStringToString(String line, String begString, String endString) {
		int nameIndexBegin = line.indexOf(begString) + begString.length();
		int nameIndexEnd = line.indexOf(endString);
		String result = line.substring(nameIndexBegin, nameIndexEnd);
		return result;
	}

	private String cutFromStringToENd(String line, String begString) {
		int nameIndexBegin = line.indexOf(begString) + begString.length();
		String result = line.substring(nameIndexBegin, line.length());
		return result;
	}

}
