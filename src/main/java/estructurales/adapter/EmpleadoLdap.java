package estructurales.adapter;

import lombok.Data;

@Data
public class EmpleadoLdap {

    private String cn;
    private String surname;
    private String givesName;
    private String mail;

    public EmpleadoLdap(String cn, String surname, String givesName, String mail) {

        this.cn = cn;
        this.surname = surname;
        this.givesName = givesName;
        this.mail = mail;
    }
}
