import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDuplicates {

    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;

        subset(0, new ArrayList<>());

        return result;
    }

    private void subset(int i, List<Integer> list){

        if(i == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        subset(i+1, list);
        list.remove(list.size() - 1);

        while(i < nums.length -1 && nums[i] == nums[i+1]){
            i++;
        }

        subset(i+1, list);

    }

    public static void main(String[] args) {
        SubsetsWithDuplicates sol = new SubsetsWithDuplicates();
        System.out.println(sol.subsetsWithDup(new int[]{1, 2, 2}));
    }

}
