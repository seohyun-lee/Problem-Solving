mushrooms = [int(input()) for _ in range(10)]
total = 0
best = 0
for m in mushrooms:
    total += m
    if abs(100 - total) < abs(100 - best):
        best = total
    elif abs(100 - total) == abs(100 - best):
        best = max(best, total)
print(best)