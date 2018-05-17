public class Lottery {
    public static void main(String[] args) {
        for (int i = 1; i < 9; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= 10; k++) {
                    if(i < j && j < k){
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
