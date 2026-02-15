from itertools import combinations
from math import gcd
nums = list(map(int, input().split()))
def lcm(a, b):
    return a * b // gcd(a, b)
ans = float('inf')
for a, b, c in combinations(nums, 3):
    x = lcm(a, lcm(b, c))
    ans = min(ans, x)
print(ans)