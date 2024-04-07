def sumInRanges(arr, n, queries, q):
    ans = []
    s = []
    s1 = 0
    for i in range(0,n):
        s1 += arr[i]
        s.append(s1)

    for i in queries:
        left = i[0]
        right = i[1]
        
        if(left%n==0):
            a1 =  s[n-1] * (left//n)
        else:
            a1 =  s[n-1] * (left//n)
            a1 += s[left%n-1]

        if(right%n==0):
            a2 =  s[n-1] * (right//n)
        else:
            a2 =  s[n-1] * (right//n)
            a2 += s[right%n-1]

        if(left%n==0):
            
            ans.append(a2-a1)
        else:
            ans.append(a2-a1+arr[(left%n)-1]) 
    return ans



    
