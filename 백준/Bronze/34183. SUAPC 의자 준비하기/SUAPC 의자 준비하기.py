n, m, a, b = map(int, input().split())
need = n * 3 - m
print(0 if need <= 0 else need * a + b)
