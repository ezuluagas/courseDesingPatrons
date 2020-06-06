package creacionales.abstractFactory;

public class VisaValidator implements Validator {

    @Override
    public boolean isValido(CreditCard creditCard) {
        return false;
    }
}
