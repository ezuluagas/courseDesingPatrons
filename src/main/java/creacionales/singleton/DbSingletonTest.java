package creacionales.singleton;

public class DbSingletonTest {

    public static void main(String args[]){
        Dbsingleton instance=Dbsingleton.getInstance();

        System.out.println(instance);

        Dbsingleton otraInstancia=Dbsingleton.getInstance();

        System.out.println(otraInstancia);
    }
}
