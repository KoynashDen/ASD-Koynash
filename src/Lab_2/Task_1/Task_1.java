package Lab_2.Task_1;

import GetValid.GetValidArray;
import GetValid.GetValidInt;

import java.util.Scanner;

public class Task_1 {
    public static void task1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть розмір масива N");
        int n = GetValidInt.getValidInt(scan);
        scan.nextLine();
        int[] array = new int[n];


        array = GetValidArray.getValidArray(scan, n);


        System.out.println("Введіть ПОЧАТКОВИЙ індекс для прорахонку добутку:");
        int dobIndex1 = getValidIndex.getValidIndex(scan, n);
        System.out.println("Введіть КІНЦЕВИЙ індекс для прорахонку добутку:");
        int dobIndex2 = getValidIndex.getValidIndex(scan, n);

        if (dobIndex1 > dobIndex2) {
            System.out.println("ПОМИЛКА: Початковий індекс не може бути більше кінцевого! Міняємо місцями...");
            int temp = dobIndex1;
            dobIndex1 = dobIndex2;
            dobIndex2 = temp;
        }

        int sum = 0;
        int dob = 1;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0 || i == 0) {
                sum += Math.abs(array[i]);
            }
            if(i>dobIndex1 && i<dobIndex2){
                dob *= array[i];
            }
        }


        System.out.println("Сума модулів елементів з парними індексами:"+sum);
        System.out.println("Добуток елементів по модулю між заданими індексами:" + Math.abs(dob));

    }
}
