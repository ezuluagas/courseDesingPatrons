package creacionales.singleton;

public class Dbsingleton {

    //private static Dbsingleton instance=new Dbsingleton();    -> no es thread and safe

    private static volatile Dbsingleton instance=null;


    private Dbsingleton(){
        if (instance!=null){
            throw new RuntimeException("usar getinstance metodo para crear");
        }
    }



    public static Dbsingleton getInstance(){
        if (instance==null){
            synchronized (Dbsingleton.class){
                if (instance==null){
                    instance=new Dbsingleton();
                }
            }

        }
        return instance;
    }
}
