from collections import deque

N = int(input())
cards = deque(range(1, N+1))
result = []
while len(cards)>1:
    result.append(cards.popleft())
    cards.append(cards.popleft())
result.append(cards[0])
print(*result)
