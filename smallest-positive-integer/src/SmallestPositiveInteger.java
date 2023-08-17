import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {

    public static void main(String[] args) {
        SmallestPositiveInteger sol = new SmallestPositiveInteger();
//        System.out.println(sol.smallestPositiveInteger(new int[]{-3, -4}));
        System.out.println(sol.smallestPositiveInteger(new int[]{0, 1, 5, 3, 4, 6, 7, 2, 8}));
    }


    public int smallestPositiveInteger(int[] arr){

        int N = 100000;
        int max = 0;
        Set<Integer> set = new HashSet<>();

        for(int n: arr){
            set.add(n);
        }


        for(int i=1; i<N+1; i++){
            if(!set.contains(i)) return i;
            else {
                max = Math.max(max, i);
            }
        }

        return max+1;
    }
}
