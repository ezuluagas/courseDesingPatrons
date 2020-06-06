package creacionales.abstractFactory;

public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int credito){
        if(credito>650){
            return new AmexFactory();
        }
        else {
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);

    public abstract  Validator getValidator(CardType cardType);


}
