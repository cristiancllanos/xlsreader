package v1;

import junit.framework.TestCase;
import entities.CreditCard;
import entities.PizzaOrder;
import entities.Receipt;

public class RealBillingServiceTest extends TestCase {

	  private final PizzaOrder order = new PizzaOrder(100);
	  private final CreditCard creditCard = new CreditCard("1234", 11, 2010);

	  private final InMemoryTransactionLog transactionLog = new InMemoryTransactionLog();
	  private final FakeCreditCardProcessor creditCardProcessor = new FakeCreditCardProcessor();

	  @Override public void setUp() {
	    TransactionLogFactory.setInstance(transactionLog);
	    CreditCardProcessorFactory.setInstance(creditCardProcessor);
	  }

	  @Override public void tearDown() {
	    TransactionLogFactory.setInstance(null);
	    CreditCardProcessorFactory.setInstance(null);
	  }

	  public void testSuccessfulCharge() {
	    RealBillingService billingService = new RealBillingService();
	    Receipt receipt = billingService.chargeOrder(order, creditCard);

	    assertTrue(receipt.hasSuccessfulCharge());
	    assertEquals(100, receipt.getAmountOfCharge());
	    assertEquals(creditCard, creditCardProcessor.getCardOfOnlyCharge());
	    assertEquals(100, creditCardProcessor.getAmountOfOnlyCharge());
	    assertTrue(transactionLog.wasSuccessLogged());
	  }
	}
