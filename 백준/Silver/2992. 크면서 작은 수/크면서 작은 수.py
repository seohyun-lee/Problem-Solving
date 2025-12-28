import sys
from itertools import permutations

x_str = sys.stdin.readline().strip()
x_int = int(x_str)
perms = permutations(x_str)
candidates = []
for p in perms:
    num = int(''.join(p))
    if num > x_int:
        candidates.append(num)
if candidates:
    print(min(candidates))
else:
    print(0)