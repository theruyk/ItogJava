package ITOG_JAVA;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PrizeToy {
    private int id;
    private String name;

    public PrizeToy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void saveToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true));
            writer.write(String.format("%d,%s%n", id, name));
            writer.close();
            System.out.println("Игрушка сохранена в текстовый документ");
        } catch (IOException e) {
            System.out.println("Ошибка");
            e.printStackTrace();
        }
    }
    public String toString() {
        return String.format("id: %d, name: %s", id, name);
    }
}


