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

    private static int calculateMaxArea(int[] row) {
        int maxArea = 0;
        int maxElem = 0;
        int area = 0;
        int height = 0;
        int width = 1;
        
        for (int i = 0; i < row.length; i++) {
            if (row[i] != 0) {
                if ((i+1) < row.length) {
                    height = row[i];
                    area = height * width;
                    maxArea = Math.max(maxArea, area);
                    for (int j = i + 1; j < row.length; j++) {
                        if (row[j] != 0) {
                            height = Math.min(height, row[j]);
                            width += 1;
                            if (((j+1) < row.length) && (row[j+1] < row[j])) {
                                area = height * width;
                                maxArea = Math.max(maxArea, area);
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    height = row[i];
                    width = 1;
                }
            }
            area = height * width;
            maxArea = Math.max(maxArea, area);
            width = 1;
        }

        return maxArea;
    }
    
    private static void findRectArea(int[][] matrix) {
        int area = 0;
        int horizontal = 0;
        int horizontalLast = 0;
        int horizontalAux = 0;
        int vertical = 1;
        int maxArea = 0;
        int[][] matrixA = {{1, 1, 1, 1, 1},
                          {0, 1, 1, 1, 0},
                          {1, 1, 1, 1, 1},
                          {0, 0, 0, 0, 0},
                          {0, 0, 1, 0, 1},
                         };



        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i != 0) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] += matrix[i-1][j];
                    }
                }
            }   
            maxArea = Math.max(maxArea, calculateMaxArea(matrix[i]));
        }
        System.out.println("result: ");
        printMatrix(matrix);
        System.out.println("MaxArea: " + maxArea);
    }

    public static void main(String[] args) throws Exception {
        int matrix[][] = createMatrix();
        matrix = populateMatrix(matrix);
        printMatrix(matrix);
        findRectArea(matrix);
    }
}
