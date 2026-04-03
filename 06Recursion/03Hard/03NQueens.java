import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> order = new ArrayList<>();

        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n -1];
        boolean[] diag2 = new boolean[2*n -1];

        backtracking(n, order, cols, diag1, diag2, 0, new ArrayList<>());

        return order;
    }

    private void backtracking(int n, List<List<String>> order, boolean[] cols, boolean[] diag1, boolean[] diag2, int row, List<String> currentBoard){
        if(row == n){
            // add a copy of current board
            order.add(new ArrayList<>(currentBoard));
            return;
        }

        for(int c = 0; c < n; c++){
            int d1 = row - c + (n - 1);
            int d2 = row + c;

            if(!cols[c] && !diag1[d1] && !diag2[d2]){
                // place queen
                cols[c] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                // create row string with queen at column c
                char[] rowChars = new char[n];
                Arrays.fill(rowChars, '.');
                rowChars[c] = 'Q';
                currentBoard.add(new String(rowChars));

                // recurse to next row
                backtracking(n, order, cols, diag1, diag2, row + 1, currentBoard);

                // backtrack
                currentBoard.remove(currentBoard.size() - 1);
                cols[c] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }
}