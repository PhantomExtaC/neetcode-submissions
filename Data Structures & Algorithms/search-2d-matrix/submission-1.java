class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int rows = matrix.length;        
        int cols = matrix[0].length;
        
        int left = 0;
        int right = (rows * cols) - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            /*
            SO HOW THIS WORKS
            DIVIDING THE MIDD BY NO. OF ROWS GIVES US EXACTLYWHICH ROW IT IS IN
            AND MODULUS POINTS US TO THE COLUMN, AS IT IGNORES THE ROW MULTIPLIER
            EXAMPLE:
            A 4 ROW AND 5 COLUMN MATRIX, THE MID IS CALCULATED AS 
            left = 0
            right = 19 ((4 * 5) - 1)
            mid = 0 + (19 / 2)
            mid = 9 (round down)
            
            */
            int midRow = mid / cols;
            int midCol = mid % cols;
            int midValue  = matrix[midRow][midCol];
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
        /*
        matrix is SORTED, so when finding target, first get the size of the matrix for limits
        to simplify, we take the first column to narrow down the search
        matrix[rows/2][cols/2];
        if match not found, if else statements to find 
        
        four pointers, 
        colEnd = cols - 1;
        rowEnd = rows - 1;
        colStart = 0;
        rowStart = 0;
        col = cols / 2;
        row = rows / 2;
        while (rowEnd > rowStart && colEnd > colStart )
        int number = matrix[row][col];
        if target == number
            return true
        if target < number
            then new colEnd = col, new rowEnd = row
        if target > number
            then new colStart = col, new rowStart = row
        row = rowStart + (rowEnd - rowStart)/2 
        col = colStart + (colEnd - colStart)/2 
        */
    }
}
