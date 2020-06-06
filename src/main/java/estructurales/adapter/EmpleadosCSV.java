package estructurales.adapter;

import lombok.Data;

import java.util.StringTokenizer;

@Data
public class EmpleadosCSV {

    private int id;
    private String nombre;
    private String apellido;
    private String correoElectronico;

    public EmpleadosCSV(String valor){
        StringTokenizer tokenizer=new StringTokenizer(valor, ",");
        if(tokenizer.hasMoreElements()){
            id=Integer.parseInt(tokenizer.nextToken());
        }
        if(tokenizer.hasMoreElements()){
            nombre=tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()){
            apellido=tokenizer.nextToken();
        }
        if(tokenizer.hasMoreElements()){
            correoElectronico=tokenizer.nextToken();
        }
    }
}
