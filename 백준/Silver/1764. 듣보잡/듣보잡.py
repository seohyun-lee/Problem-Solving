import sys
input = sys.stdin.readline
n, m= map(int, input().split())
h = set(input().strip() for _ in range(n))
s  = set(input().strip() for _ in range(m))
rs = sorted(h & s)
print(len(rs))
print("\n".join(rs))
