#http://www.codechef.com/JUNE15/problems/CHPLGNS @shivamflash

'''
Funtion area_func calculates the area of any non-intersecting polygon.
It needs vertices in counterclockwise order, if given in clockwise
direction, it will give negative area.
The formula used uses 2x2 determinant to be solved for every following
vertex, last one having first vertex as the other vertex.
'''

def area_func(vertices):
    area = 0
    l = len(vertices)
    for i in range(l-1):
        one = vertices[i][0]*vertices[i+1][1]
        two = vertices[i][1]*vertices[i+1][0]
        area += (one - two) #shivamflash
    one = vertices[l-1][0]*vertices[0][1]
    two = vertices[l-1][1]*vertices[0][0]
    area += (one - two)
    if area < 0 :
        area *= -1
    return (area/2.0)


'''
For every polygon in every test case, we calculate the area, and save it
in a array. As no two polygons can have same area, we save the position
of every area in a dictionary.
#shivamflash
Now, after sorting the array, we get the number of polygons inside a polygon
of particular area equal to the index (smallest will get the zero index
and so on).
We make another array/dictionary, to store the answer. To get the position
of area, we use the pos array. In this position of answer array/dictionary,
we save the index of sorted array.
Print this array/dictionary.
'''


#@shivamflash
t = int(raw_input())
for test in range(t):
    num_polygons = int(raw_input())
    pos = {}
    #@shivamflash
    areas = []
    for i in range(num_polygons):
        num_sides = int(input())
        all_vertices = map(int, raw_input().split())
        vertices = []
        for j in range(num_sides):
            vertices.append((all_vertices[2*j], all_vertices[2*j+1]))
        area = area_func(vertices)
        pos[area] = i
        areas.append(area)

    #@shivamflash
    areas.sort()
    ans = {}
    for i in range(len(areas)):
        ans[pos[areas[i]]] = i
    a = '' #shivamflash
    for i in range(len(ans)):
        a += str(ans[i])+' '
    print a
