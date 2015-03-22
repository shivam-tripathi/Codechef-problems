t=int(input())
for j in range(t):
	s=input()
	l=len(s)
	p1='+_'*l
	p2='-+'*l
	c1=0
	c2=0
	for i in range (l):
		if s[i]!=p1[i]:
			c1+=1
		if s[i]!=p2[i]:
			c2+=1
	if c1<c2:
		print(c1)
	else:
		print(c2)
