n = int(input())
A = list(map(int, input().split()))
dp = [1] * n
prev = [-1] * n
for i in range(n):
    for j in range(i):
        if A[j] < A[i] and dp[j] + 1 > dp[i]:
            dp[i] = dp[j] + 1
            prev[i] = j
length = max(dp)
idx = dp.index(length)
lis = []
while idx != -1:
    lis.append(A[idx])
    idx = prev[idx]
lis.reverse()
print(length)
print(*lis)
