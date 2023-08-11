/*
2352. Equal Row and Column Pairs
Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.
A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).
*/

class EqualRowsAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (compareRowColumn(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean compareRowColumn(int[][] grid, int rowIndex, int colIndex) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[rowIndex][i] != grid[i][colIndex]) {
                return false;
            }
        }
        return true;
    }
}