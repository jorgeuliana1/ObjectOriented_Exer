    /**
     * Stocks
     */
    public class Compound {

        //All the values are calculated in months

        private double initialValue = 1000;
        private double interestRate = 0.1;

        public double CalculateCompound(int timeInMonths) {

            return initialValue * Math.pow(1 + interestRate, timeInMonths);
        }
        public static void main(String[] args) {
            
            System.out.println(CalculateCompound(1));
        }
    }