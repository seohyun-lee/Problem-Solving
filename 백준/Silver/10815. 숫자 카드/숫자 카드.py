n = int(input())
cards = set(map(int, input().split()))
m = int(input())
targets = list(map(int, input().split()))

result = []
for t in targets:
    if t in cards:
        result.append("1")
    else:
        result.append("0")

print(" ".join(result))