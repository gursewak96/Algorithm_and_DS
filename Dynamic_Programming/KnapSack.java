package Dynamic_Programming;
/*
------------------------------------------------------
                    Problem Statemet
------------------------------------------------------
Given a collection of element with corresponding weight
and profits. Pick the element such that maximum profit 
is gained provided the total weight of picked item is
not greater than the limit of the knapsack or simply bag.
*/

public class KnapSack {
    /*
    ------------------------------------------
                    CONCEPT
    ------------------------------------------
    calculate profit of various combination, by selecting 
    and not selecting the ith element.
    
    Approach used: bottom up (TABULAR METHOD)

    */

    /*
        Accepts:
            1. integer array of profits
            2. integer array of weights
            3. Capacity C of the knapsack
            4. N number of elements
        return: 
            maximum profit possible
    */
    private static int maxProfit(int[] p, int[] w, int C, int N){
        int[][] P = new int[N+1][C+1];

        for(int i=1; i<=N; i++){
            for(int c=1; c<=C; c++){
                if(c<w[i-1]){
                    P[i][c] = P[i-1][c];
                }else{
                    //profit if ith element is selected
                    int p1 = p[i-1] + P[i-1][c-w[i-1]];
                    
                    // profit if ith element is not selected
                    int p2 = P[i-1][c];
                    P[i][c] = Math.max(p1, p2);
                }
            }
        }

        return P[N][C];
    }
    public static void main(String[] args){
        int[] p = {2,3,1,4};
        int[] w = {3,4,6,5};
        int C = 8;
        int N = p.length;

        int maxProfit = maxProfit(p, w, C, N);
        System.out.println(maxProfit);
    }
}