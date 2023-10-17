import java.util.Scanner;

public class Solution2 {

     public static int puzzle(int h, int u, int s){
        int differ = h - s;
        int hours = (h-u)/differ;
        return hours+1;
    }
        public static void main(String[] args) {  
            Scanner sc = new Scanner(System.in);
            int H = sc.nextInt();
            int U = sc.nextInt();
            int S = sc.nextInt();
            int ans = puzzle(H, U, S); 
            System.out.println(ans);
            sc.close();
        } 
    
}
