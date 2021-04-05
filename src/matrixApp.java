import java.util.Random;
import java.util.Scanner;


public class matrixApp {

    public static int[][] populateMatrix(int[][] matrix, boolean manual) {
        int limit = 2;
        if (!manual) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    Random random = new Random();
                    int number = random.nextInt(limit);
                    matrix[i][j] = number;
                }
            }
        } else {
            int value;
            Scanner userInput = new Scanner(System.in);
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.println("Elem["+ i +"][" + j +"]: ");
                    value = userInput.nextInt();
                    if (value > 1) {
                        System.out.println("Invalid value, try again");
                        j--;
                    } else {
                        matrix[i][j] = value;
                    }
                }
            }
            userInput.close();
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Entry:");
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

    public static int calculateMaxArea(int[] row) {
        int maxArea = 0;
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
    
    public static int findRectMaxArea(int[][] matrix) {
        int maxArea = 0;
        
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
        return maxArea;
    }

    private static int[][] defineMatrix() throws Exception {
        Scanner userInput = new Scanner(System.in);
        int option;
        int rows;
        int columns;
        boolean manual = false;
        
        System.out.println("Choose one option:");
        System.out.println("1 - Entry just with quantity of rows and columns");
        System.out.println("2 - Entry with each value (row, columns and elements");
        option = userInput.nextInt();
        
        if (option > 2) {
            userInput.close();
            throw new Exception("This value is not a option");
        }

        System.out.println("Enter a number of rows: ");
        rows = userInput.nextInt();
        System.out.println("Enter a number of columns: ");
        columns = userInput.nextInt();

        if (rows == 0 || columns == 0) {
            userInput.close();
            throw new Exception("Invalid values - zero");
        }

        int matrix[][] = new int[rows][columns];

        if (option == 1) {    
            manual = false;
        } else if (option == 2) {
            manual = true;
        } else {
            userInput.close();
            throw new Exception("This value is not a option");
        }
        
        matrix = populateMatrix(matrix, manual);
        printMatrix(matrix);
        
        userInput.close();
        return matrix;
    }

    public static void main(String[] args) throws Exception {
        int matrix[][] = defineMatrix();
        int maxArea = 0;
        maxArea = findRectMaxArea(matrix);
        System.out.println("MaxArea: " + maxArea);
    }
}
