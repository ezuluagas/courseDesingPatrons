package streams.module3;

import lombok.Data;

@Data
public class City {
    private String name ;

    public City() {
    }

    public City(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" + "name=" + name + '}';
    }
}
