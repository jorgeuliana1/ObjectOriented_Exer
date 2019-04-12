import java.util.Scanner;
import java.util.ArrayList;

public class J2_05 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        String s1;
        s1 = in.nextLine();

        int n;
        n = Integer.parseInt(s1);

        ArrayList<Item> a = new ArrayList<Item>();
        
        for(int i = 0; i < n; i++) {
            
            String s = in.nextLine();
            String[] s2 = s.split(",");

            
            a.add(new Item(Integer.parseInt(s2[1]), s2[2], Double.parseDouble(s2[3])));
            
        }

        String s = in.nextLine();
        String[] s2 = s.split(",");

        int r = searchIndex(a, Integer.parseInt(s2[1]));
        if(r == -1)
            System.out.println("Produto nao encontrado.");
        else
            System.out.println(Integer.toString(r));


    }

    static int searchIndex(ArrayList<Item> i, int i2) {

        for(int j = 0; j < i.size(); j++) {

            if(i.get(j).equals(i2))
                return j;
                
        }

        return -1;

    }
}
