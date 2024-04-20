--  list calling in list comprehension

--  merge sort

-- merge :: [Int] -> [Int] -> [Int]
merge [] ys = ys
merge xs [] = xs
merge (x:xs) (y:ys) | x<=y = x:(merge xs (y:ys))
                    | otherwise = y:(merge (x:xs) ys)

-- mergeSort :: [Int] -> [Int]
mergeSort [] = []
mergeSort [x] = [x]
mergeSort l = merge (mergeSort (front l)) (mergeSort  (back l))
    where 
        front l = take (div (length l) 2) l
        back  l = drop (div (length l) 2) l

-- front and back giving first and last half of list


--  insertion sort 
insertionSort [] = []
insertionSort (x:xs) = insert x (insertionSort xs)
    where
        insert x [] = [x]
        insert x (y:l)  | x<=y  = x:y:l
                        | otherwise = y: (insert x l)

-- haskell do lazy evaluation
