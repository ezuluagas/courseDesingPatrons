package creacionales.builder;

public class BuilderEjemplo {

    public static void main(String args[]){

        StringBuilder builder=new StringBuilder();

        builder.append("esto es un ejemplo ");
        builder.append("de como funciona ");
        builder.append("el builder ");
        builder.append(34);

        System.out.println(builder.toString());


    }
}
