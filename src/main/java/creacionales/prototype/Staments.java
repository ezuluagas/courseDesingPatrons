package creacionales.prototype;


import lombok.Data;

import java.util.List;

@Data
public class Staments implements Cloneable {

    private String sql;
    private List<String> parametros;
    private Record record;

    public Staments(String sql, List<String> parametros, Record record){
        this.sql=sql;
        this.parametros=parametros;
        this.record=record;
    }

    public Staments clone(){
        try{
            return (Staments) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
