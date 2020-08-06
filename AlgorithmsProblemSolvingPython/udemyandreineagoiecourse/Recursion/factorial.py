def find_factorial(number):
    if number == 0:
        return 1
    
    return number * find_factorial(number - 1)

print(find_factorial(5))