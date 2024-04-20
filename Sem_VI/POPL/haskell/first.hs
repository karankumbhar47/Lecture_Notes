fact :: Int -> Int
fact 0 = 1
fact n  | n > 0 = n * (fact (n - 1))
        | n < 0 = fact(-n) 

addition :: Int -> Int -> Int
addition  m n = m + n 

xor :: Bool -> Bool -> Bool 
xor True False = True
xor False True = True
xor _ _ = False 

len :: [Int] -> Int
len [] = 0 
len (x:xs) = 1 + (len xs) 

--  string list of char
lenChar :: [Char] -> Int
lenChar [] = 0 
lenChar (x:xs) = 1 + (lenChar xs) 

rev :: [Int] -> [Int]
rev [] = [] 
rev (x:xs) = (rev xs) ++ [x]

-- memorization will be implemented already

