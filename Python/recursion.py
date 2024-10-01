# Recursion - is a technique by which a function makes one or more call to itself during execution, or by which a data structure relies upon smaller instances of the very same type of structure in its representation.

# the factorial function - n!
# an English ruler
# binary search
# the file system

import os


def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n - 1)


def draw_line(tick_length, tick_label):
    """Draw one line with given tick length (followed by optional label)"""
    line = '-' * tick_length
    if tick_label:
        line += ' ' + tick_label
    print(line)


def draw_interval(center_length):
    """Draw tic interval based upon a central length"""
    if center_length > 0:
        draw_interval(center_length - 1)
        draw_line(center_length)
        draw_interval(center_length - 1)


def draw_ruler(num_inches, major_length):
    """Draw English ruler with given number of inches, major tick length"""
    draw_line(major_length, 'o')
    for j in range(1, 1 + num_inches):
        draw_interval(major_length - 1)
        draw_line(major_length, str(j))


def binary_search(data, target, low, high):
    """Return True if target is found in indicated portion of a list

    The search only considers the portion from data[low] to data[igh] inclusive
    """
    if low > high:
        return False
    else:
        mid = (low + high) // 2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            # recur on the portion left of the middle
            return binary_search(data, target, low, mid - 1)
        else:
            # recur on the portion right of the middle
            return binary_search(data, target, mid + 1, high)


def disk_usage(path):
    """return the number of bytes used by a file/folder and any descendants"""
    total = os.path.getsize(path)
    if os.path.isdir(path):
        for filename in os.listdir(path):
            childpath = os.path.join(path, filename)
            total += disk_usage(childpath)

    print('{0:<7}'.format(total), path)
    return total


def unique3(S, start, stop):
    """Return True if there are no duplicate elements in slice S[start:stop]"""
    if stop - start <= 1:
        return True
    elif not unique(S, start, stop - 1):
        return False
    elif not unique(S, start+1, stop):
        return False
    else:
        return S[start] != S[stop-1]


def bad_fibonacci(n):
    """Return the nth Fibonacci number"""
    if n <= 1:
        return n
    else:
        return bad_fibonacci(n-2) + bad_fibonacci(n-1)


def good_fibonacci(n):
    """Return pair of Fibonacci numbers, F(n) and F(n-1)"""
    if n <= 1:
        return (n, 0)
    else:
        (a, b) = good_fibonacci(n-1)
        return (a+b, a)


def linear_sum(S, n):
    """Return the sum of the first n numbers of a sequence S"""
    if n == 0:
        return 0
    else:
        return linear_sum(S, n-1) + S[n-1]


def reverse(S, start, stop):
    """Reverse elements in implicit slice S[start:stop]"""
    if start < stop - 1:
        S[start], S[stop - 1] = S[stop-1], S[start]
        reverse(S, start+1, stop-1)


def power(x, n):
    """Compute the value x**n for integer n"""
    if n == 0:
        return 1
    else:
        return x * power(x, n - 1)


def power2(x, n):
    """Compute the value x**n for integer n"""
    if n == 0:
        return 1
    else:
        partial = power2(x, n//2)
        result = partial * partial
        if n % 2 == 1:
            result *= x
        return result


def binary_sum(S, start, stop):
    """Return the sum of the numbers in implicit slice S[start:stop]"""
    if start >= stop:
        return 0
    elif start == stop-1:
        return S[start]
    else:
        mid = (start+stop)//2
        return binary_sum(S, start, mid) + binary_sum(S, mid, stop)


def binary_search_iterative(data, target):
    """Return True if target is found in the given list"""
    low = 0
    high = len(data)-1
    while low <= high:
        mid = (low+high) // 2
        if target == data[mid]:
            return True
        elif target < data[mid]:
            high = mid - 1
        else:
            low = mid+1
    return False


def reverse_iterative(S):
    """Reverse elements in sequence S"""
    start, stop = 0, len(S)
    while start < stop-1:
        S[start], S[stop-1] = S[stop-1], S[start]
        start, stop = start+1, stop-1
