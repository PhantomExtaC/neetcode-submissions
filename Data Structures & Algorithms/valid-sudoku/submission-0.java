class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
        oNE Approach we have to this whole system is
        Brute force: Create hashset with the following 
        for (every row) {}

        for (every column) {}
        row = 0, col = 0
        while (row, column != 8) {
        hashset for (board[row][col] to board[row + 3][col + 3]) {hashset}
        row, col += 3
        }
        if there is a hashset which hits duplicate even once it returns fals, else true

            However, this is not the optimal approach, so 
            there is an alternate smarter method that I am not able to think, probably
            One observation is, when checking an elemenbt, we have to check only its corresponding row and column, and its grid in the board,
            col and rows can be handled well enough, 
            its where we start thinking of the grid, that we will need an external counter or some conditioning logic to see where it is (i.e the system needs to know where the pointer is, like geolocation)
            one way to see is, 
            0 - 8 is the 9 rows,
            0 - 2 , 3 - 5, 6 - 8
            since the grid is fixed, we can hardcode some solution, however that will probably still be looked at as a bruteforce approach

            im lost
            so
            
        */
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                int val = board[r][c] - '1';
                int boxIndex = (r/3)*3+(c/3);

                if (rows[r][val] || cols[c][val] || boxes[boxIndex][val]) {
                    return false;
                }

                rows[r][val] = true;
                cols[c][val] = true;
                boxes[boxIndex][val] = true;

            }
        }
        return true;
    }
}
