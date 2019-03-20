    class Stock {
        private double initialValue;
        private double interestRate; //Given in months.

        public double CalculateCompound(int timeInMonths) {

            return initialValue * Math.pow(1 + interestRate, timeInMonths);
        }

        public Stock (double iV, double iR) {
            this.initialValue = iV;
            this.interestRate = iR;
        }
    }

    public class Compound {

        public static void main(String[] args) {
            
            //Simulation of SELIC, aproximated values.

            Stock s = new Stock(1000, 0.07);
            if(args.length > 0) {
                for(int i = 0; i < args.length; i++) {
                    if(Integer.parseInt(args[i]) < 10)
                        System.out.print("0");
                    System.out.println(args[i] + ": " + s.CalculateCompound(Integer.parseInt(args[i])));
                }
            }

            else
                System.out.println("Insert values.");
                
        }
    }