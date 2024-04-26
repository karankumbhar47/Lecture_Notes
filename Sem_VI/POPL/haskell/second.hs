--  map , filter --> list method
--  list comprehension

-- ************ Map **************
sqr :: Int -> Int
sqr x = x*x


squareAll :: [Int] -> [Int]
squareAll [] = []
squareAll (x:y) = sqr(x) : (squareAll y)
-- squareAll x = map sqr x
-- squareAll = map sqr

--  (first element : second element)
--  first element is may be int or list also 


-- ************ filter **************
isEven :: Int -> Bool
isEven x = (mod x 2 == 0)


evenFilter :: [Int] -> [Int]
-- evenFilter [] = []
-- evenFilter (x:y)    | (mod x 2) ==0 = x:(evenFilter y)
--                     | otherwise  = (evenFilter y)
evenFilter = filter isEven


evenSquare :: Int -> [Int]
evenSquare n = [x*x | x <- [1..n], isEven x]


-- ************* prime number *************
divisors :: Int -> [Int]
-- divisors n = [m | m <- [2..(n-1)], mod n m ==0]
divisors n = [m | m <- [1..n], mod n m ==0] -- not works for 1


-- prime number
isPrime :: Int -> Bool
isPrime n = (divisors n == []) 

