package creacionales.prototype;

import java.util.ArrayList;
import java.util.List;

public class PrototypeDemo {

    public static void main(String args[]){
        String sql="select * from movies where titulo=?";
        List<String> parameters =new ArrayList<String>();
        parameters.add("toy story");
        Record record=new Record();

        Staments firstStament=new Staments(sql,parameters,record);

        System.out.println(firstStament.getSql());


        Staments second=firstStament.clone();

        System.out.println(second.getSql());

    }
}
