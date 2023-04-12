package matrix;

import java.util.Scanner;

public class MatrixTasks {
    static Scanner scanner = new Scanner(System.in);

    static int input() {
        System.out.println("�������� �������: ");
        return scanner.nextInt();
    }

    public static void outputTasks() {
        System.out.println("1.������� �������");
        System.out.println("2.(#29)����� ����������������� �������");
        System.out.println("3.����� ����� ������� ���������");
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
                System.out.println("����������������� �������");
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
