# http://www.codechef.com/JULY15/problems/EGBOBRD
# author @shivamflash
test=raw_input()
for i in range(int(test)):
    n,k = map(int, raw_input().split())
    diet = map(int, raw_input().split())
    count=0
    for i in diet:
        count = count + i
        flag = 0
        if count % k != 0:
            flag = 1
            count += 1
    if flag == 1:
        count -= 1
    print (count + k - 1) / k
