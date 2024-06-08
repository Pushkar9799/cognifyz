public class Demo {
    public static void main(String[] args) {
       int[][] matrix = {
               {1,4,7,11,15},
               {2,5,8,12,19},
               {3,6,9,16,22}
       };
       int target = 500;
       // System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == target) System.out.println("Target found");
            }
        }
    }
}
