package creacionales.builder;

public class AlmuerzoDemo {

    public static void main(String args[]){

        /*AlmuerzoFrijoles almuerzoFrijoles=new AlmuerzoFrijoles();

        almuerzoFrijoles.setArepa("arepa");
        almuerzoFrijoles.setCarne("chicharro");
        almuerzoFrijoles.setCondimentos("trigizal");

        System.out.println(almuerzoFrijoles.getArepa());

         */

        AlmuerzoOrder.Builder builder=new AlmuerzoOrder.Builder();
        builder.arepa("Chiquita").condimentos("triguizal").carne("molida");
        AlmuerzoOrder order=builder.build();

        System.out.println(order.getArepa());
    }
}
