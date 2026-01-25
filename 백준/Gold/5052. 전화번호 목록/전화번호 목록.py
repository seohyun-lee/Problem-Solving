t = int(input())
for _ in range(t):
    n = int(input())
    nums = [input().strip() for _ in range(n)]
    nums.sort()
    consistent = True
    for i in range(n - 1):
        if nums[i + 1].startswith(nums[i]):
            consistent = False
            break
    print("YES" if consistent else "NO")