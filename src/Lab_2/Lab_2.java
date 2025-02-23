package Lab_2;

import GetValid.getValidArray;
import GetValid.getValidInt;
import Lab_2.Task_1.Task_1;
import Lab_2.Task_1.getValidIndex;
import Lab_2.Task_2.Task_2;
import Lab_2.Task_3.Task_3;
import Lab_2.Task_4.Task_4;

import java.util.Scanner;

public class Lab_2 {



    public static void lab_2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Виберіть номер завдання (1-4):");
        int task = scan.nextInt();

        switch (task) {
            case 1:
                Task_1.task1();
                break;
            case 2:
                Task_2.task2();
                break;
            case 3:
                Task_3.task3();
                break;
            case 4:
                Task_4.task4();
                break;
            default:
                System.out.println("Невірний номер(");
        }
    }


}
