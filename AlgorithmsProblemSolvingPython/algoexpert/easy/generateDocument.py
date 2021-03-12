def generateDocument(characters, document):
    charCount = {}

    for character in characters:
        if character not in charCount:
            charCount[character] = 0
        charCount[character] += 1

    for character in document:
        if character not in charCount or charCount[character] == 0:
            return False
        charCount[character] -= 1

    return True


if __name__ == "__main__":
    characters = "Bste!hetsi ogEAxpelrt x "
    document = "AlgoExpert is the Best!"

    print(generateDocument(characters, document))
