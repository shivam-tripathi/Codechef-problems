-- http://www.codechef.com/JULY15/problems/LCKYST

sol x
    | mod x 5 /= 0 = 0
    | otherwise = 1 + (sol (div x 5))

trim x
    | mod x 5 == 0 && mod x 2 == 0 = trim (div x 10)
    | otherwise = x

ceil x = ceiling (x/2)

initialise :: (Integral b) => b -> b
initialise x = 4 ^ (ceil.sol.trim $ x) * x

main = do
    t <- getLine
    q <- getLine
    let queries = map (\x -> read x :: Integer) (words q)
    mapM_ (putStrLn.show $) (map initialise queries)
    return ()

