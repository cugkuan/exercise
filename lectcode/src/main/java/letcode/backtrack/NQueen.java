package letcode.backtrack;

/**
 * https://leetcode.cn/problems/n-queens/
 * <p>
 * N 皇后问题
 * 就是一个回溯算法的升级版本
 */

class NQueen {
    private int n;
    private char[][] board;
    public NQueen(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
    }
    public void solve() {
        backTrack(0);
    }
    private void print() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int row = 0; row < n; row++) {
            builder.append("[\"");
            for (int col = 0; col < n; col++) {
                builder.append(board[row][col]);
            }
            builder.append("\"],");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.append("]");
        System.out.println(builder);
    }

    private void backTrack(int row) {
        if (row == n) {
            print();
        } else {
            for (int i = 0; i < n; i++) {
                if (!check(row, i)) {
                    continue;
                }
                board[row][i] = 'Q';
                backTrack(row + 1);
                board[row][i] = '.';
            }
        }
    }

    private boolean check(int row, int col) {
        // 检查列是否有冲突
        for (int i = 0; i <= row; i++) {
            if (board[i][col] == 'Q')
                return false;
        }
        // 检查 右上方是否有
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }
        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new NQueen(4).solve();
    }
}