public class Wspolne {
    public static void run() {

        String X ="karamba";
        String Y ="abrakadabra";
        int[][] array = new int[X.length()][Y.length()];

        for (int i = 1; i < X.length(); i++) {
            for (int j = 1; j < Y.length(); j++) {
                if (X.charAt(i) == Y.charAt(j)) array[i][j]=array[i-1][j-1]+1;
                else array[i][j] = Math.max(array[i - 1][j], array[i][j - 1]);
            }
        }
        System.out.println(array[X.length()-1][Y.length()-1]);
    }
}
