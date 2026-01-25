N=int(input())
ans=0
digit=1
start=1
while start<=N:
    cnt=min(N,start*10-1)-start+1
    ans+=cnt*digit
    digit+=1
    start*=10
print(ans)