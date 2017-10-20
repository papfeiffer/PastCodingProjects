# coding=utf-8


# Q0

# Gives the maximum number of anagrams in a list. For example, the first list (words) has a maximum
# anagram count of 3.

words = ["disease", "burned", "viewer", "Praised", "despair", "burden", "diapers", "review"]
words2 = ["car", "arc", "bat"]
words3 = ["bat", "jet", "island"]
words4 = ["AAAAAA", "BBBBB", "CCCCCCC"]
words5 = ["anagram"]
words6 = ["anagram", "AnAgRaM", "ANAGRAM"]


def countAnagrams(words):

    letter_lists = []  # Holds sets of alphabetized letters for each word
    wordCounts = []  # Holds # of times a set of equivalent letters occurs for each word
    lowerCasewords = []  # Holds words converted to lowercase

    for diffWords in words:  # For each word in a given list of words...
        lowerCasewords.append(diffWords.lower())  # ...Make each word lowercase

    for word in lowerCasewords:  # Now loop through your lowercase words
        sortedWord = sorted(word)  # Sorts each word's letters alphabetically and puts it in a list
        letter_lists.append(sortedWord)  # This list is then added within a list to create a list of lists

    for letter in letter_lists:  # Now loop through the lists of letters that you've sorted
        wordCount = letter_lists.count(letter)  # Counts occurrences of a certain letter list for each word
        wordCounts.append(wordCount)  # Each word gets a count of how many times its letter list appears
        # in letter_lists

    print max(wordCounts)  # Print the maximum amount of anagrams possible in the list


countAnagrams(words)
countAnagrams(words2)
countAnagrams(words3)
countAnagrams(words4)
countAnagrams(words5)
countAnagrams(words6)



# Q1
# Generates word sequences based on number input. For example, if the number passed into wordSequences
# is 2, the output would be ['the quick', quick brown', 'brown fox', 'fox jumped'].

phrase = ["the quick brown fox jumped"]


def wordSequences(phrase, num):
    # len(sepWords) = 5
    sepWords = phrase[0].split()  # Separate words so each has its own array index
                                  # ["the", "quick", "brown", "fox", "jumped"]
    if num > len(sepWords):  # If k is greater than the number of words in a sentence...
        return []            # Return an empty list

    string_list = []  # Where newly formed phrases go (they depend on k)

    for word_place in range(len(sepWords)):  # For each word in sepWords...
        newPhrase = ""                       # ...start with a completely empty phrase

        for n in range(num):  # Go thru this loop k times
            if (word_place + n) < len(sepWords):         # (A word's place + n) cannot be more than the number of words total
                newPhrase += (sepWords[word_place + n])  # Add the next word to the phrase k times
                if n < (num - 1):                        # last loop for given word_place if n == num
                    newPhrase += " "                     # Want to make sure a space is added after each word
        if ((word_place + num) - 1) < len(sepWords):     # (A word's place + n) cannot be more than the number of words total
            string_list.append(newPhrase)                # add newPhrase to the list of newPhrases

    return string_list


print "For k = 0"
print wordSequences(phrase, 0)
print "For k = 1"
print wordSequences(phrase, 1)
print "For k = 2"
print wordSequences(phrase, 2)
print "For k = 3"
print wordSequences(phrase, 3)
print "For k = 4"
print wordSequences(phrase, 4)
print "For k = 6"
print wordSequences(phrase, 6)


# Q2
# Function must work recursively--function references itself
# Convert string to characters

a_string = "the quick brown fox jumped"
a_string2 = "THE QUICK BROWN FOX JUMPED"
a_string3 = "The QUiCk browN foX JUMpEd"
a_string4 = "the quick"
query = "quick"
query2 = "asdfkjh"
query3 = "QUICK"
query4 = "k brown fo"
query5 = "the quick brown fox jumped over"


def contains(a_string, query):
    if (a_string is None or query is None):  # a_string and query must be valid
        return False
    elif (len(query) < 0 & len(a_string) < 0):  # lengths of string or query cannot be negative
        return False
    elif (len(query) < 0 & len(a_string) > 0):
        return False
    elif (len(query) > 0 & len(a_string) < 0):
        return False
    elif (len(query) > len(a_string)):  # query cannot be longer than the searched string
        return False
    elif a_string == query:  # If the string is equal what's being searched, return True
        return True
    elif a_string[len(a_string) - len(query):] == query:  # If..the string starting at this index to the end of the string
        return True                                       # matches the query, return True
    else:
        a_string = a_string[:len(a_string) - 1]  # A character is removed from the end of the string
    return contains(a_string, query)             # Pass the shortened string to contains function




print(contains(a_string, query))
print(contains(a_string, query4))
print(contains(a_string, query2))
print(contains(a_string2, query))
print(contains(a_string2, query3))
print(contains(a_string3, query3))
print(contains(a_string, query5))
print(contains(a_string4, query4))
