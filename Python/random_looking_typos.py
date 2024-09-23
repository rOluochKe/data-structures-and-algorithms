import random

sentence = "I will never spam my friends again."

typos = ['will', 'never', 'spam', 'friends', 'again', 'I', 'my', 'out']

for i in range(1, 101):
    if i % 10 == 0:
        typo_index = random.randint(0, 7)
        typo_word = typos[typo_index]
        print(f"{i}. I wlll nveer spam my freinds agian.")
    else:
        print(f"{i}. {sentence}")
