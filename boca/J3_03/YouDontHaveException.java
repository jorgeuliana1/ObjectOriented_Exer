import java.util.Locale;

public class YouDontHaveException extends Exception {

    private float have;
    private float want;
    static final long serialVersionUID = 9996468411694919L;

    public YouDontHaveException(float h, float w) {
        have = h;
        want = w;
    }

    @Override
    public String getMessage() {
        return String.format(new Locale("pt", "BR"), "Voce deseja sacar R$ %.2f, porem seu saldo e' de apenas R$ %.2f.", want, have);
    }

}