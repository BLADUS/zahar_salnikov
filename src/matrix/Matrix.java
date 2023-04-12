package matrix;

import java.util.*;

public class Matrix {
    static Scanner scanner = new Scanner(System.in);
    public static int[][] matrix = initMatrixInteger();

    public static int input(String text) {
        System.out.println(text);
        return scanner.nextInt();
    }

    public static int[][] createdMatrixInteger() {
        int sizeMatrix = input("Введите размер матрицы: ");
        int[][] matrix = new int[sizeMatrix][sizeMatrix];
        return matrix;
    }

    public static int[][] initMatrixInteger() {
        int[][] matrix = createdMatrixInteger();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = randomInteger(0, 10);
            }
        }
        return matrix;
    }

    public static int randomInteger(int min, int max) {
        return (int) (Math.random() * (max - min)) + min;
    }

    public static void showMatrixInteger(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] transMatrix(int[][] matrix) {
        int size = matrix.length;
        int[][] transMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                transMatrix[i][j] = matrix[j][i];
            }
        }
        return transMatrix;
    }

    public static int secondDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][(matrix.length - 1) - i];
        }
        return sum;
    }

    public static double sumElementMatrixAboveDiagonals(int[][] matrix) {
        int matrixSize = matrix.length;
        double sum1 = 0;
        double sum2 = 0;
        int count = 0;
        for (int j = matrixSize - 1; j >= matrixSize / 2; j--) {
            for (int i = j - 1; i >= 0; i--) {
                sum1 += matrix[i][j];
                count++;
                if (j != matrixSize / 2 || matrixSize % 2 == 0) {
                    sum2 += matrix[i][(matrixSize - 1) - j];
                    count++;
                }
            }
        }
        return (double) ((sum1 + sum2) / count);
    }

    public static double sumElementsMatrixBottomAndAdjacentDiagonals(int[][] matrix) {
        int[][] flipMatrix = flipMatrix(matrix);
        showMatrixInteger(flipMatrix);
        return sumElementsMatrixAboveAndAdjacentDiagonals(flipMatrix);
    }

    public static double sumElementsMatrixAboveAndAdjacentDiagonals(int[][] matrix) {
        int matrixSize = matrix.length;
        ArrayList<Integer> elementsAboveDiagonals = new ArrayList<>();
        ArrayList<Integer> elementsAdjacentMainDiagonal = new ArrayList<>();
        ArrayList<Integer> elementsAdjacentSecondDiagonal = new ArrayList<>();

        //Забивание элементов над диагоналями в лист
        for (int j = matrixSize - 1; j >= matrixSize / 2; j--) {
            for (int i = j - 1; i >= 0; i--) {
                elementsAboveDiagonals.add(matrix[i][j]);
                if (j != matrixSize / 2 || matrixSize % 2 == 0) {
                    elementsAboveDiagonals.add(matrix[i][(matrixSize - 1) - j]);
                }
            }
        }

        if (matrixSize % 2 == 0) {
            //Прилегающие к главной д
            for (int i = matrixSize - 1; i >= matrixSize / 2; i--) {
                elementsAdjacentMainDiagonal.add(matrix[i][i - 1]);
            }

            //Прилегающие к побочной д
            for (int i = 0; i < matrixSize / 2; i++) {
                elementsAdjacentSecondDiagonal.add(matrix[(matrixSize - 1) - i][i + 1]);
            }
        } else {
            //Прилегающие к главной д
            for (int i = matrixSize - 1; i > matrixSize / 2; i--) {
                elementsAdjacentMainDiagonal.add(matrix[i][i - 1]);
            }

            //Прилегающие к побочной д
            for (int i = 0; i < (matrixSize / 2) - 1; i++) {
                elementsAdjacentSecondDiagonal.add(matrix[(matrixSize - 1) - i][i + 1]);
            }
        }
        System.out.print("Элементы над диагоналями: ");
        showList(elementsAboveDiagonals);
        System.out.print("\nЭлементы прилегающие к главной д: ");
        showList(elementsAdjacentMainDiagonal);
        System.out.print("\nЭлементы прилегающие к побочной д: ");
        showList(elementsAdjacentSecondDiagonal);

        double sum = sumElementsList(elementsAboveDiagonals) +
                sumElementsList(elementsAdjacentMainDiagonal) +
                sumElementsList(elementsAdjacentSecondDiagonal);

        return sum / (elementsAboveDiagonals.size()
                + elementsAdjacentSecondDiagonal.size()
                + elementsAdjacentMainDiagonal.size());
    }

    public static int[][] flipMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int[] topLine = new int[matrix.length];
            int[] bottomLine = new int[matrix.length];
            for (int j = 0; j < matrix.length; j++) {
                topLine[j] = matrix[i][j];
                bottomLine[j] = matrix[(matrix.length - 1) - i][j];
            }
            matrix[i] = bottomLine;
            matrix[(matrix.length - 1) - i] = topLine;
        }
        return matrix;
    }

    public static double sumElementsList(ArrayList<Integer> list) {
        int sumElementsList = 0;
        for (int i = 0; i < list.size(); i++) {
            sumElementsList += list.get(i);
        }
        return sumElementsList;
    }

    public static void showList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
