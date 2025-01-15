a,b,c=map(int, input().split(" "))
d=int(input())
tt=a*3600+b*60+c+d
tt%=3600*24
th=tt//3600
tm=(tt%3600)//60
ts=tt%60
print(th,tm,ts)