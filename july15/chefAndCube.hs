indexes :: [[Int]]
indexes = forodd . map (helper $) $ [0, 2, 4]
    where helper x = map (\y -> mod (x+y) 6) [2 .. 5]
          forodd xs = foldr (\x acc -> x:x:acc) [] xs


checker :: [String] -> Int -> Bool
checker _ 6 = False
checker xs n
    | (helper n xs) >=2 = True
    | otherwise = checker xs (n+1)
    where
        helper n xs = sum.map (folder xs) $ (indexes!!n)
        folder xs y = if (xs!!n) == (xs!!y) then 1 else 0

sol :: [String] -> Bool
sol xs = checker xs 0

initialise = do
    xs <- getLine
    if sol.words $ xs then do
        putStrLn "YES"
    else putStrLn "NO"
    return ()

main = do
    t <- getLine
    let test  = read t :: Int
    sequence $ replicate test initialise
    return ()


