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

index :: int-> int -> int
index h l = div (add h l) 2

add :: int-> int -> int
add m n = m+n 


binSearch :: [Int] -> Int -> Int -> Int -> Bool
binSearch [] _ _ _ = False
binSearch li h l e |  h<l  = False | otherwise = find(li h l e)

find :: [Int] -> Int -> Int -> Int -> Bool
find li h l e   |  (li!!(index h l) == e) = False
                |  li!!(index h l) < e = (binSearch li ((index h l)-1) l e )
                |  li!!(index h l) > e = (binSearch li h ((index h l)+1) e)
