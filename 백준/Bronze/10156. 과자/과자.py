K, N, M = map(int, input().split())
cost = K * N
print(max(0, cost - M))