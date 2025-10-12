while True:
    s = input()
    if s == '#': 
        break
    print(sum(ch.lower() in 'aeiou' for ch in s))
