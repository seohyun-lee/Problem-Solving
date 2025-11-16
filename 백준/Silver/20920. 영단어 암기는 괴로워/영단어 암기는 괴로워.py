import sys
input = sys.stdin.readline
n, m = map(int, input().split())
freq = {}
for _ in range(n):
    w = input().strip()
    if len(w) < m:
        continue
    freq[w] = freq.get(w, 0) + 1

# 정렬 기준: (-빈도, -길이, 단어)
rs = sorted(freq.keys(), key=lambda w: (-freq[w], -len(w), w))
print("\n".join(rs))
