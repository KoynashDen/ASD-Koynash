import Lab_10.Lab_10;
import Lab_2.Lab_2;
import Lab_3.Lab_3;
import Lab_4.Lab_4;
import Lab_5.Lab_5;
import Lab_6.Lab_6;
import Lab_7.Lab_7;
import Lab_8.Lab_8;
import Lab_9.Lab_9;

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
                case 3:
                    Lab_3.lab_3();
                    break;
                case 4:
                    Lab_4.lab_4();
                    break;
                case 5:
                    Lab_5.lab_5();
                    break;
                case 6:
                    Lab_6.lab_6();
                    break;
                case 7:
                    Lab_7.lab_7();
                    break;
                case 8:
                    Lab_8.lab_8();
                    break;
                case 9:
                    Lab_9.lab_9();
                    break;
                case 10:
                    Lab_10.lab_10();
                    break;
                default:
                    System.out.println("ERROR");
            }


    }


}
