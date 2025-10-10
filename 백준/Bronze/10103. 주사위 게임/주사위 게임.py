n = int(input())
chang, sang = 100, 100
for _ in range(n):
    c, s = map(int, input().split())
    if c > s:
        sang -= c
    elif c < s:
        chang -= s
print(chang)
print(sang)