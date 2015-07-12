-- http://www.codechef.com/JULY15/problems/CHCUBE
level1 xs = doTill ((==) True) $ map (level2 xs) [4,5]
    where level2 xs n = doTill ((==) True) $ map (\x -> (f xs x n) && (level3 xs n)) [2,3]
          level3 xs n = doTill ((==) True) $ map (\x -> f xs x n) [0,1]
          f xs x n = xs!!n == xs!!x
          doTill _ [] = False
          doTill f (x:xs)
            | f x = True
            | otherwise = doTill f xs
-- author @ shivam-flash
initialise = do
    xs <- getLine
    if level1.words $ xs then do
        putStrLn "YES"
    else putStrLn "NO"
    return ()

main = do
    t <- getLine
    let test  = read t :: Int
    sequence $ replicate test initialise
    return ()
