package kakao.delivery2023;

//꽉채워서 다녀오는거랑 찌끄래기들 다니는거랑 리스트업을 분리해서 다녀온값을 합쳐야 할듯

class Solution {

    int gCap;
    int[] gDeli;
    int[] gPick;

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        gCap = cap;
        gDeli = deliveries.clone();
        gPick = pickups.clone();

        return solve(n) * 2;
    }

    private long solve(int n) {
        int nextN = n;
        int remainDeli = gCap;
        int remainPick = gCap;
        int answer = n;

        for (int i = n - 1; i >= 0; i--) {
            if (remainDeli < gDeli[i]
                    | remainPick < gPick[i]) {
                answer += solve(nextN);
                break;
            }

            remainDeli -= gDeli[i];
            remainPick -= gPick[i];
            nextN--;
        }

        return answer;
    }

}