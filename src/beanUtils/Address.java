package beanUtils;

/**
 * Created by Andrew on 2015/12/4.
 */
public class Address {
    private String city;

    public Address(String s) {
        this.city = s;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    @Override
    public String toString() {
        return city;
    }
}
