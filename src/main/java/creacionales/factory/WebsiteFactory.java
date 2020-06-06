package creacionales.factory;

public class WebsiteFactory {

    /**
     *  llama los constructores de blog o de todos las factory q se tenga
     *
     * @param siteType
     * @return
     */
    public static Website getWebsite(WebsiteType siteType ){

        switch (siteType){
            case BLOG:{
                return new Blog();
            }
            case SHOP:{
                return new Shop();
            }
            default:{
                return null;
            }
        }
    }
}
