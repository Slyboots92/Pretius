import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		FileRead fileRead = new FileRead();
		TransactionMapper transactionMapper = new TransactionMapper();
		System.out.println(args[0]);
		ArrayList<String> loadedLines = fileRead.loadFile(args[0]);
		for (String line : loadedLines) {
			transactionList.add(transactionMapper.parseToTransaction(line));
		}
		BigDecimal sum= new BigDecimal("0");
		for (Transaction transaction : transactionList) {
			sum = sum.add(transaction.getAmount().getValue());
			
		}
		System.out.println(sum.toString());
	}

}
