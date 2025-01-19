x, y, w, h = map(int, input().split(' '))
a = x if x < w - x else w - x
b = y if y < h - y else h - y
res = a if a < b else b
print(res)