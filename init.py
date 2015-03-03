# Fibonacci in Python as a function
def fib(n):
    a,b=0,1
    while (a < n):
        print(a,end=' ')
        a,b=b,a+b
    print()
#------------------------------------------------

def implementingenumerate() :
    a='hello'
    for i,j in enumerate(a):
        print(i,' ',j)
#-------------------------------------------------

#implementing else in for loop
def elseinaloop():
    for i in range(1,20):
        for j in range(2,i):
            if i%j == 0:
                print (i,' is not a prime number')
                break
            else:
                print (i,' is a prime number')
#---------------------------------------------------

#Read about Documentation Strings (Docstrings), global variables
'''In Python, all def <func name>() are functions, because they always a value
even without a return statement which is 'None'.
    As a result they can be assigned to any other function'''
f=fib
# --print (f(0)) will return None
# --Using this we can implement some functional programming concepts.
# --Example we can write a function to return list of n fibonacci numbers.
# --And then print as much needed, or assign to another function with a 
# fixed value. 
#----------------------------------------------------

def fib2(n):
    result = []
    a,b=0,1
    while a<n :
        result.append(a)
        a,b=b,a+b
    return result
f2 = fib2(100)
#for i in f2:
#   print( i )
#------------------------------------------------------

''' Some names in Python3 :
    1. ArithmeticError()
    2. Assertionerror()
    3. AttributeError()
    4. BaseException() 
    5. BlockingIOError()
    6. BrokenPipeError()
    7. BufferError()
    8. BytesWarning()
    9. ChildProcessError()
    10.ConnectionAbortedError()
    11.ConnectionError()
    12.ConnectionRefusedError()
    13.ConnectionResetError()
    14.DeprecationWarning()
    15.EOFError()
    16.Ellipsis
    17.EnvironmentError()
    18.Exception()
    19.False
    20.FileExistsError()
    21.FileNotFoundError()
    22.FloatingPointError()
    23.FutureWarning()
    24.GeneratorExit()
    25.IOError()
    26.ImportError()
    27.ImportWarning()
    28.IndentationError()
    29.IndexError()
    30.InterruptedError()
    31.IsADirectoryError()
    32.KeyError()
    33.KeyboardInterrupt()
    34.LookupError()
    35.MemoryError()
    37.36.NameError()
    38.None
    39.NotADirectoryError()
    40.NotImplemented
    41.NotImplementedError()
    42.OSError()
    43.OverflowError()
    44.PendingDeprecationWarning()
    45.PermissionError()
    46.ProcessLookupError()
    47.RefrenceError()
    48.ResourceWarning()
    49.RuntimeError()
    50.RuntimeWarning()
    51.StopIteration()
    52.SyntaxError()
    53.SytaxWarning()
    54.SystemWarning()
    55.SystemError()
    56.SystemExit()
    57.TabError()
    58.TimeoutError()
    59.True
    60.TypeError()
    61.UnboundLocalError()
    62.UnicodeDecodeError()
    63.UnicodeEncodeError()
    64.UnicodeError()
    65.UnicodeTranslateError()
    66.UnicodeWarning()
    67.UserWarning()
    68.ValueError()
    69.Warning()
    70.ZeroDivisionError()
    71._
    72.__build_class__()
    73.__debug__
    74.__doc__
    75.__import__()
    75.__loader__()
    76.__name__
    77.__package__
    78.__spec__
    79.abs()
    all()
    and
    any()
    as
    ascii()
    assert
    bin()
    bool()
    break
    bytearray()
    bytes()
    c
    callable()
    chr()
    class
    classmethod()
    compile()
    complex()
    continue
    copyright()
    credits()
    date()
    datetime
    def
    del
    delattr()
    dict()
    dir()
    divmod()
    elif
    else
    enumerate()
    eval()
    except
    exec()
    exit()
    filter()
    finally
    float()
    for
    format()
    from
    frozenset()
    getattr()
    global
    globals()
    hasattr()
    hash()
    help()
    hex()
    id()
    if
    import
    in
    input()
    int()
    is
    isinstance()
    issubclass()
    iter() : takes an iterable object and returns an iterator object.
             eg:    >>> x = iter([1, 2, 3])
                    >>> x
                    <listiterator object at 0x1004ca850>
    lambda
    len()
    liscence()
    list()
    locals()
    map()
    max()
    memoryview()
    min()
    next():     takes an iterator and returns the next value of it (the one after the last one called)
                eg.     next(..object..)
                The object is created by using the iter.
    nonlocal
    not
    now
    object()
    oct()
    open()
    or
    ord()
    pass
    pow()
    print()
    property()
    quit()
    raise
    range()
    repr()
    return
    reversed()
    round()
    set()
    setattr()
    slice()
    sorted()
    staticmethod()
    str()
    sum()
    super()
    try
    tuple()
    type()
    tz()
    vars()
    while
    with
    yield:  Used with generators to implement lazy-like function.
    zip():  zip(iterableobjects1,iterableobject2)=object(pairs till length of smaller list)


'''
# GOOD TO KNOW : Python checks if any new object refrence has same value as any previous object, and if yes
#           it assigns 



# Execution of a program introduces a new symbol table for local variables of the function.
# All variable assignments in a function store the value in the local symbol table.
# Variable refrences first look in the local symbol table, then in the local symbol 
#    tables of enclosing tables, then in the global symbol table, and finally in the built-in names.
# As a result the global variables cannot be assigned a value in the function but can be refrenced.
# Call by value - actual arguments are included in the local variable map when the function is called.
# >>>>>>Call by value - value is object refrence, not the value of the object.
# When a function calls another function then a new local symbol table is created for that call.
# Function definition inroduces the function in the current variable map.h



''' List operations:
* list.append(x) == a[len (a):][x]
* NOTE : >>> a=[...]
        >>> b=a
        >>> b is a
        True
    This implies that a list cannot be copied by assignment. Merely another refrence to the same pointer is declared.
    I think it means a and b are somehow the same. Although a and b are same, is a is assigned any other value which is
    not a list, then a and b becomes same.
* list.extend(L) == a[len(a) :]= L
* list.insert(i,x) == inserts x at i
    NOTE: If i exceeds the length of list, x is appended to the list.
* list.remove(x) == removes the firs x occuring in the list, error if no occurence
* list.pop(i <or no argument>) == removes and returns the the element at the ith position. If no argument is passed then it 
    returns the last element (last in first out).
* list.clear() == del a[:]






https://docs.python.org/2.7/reference/simple_stmts.html
https://stackoverflow.com/questions/102535/what-can-you-use-python-generator-functions-for
https://wiki.python.org/moin/Generators
https://stackoverflow.com/questions/231767/what-does-the-yield-keyword-do-in-python
https://groups.google.com/forum/?hl=fr#!topic/comp.lang.python/dIsnJ2BoBKs
http://anandology.com/python-practice-book/iterators.html
https://wiki.haskell.org/Monomorphism_restriction
Theory of Computation by Michael Sipser
