import java.util.Random;

public class Aleatorio {

    // Aleatorio means Random.

    // Macros
    private static final int VALOR_MAXIMO_DEFAULT = 100; /* Means "DEFAULT_MAXIMUM_VALUE" */

    // Number generator.
    private Random rand;

    // Generated numbers.
    private int[] nums = new int[10];
    private int currIndex = 0;

    Aleatorio(long max) {

        this.rand = new Random(max);

        for(int i = 0; i < 10; i++) {
            nums[i] = rand.nextInt(VALOR_MAXIMO_DEFAULT);
        }

    }

    Aleatorio() {
        this(VALOR_MAXIMO_DEFAULT);
    }

    public int getNum() {
        if(currIndex < 10) {
            currIndex++;
            return this.nums[currIndex - 1];
        }
        else
            return this.nums[9];
    }

}