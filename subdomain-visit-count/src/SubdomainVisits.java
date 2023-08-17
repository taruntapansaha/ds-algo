import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SubdomainVisits {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for(String domain : cpdomains){
            String[] domainCount = domain.split(" ");

            int count = Integer.parseInt(domainCount[0]);
            String[] domains = domainCount[1].split("\\.");
            StringBuilder subDomain = new StringBuilder();
            for(int i = domains.length - 1; i >= 0; i--){
                subDomain.insert(0, domains[i]);
                int val = map.getOrDefault(subDomain.toString(), 0) + count;
                map.put(subDomain.toString(), val);
                subDomain.insert(0, ".");
            }
        }

        return map.entrySet().stream().map( entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        SubdomainVisits sol = new SubdomainVisits();

        sol.subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"});
    }
}
