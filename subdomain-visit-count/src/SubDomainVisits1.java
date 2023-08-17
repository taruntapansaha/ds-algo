import java.util.*;
import java.util.stream.Collectors;

public class SubDomainVisits1 {
    Map<String, Integer> map = new HashMap<>();

    public List<String> subdomainVisits(String[] cpdomains) {

        for(String str : cpdomains){
            recordCount(str);
        }
        return map.entrySet().stream()
                .parallel()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    private void recordCount(String domain){

        int count = Integer.parseInt(domain.substring(0, domain.indexOf(" ")));
        String subdomain = domain.substring(domain.indexOf(" ")+1);

        List<Integer> dotIdx = new ArrayList();
        dotIdx.add(-1);

        for(int i=1; i < subdomain.length(); i++){
            if(subdomain.charAt(i) == '.') dotIdx.add(i);
        }

        for(int i = 0; i < dotIdx.size(); i++){
            String key = subdomain.substring(dotIdx.get(i)+1);
            map.put(key, map.getOrDefault(key, 0) + count);
        }
    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Character>> cols = new HashMap<>();
        Map<Integer, HashSet<Character>> row = new HashMap<>();
        Map<String, HashSet<Character>> boxes = new HashMap<>();

        for(int i=0; i < 9; i++){
            for(int j=0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                char curr = board[i][j];
                if( !row.get(i).add(curr)
                        || !cols.get(j).add(curr)
                        || !boxes.get(i+""+j).add(curr)){
                    return false;
                }

            }
        }

        return true;
    }
}
