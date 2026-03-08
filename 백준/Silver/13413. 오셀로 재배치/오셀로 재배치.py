T = int(input())
for _ in range(T):
    n = int(input())
    A = input().strip()
    B = input().strip()
    wb = 0
    bw = 0
    for a, b in zip(A, B):
        if a == 'W' and b == 'B':
            wb += 1
        elif a == 'B' and b == 'W':
            bw += 1
    print(max(wb, bw))