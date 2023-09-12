def solution(nums):
    cnt = 0
    for i in range(len(nums)):
        for j in range(i+1,len(nums)):
            for k in range(j+1, len(nums)):
                num = nums[i]+nums[j]+nums[k]
                for x in range(3,num+1):
                    if x == num:
                        cnt = cnt+1
                    if num%x == 0:
                        break;

    return cnt