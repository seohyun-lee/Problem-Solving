import sys
input = sys.stdin.readline

n = int(input())
T = [0]*(n+1)
P = [0]*(n+1)
for i in range(1, n+1):
    t, p = map(int, input().split())
    T[i] = t
    P[i] = p
    
dp = [0] * (n+2)
for i in range(1, n+1):
    dp[i] = max(dp[i], dp[i-1])
    end = i+T[i]
    if end <= n+1:
        dp[end] = max(dp[end], dp[i]+P[i])
        
print(max(dp))