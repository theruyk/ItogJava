package ITOG_JAVA;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    private ArrayList<Toy> toysList = new ArrayList<>();

    public void addNewToy() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите id игрушки:");
        int newId = sc.nextInt();

        System.out.println("Введите название игрушки:");
        String newName = sc.next();

        System.out.println("Введите количество игрушек:");
        int newQuantity = sc.nextInt();

        System.out.println("Введите вес игрушки в процентах (от 0 до 100):");
        double newWeight = sc.nextDouble();

        Toy newToy = new Toy(newId, newName, newQuantity, newWeight);
        toysList.add(newToy);
        System.out.println("Игрушка успешно добавлена в массив: ");
        System.out.println(toysList);

    }

    public void changeToyWeight() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ID игрушки:");
        int toyId = sc.nextInt();

        System.out.println("Введите новый вес игрушки в процентах (от 0 до 100):");
        double newWeight = sc.nextDouble();

        for (Toy toy : toysList) {
            if (toy.id == toyId) {
                toy.weight = newWeight;
                System.out.println("Вес игрушки изменен: ");
                System.out.println(toysList);
                return;
            }
        }
        System.out.println("Игрушка с таким ID не существует");
    }

    public PrizeToy selectPrizeToy() {
        if (toysList.isEmpty()) {
            System.out.println("Список игрушек пуст");
            return null;
        }
        Random random = new Random();
        double r = random.nextDouble() * 100; 

        int randomIndex = random.nextInt(toysList.size()); 
        Toy selectedToy = toysList.get(randomIndex); 

        if (selectedToy.quantity > 0 && r < selectedToy.weight) {
            selectedToy.quantity--;
            PrizeToy prizeToy = new PrizeToy(selectedToy.id, selectedToy.name);
            savePrizeToyToFile(prizeToy, "prize_toys.txt"); 
            toysList.remove(selectedToy);
            return prizeToy;

        } else {
            System.out.println("Список игрушек пуст");
            return null;
        }

    }

    public void savePrizeToyToFile(PrizeToy prizeToy, String filename) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            writer.write(prizeToy.toString() + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("id: %d, name: %s, weight: %.2f, quantity: %d", id, name, weight, quantity);
    }
}