package temp;

//{ Driver Code Starts
//Initial Template for Java

public class GfG
{
    public static void main(String args[])
        {
            // Scanner sc = new Scanner(System.in);
            // int t = sc.nextInt();
            int t = 1;
            while(t-->0)
                {
                    // int n = sc.nextInt();
                    // int sum = sc.nextInt();
                    // int arr[] = new int[n];
                    // for(int i = 0;i<n;i++)
                    // arr[i] = sc.nextInt();
                    int n = 2;
                    int sum = 1;
                    int arr[] = new int[2];
                    arr[0] = 1;
                    arr[1] = 0;
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    private int mod = 1000000007;
    
    private int recurr(int i, int arr[],int n, int sum,int dp[][]){
        if(i==n && sum==0) return 1;
        if(i==n || sum<0) return 0;
        
        if(dp[i][sum]!=-1) return dp[i][sum];
        
        int pick = recurr(i+1,arr,n,sum-arr[i],dp)%mod;
        int notPick = recurr(i+1,arr,n,sum,dp)%mod;
        return dp[i][sum] = (pick+notPick)%mod;
    }
    
	public int perfectSum(int arr[],int n, int sum){ 
	    int dp[][] = new int[n][sum+1];
	    for(int i=0; i<n; i++){
	        for(int j=0; j<sum+1; j++)
	            dp[i][j] = -1;
	    }
	            
	    return recurr(0,arr,n,sum,dp);
	} 
}