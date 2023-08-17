import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumDuplicate {

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.nums = candidates;
        Arrays.sort(nums);

        backtrack(0, target, new ArrayList<>());

        return result;
    }

    private void backtrack(int i, int sum, List<Integer> list){

        if(sum == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        if(sum < 0 || i == nums.length) return;

        list.add(nums[i]);
        backtrack(i+1, sum - nums[i], list);
        list.remove(list.size() -1);

        while( i+1 < nums.length && nums[i] == nums[i+1]){
            i++;
        }

        backtrack(i+1, sum, list);

    }

    public static void main(String[] args) {
        CombinationSumDuplicate sol = new CombinationSumDuplicate();

        System.out.println(sol.combinationSum2(new int[]{2,5,1,2}, 5));
    }
}
