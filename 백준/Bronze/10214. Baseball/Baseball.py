T = int(input())
for _ in range(T):
    y_score = k_score = 0
    for _ in range(9):
        y, k = map(int, input().split())
        y_score += y
        k_score += k
    if y_score > k_score:
        print("Yonsei")
    elif y_score < k_score:
        print("Korea")
    else:
        print("Draw")