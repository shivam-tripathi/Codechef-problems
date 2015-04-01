test = int(input())
a = [input() for i in range(test)]
a.sort()
f = 0
for i in range(test):
	for j in range(i+1,test):
		if a[j].startswith(a[i]):
			f = 1
			break
if f == 0:
	print("non vulnerable")
else:
	print("vulnerable")

