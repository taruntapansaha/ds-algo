import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class MinimumTaps {

    private int min = Integer.MAX_VALUE;
    private int N;

    public static void main(String[] args) {
        MinimumTaps minimumTaps = new MinimumTaps();

        int i = minimumTaps.minimumTapsToWaterGarden(Arrays.asList(0, 0, 0));
        System.out.println("abcd".substring(1));

        System.out.println(i);
    }

    public int minimumTapsToWaterGarden(List<Integer> ranges){

        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[]{1, 2, 3};
        List<Integer> list = new ArrayList<>();
        Arrays.stream(nums).forEach(list::add);

        N  = ranges.size();
        List<Integer> area = new ArrayList<>();

        for(int i = 0; i < N; i++){
            int curr = ranges.get(i);

            int left = Math.max(i - curr, 0);
            int right = i + curr;

            area.add(left+right+1);
        }

        findMinCount(area, 0, 0, 0);

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void findMinCount(List<Integer> nums, int i, int sum, int count){

        if(sum >= N+1){
            min = Math.min(min, count);
        }

        if(i == nums.size()){
            return;
        }

        findMinCount(nums, i+1, sum, count);
        findMinCount(nums, i+1, sum+nums.get(i), count+1);
    }
}
