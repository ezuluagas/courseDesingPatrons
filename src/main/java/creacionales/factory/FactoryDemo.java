package creacionales.factory;

import java.util.Calendar;

public class FactoryDemo {

    public static void main(String args[]){

        Calendar cal = Calendar.getInstance();

        //Calendar cal = Calendar.get;

        System.out.println(cal);

        System.out.println(cal.get(Calendar.DAY_OF_MONTH));

        /**
         * a partir de aca es el factory de pages
         */

        Website site=WebsiteFactory.getWebsite(WebsiteType.BLOG);
        System.out.println(site.getPages());

        site= WebsiteFactory.getWebsite(WebsiteType.SHOP);
        System.out.println("site son= "+site.getPages());
    }
}
