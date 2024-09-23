# Traditional

def factors(n):
    results = []
    for k in range(1, n+1):
        if n % k == 0:
            results.append(k)
    return results


# Generator
def factors(n):
    for k in range(1, n+1):
        if n % k == 0:
            yield k


# More

def fibonacci():
    a = 0
    b = 1
    while True:
        yield a
        future = a + b
        a = b
        b = future
