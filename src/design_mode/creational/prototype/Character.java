package design_mode.creational.prototype;

public class Character implements Cloneable{

    String name;
    String level;
    User user;

    @Override
    protected Character clone() throws CloneNotSupportedException {
        return (Character)super.clone();
    }

    public Character copy() throws CloneNotSupportedException {
        Character copy =  (Character) super.clone();
        copy.user = (User)user.clone();
        return copy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "name:"+ name+" level:"+level+" user:"+user;
    }
}
