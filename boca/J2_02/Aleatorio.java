import java.util.Random;

public class Aleatorio {

    // Aleatorio means Random.

    private Random rand;
    private static int VALOR_MAXIMO_DEFAULT = 100; /* Means "DEFAULT_MAXIMUM_VALUE" */
    private int num;
    private int max;

    Aleatorio(long max) {
        this.rand = new Random(max);
        Long l = new Long(max);
        this.max = l.intValue();
        if(l > VALOR_MAXIMO_DEFAULT)
            this.max = VALOR_MAXIMO_DEFAULT;
    }

    Aleatorio() {
        this(VALOR_MAXIMO_DEFAULT);
    }

    public void renovar() {
        this.num = this.rand.nextInt(this.max);
    }

    public int getNum() {
        this.renovar();
        return this.num;
    }

}