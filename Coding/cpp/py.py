class Solution:
    def nextPermutation(self, nums) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        print("start")
        n = len(nums)
        print([i for i in range(1,n,-1)])
        for i in range(n,-1):
            print(i)
            if(nums[i]>nums[i-1]):
                temp = nums[i]
                nums[i] = nums[i-1]
                nums[i-1] = temp
                print(nums)
                return 
        nums.reverse()
        print(nums)
        print("end")
        return

sol = Solution()
sol.nextPermutation([1,2,3])
