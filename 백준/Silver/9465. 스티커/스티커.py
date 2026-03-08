T = int(input())
for _ in range(T):
    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    if n == 1:
        print(max(a[0], b[0]))
        continue
    dp = [[0]*n for _ in range(2)]
    dp[0][0] = a[0]
    dp[1][0] = b[0]
    dp[0][1] = a[1] + b[0]
    dp[1][1] = b[1] + a[0]
    for i in range(2, n):
        dp[0][i] = max(dp[1][i-1], dp[1][i-2]) + a[i]
        dp[1][i] = max(dp[0][i-1], dp[0][i-2]) + b[i]
    print(max(dp[0][n-1], dp[1][n-1]))