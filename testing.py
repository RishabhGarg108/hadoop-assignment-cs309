f = open("input/data.txt", "r")
#mapper
dict_ = {}
for i in range(1, 6):
    dict_["class" + str(i) + ","] = []
for i in f:
    s = list(i.split())
    count = 0
    sum_ = 0
    for j in range(1,len(s)):
        count += 1
        sum_ += int(s[j])
    if (count <= 10):
        dict_["class1,"].append(sum_)
    elif (count <= 20):
        dict_["class2,"].append(sum_)
    elif (count <= 30):
        dict_["class3,"].append(sum_)
    elif (count <= 40):
        dict_["class4,"].append(sum_)
    else:
        dict_["class5,"].append(sum_)

f.close()

#reducer
dict_1 = {}
for i in dict_.keys():
    dict_1[i] = sum(dict_[i])

for k, v in dict_1.items():
    print(k, v)

