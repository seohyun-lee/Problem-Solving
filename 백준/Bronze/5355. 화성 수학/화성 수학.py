T = int(input())
for _ in range(T):
    data = input().split()
    num = float(data[0])
    for op in data[1:]:
        if op == '@':
            num *= 3
        elif op == '%':
            num += 5
        elif op == '#':
            num -= 7
    print(f"{num:.2f}")