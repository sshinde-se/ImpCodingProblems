package SystemDesign.factoryMethod;

import java.util.ArrayList;

enum Burgers {
    CHEESE,
    DELUXECHEESE,
    VEGAN,
    DELUXEVEGAN,
}

abstract class BurgerStore {

    abstract Burger createBurger(Burgers item);

    public Burger orderBurger(Burgers type) {
        Burger burger = createBurger(type);
        System.out.println("--- Making a " + burger.getName() + " ---");
        burger.prepare();
        burger.cook();
        burger.serve();
        return burger;
    }
}

class CheeseBurgerStore extends BurgerStore {

    Burger createBurger(Burgers item) {
        if (item.equals(Burgers.CHEESE)) {
            return new CheeseBurger();
        } else if (item.equals(Burgers.DELUXECHEESE)) {
            return new DeluxeCheeseBurger();
        } else return null;
    }
}

class VeganBurgerStore extends BurgerStore {

    @Override
    Burger createBurger(Burgers item) {
        if (item.equals(Burgers.VEGAN)) {
            return new VeganBurger();
        } else if (item.equals(Burgers.DELUXEVEGAN)) {
            return new DeluxeVeganBurger();
        } else return null;
    }
}

abstract class Burger {

    String name;
    String bread;
    String sauce;
    ArrayList<String> toppings = new ArrayList<String>();

    void prepare() {
        // ...
    }

    void cook() {
        //...
    }

    void serve() {
        // ...
    }

    public String getName() {
        return name;
    }
}

class CheeseBurger extends Burger {

    public CheeseBurger() {
        name = "Cheese Burger";
        // ... set the name, bread and sauce
    }
}

class DeluxeCheeseBurger extends Burger {

    public DeluxeCheeseBurger() {
        name = "Deluxe Cheese Burger";
        // ... set the name, bread and sauce
    }
}

class VeganBurger extends Burger {

    public VeganBurger() {
        name = "Vegan Burger";
        // ... set the name, bread and sauce
    }
}

class DeluxeVeganBurger extends Burger {

    public DeluxeVeganBurger() {
        name = "Deluxe Vegan Burger";
        // ... set the name, bread and sauce
    }
}

class BurgerDriveThrough {

    public static void main(String[] args) {
        BurgerStore cheeseStore = new CheeseBurgerStore();
        BurgerStore veganStore = new VeganBurgerStore();

        Burger burger = cheeseStore.orderBurger(Burgers.CHEESE);
        System.out.println("Ethan ordered a " + burger.getName() + "\n");

        burger = veganStore.orderBurger(Burgers.DELUXEVEGAN);
        System.out.println("Joel ordered a " + burger.getName() + "\n");
    }
}

