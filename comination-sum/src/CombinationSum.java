import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();
        sol.combinationSum(new int[]{2,3,5}, 7);
    }

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        nums = candidates;

        combinationSum(new ArrayList<>(), 0, target);

        return result;

    }

    private void combinationSum(List<Integer> combinations, int i, int target){

        if(target == 0) {
            result.add(new ArrayList<>(combinations));
        }

        if(i == nums.length || target < 0 ) return;

        combinations.add(nums[i]);

        combinationSum(combinations, i, target - nums[i]);

        combinations.remove(combinations.size() - 1);

        combinationSum(combinations, i+1, target);
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(candidates, 0, new ArrayList(), target, result);
        return result;
    }

    private void dfs(int[] candidates, int i, List<Integer> combination, int target, List<List<Integer>> result){

        if(target == 0){
            result.add(new ArrayList(combination));
            return;
        }

        if(target < 0 || i >= candidates.length){
            return;
        }

        combination.add(candidates[i]);
        dfs(candidates, i, combination, target-candidates[i], result);
        combination.remove(combination.size() - 1);
        dfs(candidates, i+1, combination, target, result);
    }
}
