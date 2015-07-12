
array :: [Int] -> Int -> (Int, Bool)
array xs k = foldl (\acc x -> if mod (x + fst acc) k /= 0 then ((x + fst acc), True) else ((x + fst acc), False)) (0, False) xs

ans xs k = if bool then ans - 1 else ans
    where bool = snd seq
          ans = fst seq
          seq = array xs k

initialise = do
    nk <- getLine
    d <- getLine
    let k = (split nk)!!1
    putStrLn.show $ div ((ans (split d) k) + k - 1) k
    return ()

split nk = map (\x -> read x :: Int) (words nk)

main = do
    t <- getLine
    let test = read t :: Int
    sequence $ replicate test initialise
    return ()
