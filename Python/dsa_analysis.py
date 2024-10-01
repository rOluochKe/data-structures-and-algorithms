#  constant function

# f(n) = c ie c = 15, c = 2^10
# That is, for any argument n, the constant f(n) assigns the value c. In other words, it does not matter what the value of n is; f(n) will always be equal to the constant value c.


# Logarithmic function

# f(n) = logb n for some constant b > 1

# x = logb n if and only if b^x = n


# Linear function

# f(n) = n


# N-Log-N function

# f(n) = nlogn


# Quadratic function

# f(n) = n^2


# Cubic function and other polynomials

# f(n) = n^3


# Exponential function

# f(n) = b^n


# Asymptotic Analysis - in algorithms analysis, we focus on the growth rate of the running time as a function of the input size n, taking a big picture approach. For example, it is often enough just to know that the running time of an algorithm grows proportionally to n.

def find_max(data):
    """Return the maximum element from a nonempty list"""
    biggest = data[0]
    for val in data:
        if val > biggest:
            biggest = val
    return biggest


# The Big Oh notation

# Let f(n) and g(n) be functions mapping positive integers to positive real numbers. We say that f(n) is O(g(n)) if there is a real constant n0 >= 1 such that f(n) <= cg(n), for n >= n0


# characterizing functions in simplest terms

# Big Omega - just as the big-oh notation provides an asymptotic way of saying that a function is 'less than or equal to' another function, the following notation provide an asymptotic way of saying that a function grows at a rate that is 'greater than or equal to' that of another.

# Big Theta - in addition, there is a notation that allows us to say that two functions grow at the same rate, up to constant factors. We say that f(n) is 0(g(n)), 'f(n) is big-theta of g(n)'


# Quadratic time algorithm

def prefix_average(S):
    """Return list such that, for all j, A[j] equals average of S[0], ..., S[j]."""
    n = len(S)
    A = [0] * n
    for j in range(n):
        total = 0
        for i in range(j + 1):
            total += S[i]
        A[j] = total / (j + 1)
    return A

# or


def prefix_average2(S):
    """Return list such that, for j, A[j] equals average of S[0], ..., S[j]"""
    n = len(S)
    A = [0] * n
    for j in range(n):
        A[j] = sum(S[0:j+1]) / (j+1)
    return A

# Linear time algorithm


def prefix_average3(S):
    """Return list such, for all j, A[j] equals average of S[0], ..., S[j]"""
    n = len(S)
    A = [0] * n
    total = 0
    for j in range(n):
        total += S[j]
        A[j] = total / (j+1)
    return A

# three way set disjointness


def disjoint1(A, B, C):
    """Return True if there is no element common to all three lists"""

    for a in A:
        for b in B:
            for c in C:
                if a == b == c:
                    return False
    return True


def disjoint2(A, B, C):
    """Return True if there is no element common to all three lists"""

    for a in A:
        for b in B:
            if a == b:
                for c in C:
                    if a == c:
                        return False
    return True


# Element uniqueness
def unique1(S):
    """Return True if there are no duplicate elements in sequence S"""

    for j in range(len(S)):
        for k in range(j+1, len(S)):
            if S[j] == S[k]:
                return False
    return True


def unique2(S):
    """Return True if there are no duplicate elements in sequence S."""
    temp = sorted(S)
    for j in range(1, len(temp)):
        if S[j-1] == S[j]:
            return False
    return True


def find(S, val):
    """"Return index j such that S[j] == val, or -1 if no such element"""
    n = len(S)
    j = 0
    while j < n:
        if S[j] == val:
            return j
        j += 1
    return -1
