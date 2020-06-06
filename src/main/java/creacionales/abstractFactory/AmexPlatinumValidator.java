package creacionales.abstractFactory;

public class AmexPlatinumValidator implements Validator {

    @Override
    public boolean isValido(CreditCard creditCard) {
        return true;
    }
}
