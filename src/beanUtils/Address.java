package beanUtils;

/**
 * Created by Andrew on 2015/12/4.
 */
public class Address {
    private String city;
    Integer areaCode;
    private boolean rented;

    public Address(String s) {
        this.city = s;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public Boolean getRented() {
        return rented;
    }

    public void setRented(Boolean rented) {
        this.rented = rented;
    }

    @Override
    public String toString() {
        return "city:"+city+" areaCode:"+areaCode+" rented:"+ rented;
    }
}
