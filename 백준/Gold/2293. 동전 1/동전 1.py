n, k = map(int, input().split())
coins = []
for _ in range(n):
    coins.append(int(input().strip()))
coins = list(set(coins))
coins = [c for c in coins if c <= k]
dp = [0] * (k + 1)
dp[0] = 1
for coin in coins:
    for money in range(coin, k + 1):
        dp[money] += dp[money - coin]
print(dp[k])