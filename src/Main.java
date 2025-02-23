import Lab_2.Lab_2;

import java.util.Scanner;
// 9 varik
public class Main {
    public static void main(String[] args) {
        System.out.print("Введіть номер лаболаторки: ");
        Scanner sc = new Scanner(System.in);
        int labNumber = sc.nextInt();




            switch (labNumber) {
                case 1:
                    Lab_1.lab_1();
                    break;
                case 2:
                    Lab_2.lab_2();
                    break;
                default:
                    System.out.println("ERROR");
            }


    }


}
