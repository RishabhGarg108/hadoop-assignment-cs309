import random

filename = "input/data.txt"
n = 1000000

with open(filename, 'w') as f:
    for idx in range(1, n + 1):
        row = [str(idx) + ":"]
        numItems = random.randint(1, 50)
        
        for k in range(numItems):
            price = random.randint(100, 5000)
            row.append(str(price))
        f.write(' '.join(row) + '\n')

        if (idx % 10000 == 0):
            print(idx)
