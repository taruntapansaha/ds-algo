public class MaximumPathSum {

    public int maxPathSum(TreeNode root) {
        int[] result = {Integer.MIN_VALUE};
        dfs(root, result);
        return result[0];
    }

    private int dfs(TreeNode root, int[] result){

        if(root == null) return 0;

        int left = dfs(root.left, result);
        int right = dfs(root.right, result);

        int straightPath = Math.max(Math.max(left, right) + root.val, root.val);
        int rootPath = Math.max(straightPath, left+right+root.val);

        result[0] = Math.max(rootPath, result[0]);
        return straightPath;
    }

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
}
