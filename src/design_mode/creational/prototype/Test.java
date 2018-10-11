package design_mode.creational.prototype;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Character character = new Character();
        character.setLevel("35");
        character.setName("Killer");
        User user = new User();
        user.setName("Andrew");
        character.setUser(user);

        Character cloneCharacter = character.clone();
        Character copy = character.copy();
        copy.getUser().setName("Samuel");
        System.out.println(user.getName());
        cloneCharacter.getUser().setName("Samuel");
        System.out.println(user.getName());



    }

}
