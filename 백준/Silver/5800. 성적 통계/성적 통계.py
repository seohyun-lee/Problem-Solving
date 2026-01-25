K = int(input())
for i in range(1, K + 1):
    data = list(map(int, input().split()))
    scores = data[1:]
    scores.sort(reverse=True)
    max_score = scores[0]
    min_score = scores[-1]
    largest_gap = 0
    for j in range(len(scores) - 1):
        gap = scores[j] - scores[j + 1]
        if gap > largest_gap:
            largest_gap = gap
    print(f"Class {i}")
    print(f"Max {max_score}, Min {min_score}, Largest gap {largest_gap}")