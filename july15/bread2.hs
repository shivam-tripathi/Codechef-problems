bread n _ _ [] = n
bread n c mP (x:xs) = bread (n + increment) carry mP xs
    where
        increment = if left == 0 then inc else inc + 1
        left = (x - c) - (mP * inc)
        inc = div (x - c) mP
        carry = if left /= 0 then if (sub > 1) then (sub -1) else 0 else 0
        sub = mP - left

initialise = do
    nk <- getLine
    d <- getLine
    let mP = (split nk)!!1
    putStrLn.show $ bread 0 0 mP (split d)
    return ()

split nk = map (\x -> read x :: Int) (words nk)

main = do
    t <- getLine
    let test = read t :: Int
    sequence $ replicate test initialise
    return ()
