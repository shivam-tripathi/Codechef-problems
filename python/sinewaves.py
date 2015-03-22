test = int(input())
ideal1 = 'BG' * (50001)
ideal2 = 'GB' * (50001)
for i in range(test):
	typ = int(input())
	s = list(input())
	l = len(s)
	counter1 = 0
	counter2 = 0
	index1 = 0
	index2 = 0
	flag1 = False
	flag2 = False
	for k in range(l):

		if (s[k] != (ideal1[k])):
			if (not flag1):
				flag1 = True
				index1 = k
			
			else:
				flag1 = False
				counter1 += ( k - index1) ** typ

		if (s[k] != ideal2[k]):
			if (not flag2):
				flag2 = True
				index2 = k
			
			else:
				flag2 = False
				counter2 += (k - index2) ** typ

	if (flag1 == True and flag2 == True):
		print(-1)
	elif (flag1 == False and flag2 == False):
		if (counter1 > counter2):
			print(counter2)
		else:
			print(counter1)
	elif (flag1 == True):
		print(counter2)
	elif (flag2 == True):
		print(counter1)
	


#nautilus-connect-server