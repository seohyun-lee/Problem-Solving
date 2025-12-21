n = input()
if '0' not in n:
    print(-1)
else:
    s = sum(map(int, str(n)))
    if s % 3 != 0:
        print(-1)
    else:
        ans = "".join(sorted(n, reverse=True))
        print(ans)