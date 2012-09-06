package v1;

import entities.CreditCardProcessor;
import entities.SquareCreditCardProcessor;

public class CreditCardProcessorFactory {
	  
	  private static CreditCardProcessor instance;
	  
	  public static void setInstance(CreditCardProcessor creditCardProcessor) {
	    instance = creditCardProcessor;
	  }

	  public static CreditCardProcessor getInstance() {
	    if (instance == null) {
	      return new SquareCreditCardProcessor();
	    }
	    
	    return instance;
	  }
	}
