def find_brute(T, P):
    """Return the lowest index of T at which substring P begins (or else -1)"""
    n, m = len(T), len(P)
    for i in range(n-m+1):
        k = 0
        while k < m and T[i+k] == P[k]:
            k += 1
        if k == m:
            return i
    return -1


def find_boyer_move(T, P):
    """Return the lowest index of T at which substring P begins (or else -1)"""
    n, m = len(T), len(P)
    skip = [m] * 256
    for k in range(m-1):
        skip[ord(P[k])] = m-k-1
    i = m-1
    while i < n:
        j = m-1
        while T[i] == P[j]:
            if j == 0:
                return i
            i -= 1
            j -= 1
        i += skip[ord(T[i])]
    return -1


def find_kmp(T, P):
    """Return the lowest index of T at which substring P begins (or else -1)"""
    n, m = len(T), len(P)
    if m == 0:
        return 0
    fail = compute_kmp_fail(P)
    j = 0
    k = 0
    while j < n:
        if T[j] == P[k]:
            if k == m-1:
                return j-k
            j += 1
            k += 1
        else:
            if k > 0:
                k = fail[k-1]
            else:
                j += 1
    return -1


def compute_kmp_fail(P):
    """Utility that computes and returns KMP list"""
    m = len(P)
    fail = [0] * m
    j = 1
    k = 0
    while j < m:
        if P[j] == P[k]:
            fail[j] = k+1
            j += 1
            k += 1
        elif k > 0:
            k = fail[k-1]
        else:
            fail[j] = 0
            j += 1
    return fail


def matrix_chain(d):
    """d is a list of n+1 numbers such that size of kth matrix is d[k]-by-d[k+1]

    Return an n-by-n table such that N[i][j] represents the minimum number of multiplications needed to compute the product of Ai through Aj inclusive"""

    n = len(d) - 1
    N = [[0] * n for i in range(n)]
    for i in range(1, n):
        N[i][i] = 0
    for l in range(2, n+1):
        for i in range(1, n-l+2):
            j = i+l-1
            N[i][j] = float("inf")
            for k in range(i, j):
                q = N[i][k] + N[k+1][j] + d[i-1]*d[k]*d[j]
                if q < N[i][j]:
                    N[i][j] = q
    return N


def LCS(X, Y):
    """Return table such that L[J][K] is length of longest common subsequence (LCS) of X[0:j] and Y[0:k]"""
    n, m = len(X), len(Y)
    L = [[0] * (m+1) for i in range(n+1)]
    for i in range(n):
        for j in range(m):
            if X[i] == Y[j]:
                L[i+1][j+1] = L[i][j] + 1
            else:
                L[i+1][j+1] = max(L[i][j+1], L[i+1][j])
    return L


def LCS_solution(X, Y, L):
    """Return LCS of X and Y, given LCS table L"""
    solution = []
    i, j = len(X), len(Y)
    while i > 0 and j > 0:
        if X[i-1] == Y[j-1]:
            solution.append(X[i-1])
            i -= 1
            j -= 1
        elif L[i-1][j] > L[i][j-1]:
            i -= 1
        else:
            j -= 1
    return solution[::-1]
