import java.util.ArrayList;
import java.util.List;

public class SmoothPeriods {
    public static long getDescentPeriods(int[] prices) {
        long out = prices.length;
        // 1 - 3 - 6 - 10
        List<Long> temp = new ArrayList<>();
        long counter = 0;

        for(int i=0; i<prices.length-1; i++){
            if(prices[i]-1 == prices[i+1]){
                counter++;
            }else{
                if(counter != 0){
                    temp.add(counter);
                    counter = 0;
                }
            }
        }
        if (counter != 0){
            temp.add(counter);
        }
        for(long a : temp){
            out += (a*(a+1))/2;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {12,11,10,9,8,7,6,5,4,3,4,3,10,9,8,7};
        System.out.println(getDescentPeriods(nums));
    }
}
