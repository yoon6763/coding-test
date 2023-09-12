def solution(nums):
    nums2 = []
    for i in nums:
        if i not in nums2:
            nums2.append(i)
    if len(nums2) > len(nums)/2:
        return len(nums) / 2
    return len(nums2)