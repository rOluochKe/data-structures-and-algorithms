def merge(S1, S2, S):
    """Merge two sorted lists S1 and S2 into properly list S"""
    i = j = 0
    while i + j < len(S):
        if j == len(S2) or (i < len(S1) and S1[i] < S2[j]):
            S[i+j] = S1[i]
            i += 1
        else:
            S[i+j] = S2[j]
            j += 1


def merge_sort(S):
    """Sort the elements of lists S using merge sort algorithm"""
    if len(S) < 2:
        return
    mid = len(S) // 2
    S1, S2 = S[:mid], S[mid:]
    merge_sort(S1)
    merge_sort(S2)
    merge(S1, S2, S)


def decorated_merge_sort(data, key=None):
    if key is not None:
        for j in range(len(data)):
            data[j] = _Item(key(data[j]), data[j])
    merge_sort(data)
    if key is not None:
        for j in range(len(data)):
            data[j] = data[j]._value


def quick_select(S, k):
    """Return the kth smallest of list S, for k from 1 to en(S)"""
    if len(S) == 1:
        return S[0]
    else:
        pivot = S[len(S) // 2]
        left = [x for x in S if x < pivot]
        middle = [x for x in S if x == pivot]
        right = [x for x in S if x > pivot]
        if k <= len(left):
            return quick_select(left, k)
        elif k <= len(left) + len(middle):
            return middle[0]
        else:
            return quick_select(right, k - len(left) - len(middle))
