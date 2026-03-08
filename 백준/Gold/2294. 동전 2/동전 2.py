n, k = map(int, input().split())
coins = [int(input()) for _ in range(n)]
INF = 10001
dp = [INF] * (k + 1)
dp[0] = 0
for coin in coins:
    for i in range(coin, k + 1):
        dp[i] = min(dp[i], dp[i - coin] + 1)
print(dp[k] if dp[k] != INF else -1)