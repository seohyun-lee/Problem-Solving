n = int(input())
cur = n
while cur >= 4:
    ok = True
    for ch in str(cur):
        if ch != '4' and ch != '7':
            ok = False
            break
    if ok:
        print(cur)
        break
    cur -= 1