package ITOG_JAVA;

import java.util.ArrayList;
import java.util.Scanner;

public class Interfeis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Toy toy = new Toy(0, null, 0, 0);
        ArrayList<PrizeToy> prizeToys = new ArrayList<>();

        boolean flag = false;
        while (!flag) {
            System.out.println("Выберите команду:");
            System.out.println("1 - Добавить игрушку");
            System.out.println("2 - Изменить вес игрушки");
            System.out.println("3 - Выбрать призовую игрушку");
            System.out.println("4 - Выход из программы");
            int num = sc.nextInt();

            switch (num) {
                case 1:
                    toy.addNewToy();
                    break;

                case 2:
                    toy.changeToyWeight();
                    break;

                case 3:
                    while (true) {
                        System.out.println("Хотите выбрать призовую игрушку? (да/нет)");
                        String answer = sc.next();
                        if (answer.equals("нет")) {
                            break;
                        }
                        PrizeToy prizeToy = toy.selectPrizeToy();
                        if (prizeToy != null) {
                            prizeToys.add(prizeToy);
                        }
                    }
                    break;

                case 4:
                    flag = true;
                    break;

                default:
                    System.out.println("Такой команды не существует");
                    break;
            }
        }

        System.out.println("Выход из программы");

        for (PrizeToy prizeToy : prizeToys) {
            prizeToy.saveToFile();
        }
    }
}
