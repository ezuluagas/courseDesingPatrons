package creacionales.abstractFactory;

public class AmexGoldValidator implements Validator {
    @Override
    public boolean isValido(CreditCard creditCard) {
        return false;
    }
}
