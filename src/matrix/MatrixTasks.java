package matrix;

import java.util.Scanner;

public class MatrixTasks {
    static Scanner scanner = new Scanner(System.in);

    static int input() {
        System.out.println("Выберите задание: ");
        return scanner.nextInt();
    }

    public static void outputTasks() {
        System.out.println("1.Вывести матрицу");
        System.out.println("2.(#29)Найти транспанированную матрицу");
        System.out.println("3.Найти сумму главной диагонали");
        int point = input();
        switch (point) {
            case 0: {
                System.out.println("123");
                break;
            }
            case 1: {
                Matrix.showMatrixInteger(Matrix.matrix);
                outputTasks();
            }
            case 2: {
                System.out.println("Транспонированная матрица");
                Matrix.showMatrixInteger(Matrix.transMatrix(Matrix.matrix));
                outputTasks();
            }
            default: {
                outputTasks();
            }
        }
    }

    public static void main(String[] args) {
        outputTasks();
    }
}
