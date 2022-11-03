package animal;

public class AnimalFactory {//chon doi tuong khoi tao tu LOP CON
    public Animal getAnimal(String type) {
        if ("canine".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
