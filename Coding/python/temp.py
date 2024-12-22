class Solution:
    def longestCommonSubsequence(self, str1: str,str2: str) -> int:
        n1 = len(str1)
        n2 = len(str2)
        dp = [[0]*n2 for _ in range(n1)]

        for i in range(n1):
            for j in range(n2):
                bi = 0 if(i==0) else dp[i-1][j]
                bj = 0 if(j==0) else dp[i][j-1]
                  

                if(str1[i]==str2[j]):
                    if(i==0 or j==0):
                        dp[i][j] = 1
                    else:
                        dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(bi,bj)
        for i in dp:
            print(i)
        return dp[n1-1][n2-1]

sol = Solution()
str1 = "abaaa"
str2 = "baabaca"
print(sol.longestCommonSubsequence(str1,str2))