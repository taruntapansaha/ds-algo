public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > nums[lo]) {
                if (target > nums[mid] || target < nums[lo]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target < nums[mid] || target > nums[hi]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
//        System.out.println();
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

        sol.search(new int[]{3, 1}, 1);
    }
}
