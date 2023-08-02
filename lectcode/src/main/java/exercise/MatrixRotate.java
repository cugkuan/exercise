package exercise;

/**
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 */
public class MatrixRotate {

    /**
     * 对于任意点（i,j），设矩阵的长度为 n,那么旋转后,对应的 点为 （j,n-i-1）
     * 于是对于一次的旋转有如下规律：
     *                 matrix[i][j]  = matrix[j][n-i-1];
     *                 matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
     *                 matrix[n-i-1][n-j-1] = matrix[n-j-1][n-(n-i-1)-1] = matrix[n-j-1][i];
     *                 matrix[n-j-1][i]   = matrix[i][n-(n-j-1)-1] = matrix[i][j];
     * @param matrix
     */
    public void rotate(int[][] matrix){
        int a ;
        int n = matrix.length;
        for (int i = 0; i < n ;i++){
            for (int j = i;j< n-i-1; j++){
                a = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = a;
            }
        }
    }

    private void print(int[][] matrix){
        StringBuilder builder = new StringBuilder();
        int n = matrix.length;
        for (int i = 0;i <n;i++){
            builder.append('[');
            for (int j = 0;j <n;j++){
                builder.append(matrix[i][j]);
                builder.append(',');
            }
            builder.deleteCharAt(builder.length()-1);
            builder.append(']');
            builder.append('\n');
        }
        System.out.println(builder);
    }

    public static void main(String[] args){

        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        MatrixRotate rotate = new MatrixRotate();
        rotate.print(input);
        rotate.rotate(input);
        rotate.print(input);
    }
}
