public class Main {
    public static void main(String[] args) {
        // Создаем объекты классов Cat и Dog
        Cat catMurzik = new Cat("Мурзик");
        Dog dogBobik = new Dog("Бобик");

        // Демонстрация работы методов run и swim для кота
        catMurzik.run(150);   // Мурзик пробежал 150 м.
        catMurzik.run(250);   // Мурзик не может пробежать 250 м. (лимит 200 м.)
        catMurzik.swim(5);    // Мурзик не умеет плавать.

        // Демонстрация работы методов run и swim для собаки
        dogBobik.run(300);    // Бобик пробежал 300 м.
        dogBobik.run(600);    // Бобик не может пробежать 600 м. (лимит 500 м.)
        dogBobik.swim(5);     // Бобик проплыл 5 м.
        dogBobik.swim(15);    // Бобик не может проплыть 15 м. (лимит 10 м.)

        // Вывод статистики созданных животных
        System.out.println("\nСтатистика:");
        System.out.println("Всего животных: " + Animal.animalCount);
        System.out.println("Всего котов: " + Cat.catCount);
        System.out.println("Всего собак: " + Dog.dogCount);
    }
}

// Базовый класс Animal для всех животных
class Animal {
    static int animalCount = 0; // Счетчик созданных животных
    protected String name;
    protected int runLimit;
    protected int swimLimit;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        animalCount++;
    }

    // Метод для бега
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не может пробежать " + distance + " м. (лимит " + runLimit + " м.)");
        }
    }

    // Метод для плавания
    public void swim(int distance) {
        if (swimLimit == 0) {
            System.out.println(name + " не умеет плавать.");
        } else if (distance <= swimLimit) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не может проплыть " + distance + " м. (лимит " + swimLimit + " м.)");
        }
    }
}

// Класс Cat (Кот) наследуется от Animal
class Cat extends Animal {
    static int catCount = 0; // Счетчик созданных котов

    public Cat(String name) {
        // Кот может бегать до 200 м, но не умеет плавать (лимит 0 м)
        super(name, 200, 0);
        catCount++;
    }
}

// Класс Dog (Собака) наследуется от Animal
class Dog extends Animal {
    static int dogCount = 0; // Счетчик созданных собак

    public Dog(String name) {
        // Собака может бегать до 500 м и плавать до 10 м
        super(name, 500, 10);
        dogCount++;
    }
}
