package estructurales.composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeDemo {

    public static void main(String args[]){
        Map<String,String> personaAtributos=new HashMap();

        personaAtributos.put("site_role","persona");
        personaAtributos.put("access_role","limitado");

        Map<String,String> grupoAtributos=new HashMap();
        grupoAtributos.put("grupo_role","admin");

        Map<String,String> secAtributos =new HashMap();

        secAtributos.putAll(personaAtributos);
        secAtributos.putAll(grupoAtributos);

        System.out.println(secAtributos);

        /**
         * Main menu demo
         */

        Menu mainMenu= new Menu("Main","/main");

        MenuItems seguroMenuItem=new MenuItems("Seguro","/seguro");

        mainMenu.agregar(seguroMenuItem);

        Menu claimsSubMenu=new Menu("Claims","/claims");

        mainMenu.agregar(claimsSubMenu);

        MenuItems personalClaimsMenu=new MenuItems("Personal Claim","/personalClaims");

        claimsSubMenu.agregar(personalClaimsMenu);

        System.out.println(mainMenu.toString());

    }
}
