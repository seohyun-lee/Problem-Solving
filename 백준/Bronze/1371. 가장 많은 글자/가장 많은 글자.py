from collections import Counter
import sys

cnt = Counter()
for line in sys.stdin:
    cnt.update(ch for ch in line if ch.isalpha())

max_cnt = max(cnt.values())
result = ''.join(sorted([ch for ch, v in cnt.items() if v == max_cnt]))
print(result)