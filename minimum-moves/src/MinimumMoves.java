import java.util.List;

public class MinimumMoves {
    int min = Integer.MAX_VALUE;
    List<List<Integer>> grid;
    public void findMinimumMoves(List<List<Integer>> maze, int k){

        grid = maze;
        dfs(0, 0, k, 0);
//        BigInteger.probablePrime()

    }

    private void dfs(int i, int j, int k, int moves){

        if(moves > k) return;

        if(i == grid.size() || j == grid.get(0).size()) return;

        if(i == grid.size() - 1 && j == grid.get(0).size() - 1){
            min = Math.min(moves, min);
        }

        dfs(i, j+1, k, moves+1);

        dfs(i+1, j, k, moves+1);
    }
}
