import java.io.IOException;

public class J3_02 {

    public static void metodo01() throws ClassNotFoundException {
        Class.forName("ClasseQueNaoExiste");
    }

    public static void metodo02() throws IOException {
        java.io.File.createTempFile("pre", "suf");
    }

    public static void metodo03() throws InstantiationException, IllegalAccessException {
        Integer.class.newInstance();
    }

    public static void main(String[] args) {
        try {
            metodo01();
        } catch(ClassNotFoundException cnfe) {
            System.out.println(cnfe.getLocalizedMessage() + " nao existe!");
        }

        try {
            metodo02();
        } catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        try {
            metodo03();
        } catch(InstantiationException ie) {
            System.out.println("java.lang.InstantiationException: " + ie.getMessage());
        } catch(IllegalAccessException ie){
            System.out.println(ie.getMessage());
        }
    }

}