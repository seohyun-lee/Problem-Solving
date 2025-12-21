i=1
while True:
    l, p, v = map(int, input().split())
    if l==0:
        break
    print(f"Case {i}: {v//p*l+min(v%p, l)}")
    i+=1