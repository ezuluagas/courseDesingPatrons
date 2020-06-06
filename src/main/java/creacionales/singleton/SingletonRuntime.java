package creacionales.singleton;

public class SingletonRuntime {

    public static void main(String args[]){

        Runtime runtime=Runtime.getRuntime();
        runtime.gc();

        System.out.println(runtime);

        Runtime otraRuntime=Runtime.getRuntime();
        System.out.println(otraRuntime);

        if (runtime==otraRuntime){
            System.out.println("son el mismo espacio en memoria");

        }

    }
}
