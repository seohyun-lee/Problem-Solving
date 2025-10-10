N = int(input())
votes = [int(input()) for _ in range(N)]
if votes.count(1) > votes.count(0):
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")