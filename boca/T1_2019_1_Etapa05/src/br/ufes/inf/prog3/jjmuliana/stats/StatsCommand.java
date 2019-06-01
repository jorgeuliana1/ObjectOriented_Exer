package br.ufes.inf.prog3.jjmuliana.stats;

/**
 * @author J. Jorge M. Uliana
 * @version 1.2
 */

public enum StatsCommand {
    REDE("rede", 1), PPG("ppg", 2), IES("ppg", 3),
    CSV("csv", 4);

    private final String value;
    private final int num;
    private boolean hasSub = false;
    private String subcommand;
    private String subcommand2;

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

    public void setSubCommand(String ... s) {
        subcommand  = s[0];
        if(s.length > 1)
            subcommand2 = s[1];
        hasSub = true;
    }

    public String getSubCommand(int index) {
        if(index == 0 && hasSub)
            return subcommand;
        else if(index == 1 && hasSub && subcommand2 != null)
            return subcommand2;
        else return null;
    }

    public String getSubCommand() {
        return getSubCommand(0);
    }

}
