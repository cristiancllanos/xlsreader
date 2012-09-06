package entities;

public interface CreditCardProcessor {

	ChargeResult charge(CreditCard creditCard, Double amount) throws UnreachableException;

}
