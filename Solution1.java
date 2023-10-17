import java.util.Scanner;

public class Solution1 {

    public static int minSwaps(int[] nums) {
        int[] temp = new int[nums.length * 2];
        
        for(int i = 0; i < temp.length; ++i){
            temp[i] = nums[i % nums.length]; 
        }
        
        int win = 0;
        for(int num : nums){ 
            if(num == 1) win++;
        }
		
        if(win == nums.length) return 0; 
        int minSwaps = Integer.MAX_VALUE;
        int l = 0, r = 0;
        int cone = 0; 
        while(r < nums.length + win){
            if(temp[r] == 1) cone++;
            
            if(r - l + 1 > win){ 
                if(temp[l] == 1) cone--;
                l++;
            }
            
            if(r - l + 1 == win){ 
                int currentWinSwapNeeded = win - cone;
                minSwaps = Math.min(minSwaps, currentWinSwapNeeded);
            }
            r++;
        }
        
        return minSwaps;    }

    public static void main(String[] args) {
    Scanner ss=new Scanner(System.in);
    int n=ss.nextInt();
    int arr[]=new int[n];
    for(int g=0;g<n;g++)
    {
    arr[g]=ss.nextInt();

    }

    System.out.println(minSwaps(arr));
}
}
