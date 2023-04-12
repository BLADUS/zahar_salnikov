package array;

import java.util.Scanner;

 class Array {
    static Scanner scanner = new Scanner(System.in);
    private static int[] array = initArrayIntegerHands();


    static int intput(String text) {
        System.out.println(text);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int[] initArrayIntegerAuto() {
        int[] array = createArrayInteger();
        for (int i = 0; i < array.length; i++) {
            array[i] = randomInteger(-10, 10);
        }
        return array;
    }

    public static int[] initArrayIntegerHands() {
        int[] array = createArrayInteger();
        System.out.print("Вводите значения: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static int[] createArrayInteger() {
        int sizeArray = intput("Введите размерность массива");
        return new int[sizeArray];
    }

    public static int randomInteger(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static void showArrayInteger(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ",");
        }
        System.out.print("]");
        System.out.println();
    }

    //task26
    public static int[] sortArrayAscend(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int buf = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    isSorted = false;
                }
            }
        }
        return array;
    }

    //task26*
    public static int[] sortArrayDescend(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = array.length - 1; i > 0; i--) {
                if (array[i] > array[i - 1]) {
                    int buf = array[i - 1];
                    array[i] = array[i - 1];
                    array[i - 1] = buf;
                    isSorted = false;
                }
            }
        }
        return array;
    }

    public static void searchMaxElementAndIndex(int[] array) {
        int[] array1 = sortArrayAscend(array);
        showArrayInteger(array1);
        System.out.println("Максимальный элемент: " + array1[array1.length - 1] + " Его индекс: " + ((array1.length) - 1));
    }

    public static void counterNumberInArray(int[] array) {
        int counter = 0;
        int index = 0;
        int number = intput("Введите число которое хотите найти: ");
        int[] array1 = sortArrayAscend(array);
        showArrayInteger(array1);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] == number) {
                counter += 1;
                index = i;
            }
        }
        System.out.println("Кол-во вхождений элемента " + number + ":" + counter);
        System.out.println("Индекс последнего вхождения: " + index);
    }

    public static int indexMinChainInArray(int[] array) {
        sortArrayAscend(array);
        showArrayInteger(array);
        int minCount = array.length;
        int count = 1;
        int indexMinCount = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (i + 2 == array.length && count < minCount) {
                minCount = count;
                indexMinCount = i - (count - 1);
            } else if (array[i] != array[i + 1] && count > 1) {
                if (count < minCount) {
                    minCount = count;
                    indexMinCount = i - (count - 1);
                    count = 1;
                }
            } else if (array[i] == array[i + 1]) {
                count++;
            }
        }
        return indexMinCount;
    }

    public static int indexMaxChainInArray(int[] array) {
        sortArrayAscend(array);
        showArrayInteger(array);
        int count = 1;
        int countMax = 2;
        int indexMaxCount = -1;
        for (int i = 0; i < array.length - 1; i++) {
            if (i + 2 == array.length && array[i] == array[i + 1]) {
                if (count > countMax) {
                    countMax = count;
                    indexMaxCount = (i + 1) - (count - 1);
                }
            } else if (array[i] != array[i + 1] && count > 1) {
                if (countMax < count) {
                    countMax = count;
                    indexMaxCount = i - (count - 1);
                    count = 1;
                }
            } else if (array[i] == array[i + 1]) {
                count++;
            }
        }
        return indexMaxCount;
    }

    public static int secondDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][(matrix.length - 1) - i];
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
