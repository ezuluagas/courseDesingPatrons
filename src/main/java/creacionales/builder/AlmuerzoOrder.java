package creacionales.builder;

import lombok.Data;

@Data
public class AlmuerzoOrder {

    public static class Builder{
        private  String arepa;
        private  String condimentos;
        private  String carne;
        private  String aguacate;


        public Builder(){

        }

        public AlmuerzoOrder build(){
            return new AlmuerzoOrder(this);
        }

        public Builder arepa(String arepa){
            this.arepa=arepa;
            return this;
        }

        public Builder condimentos(String condimentos){
            this.condimentos=condimentos;
            return this;
        }

        public Builder carne(String carne){
            this.carne=carne;
            return this;
        }

        public Builder aguacate(String aguacate){
            this.aguacate=aguacate;
            return this;
        }

    }

    private final String arepa;
    private final String condimentos;
    private final String carne;
    private final String aguacate;

    private AlmuerzoOrder(Builder builder){
        this.arepa=builder.arepa;
        this.condimentos=builder.condimentos;
        this.carne=builder.carne;
        this.aguacate=builder.aguacate;
    }

}
