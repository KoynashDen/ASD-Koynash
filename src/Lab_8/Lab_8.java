package Lab_8;

import java.util.*;

public class Lab_8 {

    public static void lab_8() {
        Scanner scanner = new Scanner(System.in);
        int[] A = {};
        int[] B = {};

        while (true) {
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1. Ввести масиви A і B з клавіатури");
            System.out.println("2. Показати масиви A і B");
            System.out.println("3. Знайти унікальні елементи, що є в обох масивах");
            System.out.println("4. Сортувати знайдені елементи");
            System.out.println("5. Виконати пошук у знайденому масиві");
            System.out.println("0. Вихід");
            System.out.print("Ваш вибір: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Введення масиву A:");
                    A = inputArray(scanner);
                    System.out.println("Введення масиву B:");
                    B = inputArray(scanner);
                }
                case 2 -> {
                    System.out.println("A: " + Arrays.toString(A));
                    System.out.println("B: " + Arrays.toString(B));
                }
                case 3 -> {
                    int[] common = findCommonUnique(A, B);
                    System.out.println("Унікальні елементи в обох: " + Arrays.toString(common));
                }
                case 4 -> {
                    int[] sorted = findCommonUnique(A, B);
                    Arrays.sort(sorted);
                    System.out.println("Відсортовані: " + Arrays.toString(sorted));
                }
                case 5 -> {
                    int[] data = findCommonUnique(A, B);
                    Arrays.sort(data);
                    System.out.print("Введіть елемент для пошуку: ");
                    int key = scanner.nextInt();
                    searchMenu(scanner, data, key);
                }
                case 0 -> {
                    System.out.println("Завершення...");
                    return;
                }
                default -> System.out.println("Невірний вибір!");
            }
        }
    }

    static int[] inputArray(Scanner scanner) {
        System.out.print("Введіть кількість елементів: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Введіть елементи:");
        for (int i = 0; i < n; i++) {
            System.out.print("[" + i + "] = ");
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    static int[] findCommonUnique(int[] A, int[] B) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> duplicatesA = new HashSet<>();
        for (int n : A) {
            if (!setA.add(n)) {
                duplicatesA.add(n);
            }
        }

        Set<Integer> setB = new HashSet<>();
        Set<Integer> duplicatesB = new HashSet<>();
        for (int n : B) {
            if (!setB.add(n)) {
                duplicatesB.add(n);
            }
        }

        Set<Integer> result = new HashSet<>();
        for (int n : A) {
            if (setB.contains(n) && !duplicatesA.contains(n) && !duplicatesB.contains(n)) {
                result.add(n);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static void searchMenu(Scanner scanner, int[] arr, int key) {
        System.out.println("\n-- Алгоритми пошуку --");
        System.out.println("1. Лінійний пошук");
        System.out.println("2. Лінійний пошук з бар’єром");
        System.out.println("3. Бінарний пошук");
        System.out.println("4. Пошук Фібоначчі");
        System.out.println("5. Пошук з перестановкою в початок");
        System.out.println("6. Пошук з транспозицією");
        System.out.print("Ваш вибір: ");
        int type = scanner.nextInt();

        int index = -1;
        switch (type) {
            case 1 -> index = linearSearch(arr, key);
            case 2 -> index = linearSearchWithBarrier(arr, key);
            case 3 -> index = binarySearch(arr, key);
            case 4 -> index = fibonacciSearch(arr, key);
            case 5 -> index = moveToFrontSearch(arr, key);
            case 6 -> index = transpositionSearch(arr, key);
            default -> System.out.println("Невірний вибір");
        }

        if (index != -1) {
            System.out.println("Елемент знайдено на позиції: " + index);
        } else {
            System.out.println("Елемент не знайдено.");
        }
    }


    static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key) return i;
        return -1;
    }

    static int linearSearchWithBarrier(int[] arr, int key) {
        int[] newArr = Arrays.copyOf(arr, arr.length + 1);
        newArr[arr.length] = key;
        int i = 0;
        while (newArr[i] != key) i++;
        return (i == arr.length) ? -1 : i;
    }

    static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == key) return mid;
            if (arr[mid] < key) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    static int fibonacciSearch(int[] arr, int key) {
        int n = arr.length;
        int fibMMm2 = 0, fibMMm1 = 1, fibM = fibMMm2 + fibMMm1;

        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }

        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibMMm2, n - 1);
            if (arr[i] < key) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            } else if (arr[i] > key) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            } else return i;
        }

        if (fibMMm1 == 1 && offset + 1 < n && arr[offset + 1] == key)
            return offset + 1;

        return -1;
    }

    static int moveToFrontSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (i > 0) {
                    int temp = arr[i];
                    arr[i] = arr[0];
                    arr[0] = temp;
                }
                return i;
            }
        }
        return -1;
    }

    static int transpositionSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                if (i > 0) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }
}

