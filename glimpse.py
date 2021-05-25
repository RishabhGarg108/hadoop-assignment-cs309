filename = 'input/data.txt'

with open(filename, 'r') as f:
    for i in range(10):
        print(f.readline())
