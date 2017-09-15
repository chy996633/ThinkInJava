package beanUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andrew on 2015/12/4.
 */
public class Employee {
    private String firstName;
    String lastName;
    Employee[] subordinate;
    Map<String, Address> address;

    public Employee(){
        firstName = "Andrew";
        lastName = "Chen";
        subordinate = new Employee[]{new Employee("Shirley","Liu"),new Employee("Alex","Wang")};
        address = new HashMap<>();
        address.put("home", new Address("Changsha YueLuShan"));
    }

    private Employee(String firstName,String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Address getAddress(String type) {
        return address.get(type);
    }

    public void setAddress(String type, Address address) {
        this.address.put(type, address);
    }

    public Employee getSubordinate(int index) {
        return subordinate[index];
    }

    public void setSubordinate(int index, Employee subordinate) {
        this.subordinate[index] = subordinate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setFirstName(Float fl){}

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
}

