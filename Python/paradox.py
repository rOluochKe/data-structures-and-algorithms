import random


def has_same_birthday(n):
    birthdays = [random.randint(1, 365) for _ in range(n)]
    return len(birthdays) != len(set(birthdays))


for n in range(5, 101, 5):
    num_positive = sum([has_same_birthday(n) for _ in range(1000)])
    probability = num_positive / 1000
    print(f"For {n} people, probability of having the same birthday: {probability}")
