package br.ufes.inf.prog3.jjmuliana.stats;

/**
 * @author J. Jorge M. Uliana
 * @version 1.0
 */

public enum StatsCommand {
    REDE("rede", 1);

    private final String value;
    private final int num;

    StatsCommand(String option_value, int number_value) {
        value = option_value;
        num = number_value;
    }

    public int getNumber() {
        return num;
    }

    public String getName() {
        return value;
    }

}
