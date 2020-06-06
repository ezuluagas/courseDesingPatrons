package creacionales.abstractFactory;

public class AmexFactory extends CreditCardFactory {

    public CreditCard getCreditCard(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new AmexGoldCreditCard();
            case PLATIUM:
                return new AmexPlatinumCreditCard();
            default:
                break;
        }
        return null;
    }

    @Override
    public Validator getValidator(CardType cardType) {
        switch (cardType){
            case GOLD:
                return new AmexGoldValidator();
            case PLATIUM:
                return new AmexPlatinumValidator();
            default:
                break;
        }
        return null;
    }
}
