package v1;

import entities.BillingService;
import entities.ChargeResult;
import entities.CreditCard;
import entities.CreditCardProcessor;
import entities.DatabaseTransactionLog;
import entities.PaypalCreditCardProcessor;
import entities.PizzaOrder;
import entities.Receipt;
import entities.TransactionLog;
import entities.UnreachableException;

public class RealBillingService implements BillingService {
	  public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
	    CreditCardProcessor processor = new PaypalCreditCardProcessor();
	    TransactionLog transactionLog = new DatabaseTransactionLog();

	    try {
	      ChargeResult result = processor.charge(creditCard, order.getAmount());
	      transactionLog.logChargeResult(result);

	      return result.wasSuccessful()
	          ? Receipt.forSuccessfulCharge(order.getAmount())
	          : Receipt.forDeclinedCharge(result.getDeclineMessage());
	     } catch (UnreachableException e) {
	      transactionLog.logConnectException(e);
	      return Receipt.forSystemFailure(e.getMessage());
	    }

	  }
	}
