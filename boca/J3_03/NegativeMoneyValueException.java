import java.util.Locale;

public class NegativeMoneyValueException extends Exception {

    private float value;
    static final long serialVersionUID = 9996468411694918L;

    public NegativeMoneyValueException(float v) {
        value = v;
    }

    @Override
    public String getMessage() {
        return String.format(/*new Locale("pt", "BR"),*/ "Nao e' possivel depositar/sacar valor negativo: %.1f.", value);
    }

}