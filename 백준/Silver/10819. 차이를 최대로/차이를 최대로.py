from itertools import permutations
N = int(input().strip())
A = list(map(int, input().split()))
ans = 0
for p in permutations(A, N):
    s = 0
    for i in range(N - 1):
        s += abs(p[i] - p[i + 1])
    ans = max(ans, s)
print(ans)