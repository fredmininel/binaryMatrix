import junit.framework.*;
import org.junit.Test;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class matrixAppTests extends TestCase{
    
    @Test 
    public void testCalculateMaxArea() {
        int[] row = {1, 3, 3, 3, 1};
        int maxArea = matrixApp.calculateMaxArea(row);
        assertEquals(9, maxArea);
    }

    @Test
    public void testFindRectMaxArea() {
        int[][] matrix = { {1, 0, 1, 0, 0},
                           {1, 0, 1, 1, 1},
                           {1, 1, 1, 1, 1},
                           {1, 0, 0, 1, 0},
                         };
        int maxArea = matrixApp.findRectMaxArea(matrix);
        assertEquals(6, maxArea);
        assertNotEquals(3, maxArea);
        assertNotEquals(4, maxArea);
        assertNotEquals(5, maxArea);        
    }

    @Test 
    public void testPopulateMatrix(){
        int matrix[][] = new int[3][3];
        matrix = matrixApp.populateMatrix(matrix, false);
        int row1 = matrix[0][0] + matrix[0][1] + matrix[0][2];
        int row2 = matrix[1][0] + matrix[1][1] + matrix[1][2];
        int row3 = matrix[2][0] + matrix[2][1] + matrix[2][2];

        assertTrue(row1 >= 0);
        assertTrue(row2 >= 0);
        assertTrue(row3 >= 0);

        assertFalse(row1 > 3);
        assertFalse(row2 > 3);
        assertFalse(row3 > 3);
    }

}