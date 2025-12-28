s = input().strip()
n = len(s)
for i in range(n):
    suffix = s[i:]
    if suffix == suffix[::-1]:
        print(n+i)
        break