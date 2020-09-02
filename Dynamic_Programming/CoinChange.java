package Dynamic_Programming;
/*
------------------------------------------------------
                    Problem Statemet
------------------------------------------------------
Given a collection of coins and sum (W). 
Find the total number of ways to make a change of 
sum (W) using the given array of coins

Approach used: Bottom Up (Tablular method)
*/

public class CoinChange {
    /*
    ------------------------------------------------------
                        Assumptions
    ------------------------------------------------------
    1.  If the coin value (coins[i]) < sum (W) 
        => we can't make change using that coin
    
    2.  If there is no coin in the list
        => No ways we can make a change
    
    ------------------------------------------------------
    IDEA: If multiples of coins completely substracts the 
          sum(W) to 0
          => we can make a change
    */

    //  Accepts Array of coins and sum (W)
    //  Returns : integer 
    //          Total number of ways to make a change of sum(W)

    public static int totalWays(int[] coins, int W){
        int[][] T = new int[coins.length+1][W+1];

        for(int i = 1; i<=coins.length;i++){
            T[i][0] = 1;
            for(int w = 1; w<=W; w++){
                if(w-coins[i-1] < 0){
                    T[i][w] = T[i-1][w];
                }else{
                    T[i][w] = T[i][w-coins[i-1]] + T[i-1][w];
                }
                
            }
        }


        return T[coins.length][W];
    }
    
    public static void main(String[] args){
        System.out.println(totalWays(new int[]{2,3,5,10}, 15));
    }
}