-- http://www.codechef.com/JULY15/problems/EGBOBRD

call' n _ [] _ = n
call' n p (x:xs) maxP
    | left > 0 = call' n (left - 1) xs maxP
    | left == 0 = call' check maxP xs maxP
    | left < 0 = call' (n+1) maxP ((x-p):xs) maxP
    where
        left =  p - x
        check = if xs == [] then n else n+1

call'' n _ [] _ = n
call'' n p (x:xs) maxP
    | left > 0 = call'' n (left - 1) xs maxP
    | left == 0 = if xs == [] then n else call'' (n+1) maxP xs maxP
    | left < 0 = call'' (n+1) maxP ((x-p):xs) maxP
    where
        left =  p - x
        check = if xs == [] then n else n+1

initialise = do
    nk <- getLine
    d <- getLine
    let maxP = (split nk)!!1
    putStrLn.show $ call'' 1 maxP (split d) maxP
    return ()

split nk = map (\x -> read x :: Int) (words nk)

main = do
    t <- getLine
    let test = read t :: Int
    sequence $ replicate test initialise
    return ()
