package creacionales.factory;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Website {

    protected List<Page> pages=new ArrayList();

    public Website(){
        this.createWebsite();
    }

    public abstract void createWebsite();

}
