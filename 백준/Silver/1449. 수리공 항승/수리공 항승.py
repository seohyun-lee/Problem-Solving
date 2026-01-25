N,L=map(int,input().split())
pos=list(map(int,input().split()))
pos.sort()
count=1
end=pos[0]-0.5+L
for p in pos[1:]:
    if p+0.5 > end:
        count+=1
        end=p-0.5+L
print(count)