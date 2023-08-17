public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int k = 1;
        int maxK = 0;
        int result = 0;

        for(int p : piles){
            maxK = Math.max(maxK, p);
        }

        // System.out.println(maxK);
        while(k < maxK){

            int mid = k + (maxK - k) / 2;

            int hour = 0;
            for(int p : piles){
                hour += Math.ceil(p*1.0/mid);
            }

            if(hour <= h){
                maxK = mid;
            } else if(hour > h){
                k = mid+1;
            }

        }
        return k;
    }

    public static void main(String[] args) {
        KokoEatingBanana sol = new KokoEatingBanana();
        System.out.println(sol.minEatingSpeed(new int[]{312884470}, 312884469));
    }
}
