package store;

public class MainStore {
    public static void main(String[] args) {
        Box<Apple> apple_box = new Box<Apple>();
        for (int i = 0; i < 10; i++) {
            apple_box.addFruit(new Apple());
        }
        //apple_box.addFruit(new Orange()); Попытка положить апельсины в яблоки показывает ошибку и яблоки в апельсины
        System.out.println("Вес первой коробки с яблоками");
        System.out.println(apple_box.getWeight());
        Box<Apple> apple_box2 = new Box<Apple>();
        for (int i = 0; i < 5; i++) {
            apple_box2.addFruit(new Apple());
        }
        System.out.println("Вес второй коробки с яблоками");
        System.out.println(apple_box2.getWeight());

        Box<Orange> orange_box = new Box<Orange>();
        for (int i = 0; i < 10; i++) {
            orange_box.addFruit(new Orange());
        }
        System.out.println("Вес коробки с апельсинами");
        System.out.println(orange_box.getWeight());

        System.out.println("Вес первой коробки с яблоками равен весу второй коробки с яблоками?");
        System.out.println(apple_box.Compare(apple_box2));

        System.out.println("Вес коробки с апельсинами равен весу первой коробки с яблоками?");
        System.out.println(orange_box.Compare(apple_box));

        System.out.println("Пересыпали яблоки");
        apple_box2.toBox(apple_box);

        System.out.println("Вес первой коробки с яблоками");
        System.out.println(apple_box.getWeight());

        System.out.println("Вес второй коробки с яблоками");
        System.out.println(apple_box2.getWeight());

        System.out.println("Вес коробки с апельсинами равен весу первой коробки с яблоками?");
        System.out.println(orange_box.Compare(apple_box));

    }
}
