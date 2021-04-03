import java.util.Random;
import java.util.Scanner;

public class matrixApp {

    private static int generateRandomNumber(int limit) {
        Random random = new Random();
        int number = random.nextInt(limit);
        return number;
    }

    private static int[][] createMatrix() {
        Scanner userInput = new Scanner(System.in);
        int rows;
        int columns;
        System.out.println("Matrix with random rows and columns? ");
        System.out.println("0 - False");
        System.out.println("1 - True");
        int isRandom = userInput.nextInt();

        if (isRandom == 1) {
            int limit = 10;
            do {
                rows = generateRandomNumber(limit) + 1;
                if (rows == 1){
                    rows += 1;
                }
                columns = generateRandomNumber(limit) + 1;
            } while (columns < rows);
            
        } else {
            System.out.println("Enter a number of rows: ");
            rows = userInput.nextInt();
            System.out.println("Enter a number of columns: ");
            columns = userInput.nextInt();
            
        }
        System.out.println("Matrix: " + rows + "x" + columns);
        userInput.close();

        int[][] matrix = new int[rows][columns];
        return matrix;
    }

    private static int[][] populateMatrix(int[][] matrix) {
        int limit = 2;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = generateRandomNumber(limit);
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (j == 0) {
                    System.out.print("[");
                }
                System.out.print("'" + matrix[i][j] + "'");
            }
            System.out.println("],");
        }
    }
    public static void main(String[] args) throws Exception {
        int matrix[][] = createMatrix();
        matrix = populateMatrix(matrix);
        printMatrix(matrix);
    }
}
