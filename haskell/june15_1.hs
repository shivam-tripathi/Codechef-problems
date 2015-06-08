{--

Input ::
    Test Cases (T)
        Number of measurements (N)
            N space separated file sizes (M)

@shivamflash

Instructions #1 (Beta)
Please before copying, read this. Maybe, it might help you. :)
1. Initialise the answer with the first file's size.
2. If the following file's size is more, then add the difference.
3. If the following file's size is less or equal, then add nothing.
4. Please don't cheat.@shivamflash

--}

main = do
    t <- getLine
    let test = read t :: Int
    sequence $ replicate test initialise
    return ()

-- @shivamflash

initialise = do
    numOfFiles <- getLine
    allSizes <- getLine
    let sizes = map (\x -> read x :: Integer ) (words allSizes)
    print (sizes!!0 + sol sizes)

-- @shivamflash

sol :: [Integer] -> Integer
sol (x:[]) = 0
sol (x:y:xs) = if (y>x) then ((y-x) + sol (y:xs)) else sol (y:xs)

-- @shivamflash
