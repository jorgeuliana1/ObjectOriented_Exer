public class MathBasic {

    static int Sum(int ... num) /* Number of parameters of the function is variable */
    {
        int sum = new Integer(0);

        for(int i : num) /* for-each statement */
        /* for(int i : num)  is equivalent to for(int j = 0; j < num.length; j++) { int i = num[j] } */
        {
            sum += i;
        }

        return sum;
    }
    public static void main (String[] args) {

        int num = Sum(10, 20, 30, 50);
        System.out.println(num + " ");

        num = Sum(10, 30);
        System.out.println(num + " ");

    }
}