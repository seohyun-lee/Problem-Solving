N = int(input())
MOD = 10007
dp = [1]*10
for _ in range(2, N + 1):
    for d in range(1, 10):
        dp[d] = (dp[d] + dp[d - 1]) % MOD
print(sum(dp) % MOD)