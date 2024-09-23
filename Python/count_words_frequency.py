def count_words_frequency(input_string):
    words = input_string.split()
    word_frequency = {}

    for word in words:
        if word in word_frequency:
            word_frequency[word] += 1
        else:
            word_frequency[word] = 1

    return word_frequency


input_string = input("Enter a list of words separated by white-space: ")
word_frequency = count_words_frequency(input_string)

for word, frequency in word_frequency.items():
    print(f"'{word}' appears {frequency} time(s)")
