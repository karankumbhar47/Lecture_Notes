def minimize_max_element(N, A, M, L):
    def apply_operation(A, start, end):
        for i in range(start, end + 1):
            A[i] -= 1

    def find_max_subarray(A, L):
        
        max_val = max(A)
        for i in range(N):
            if A[i] == max_val:
                end = min(i + L - 1, N - 1)
                return i, end

    for _ in range(M):
        start, end = find_max_subarray(A, L)
        apply_operation(A, start, end)
        if max(A) == min(A):
            break  

    return max(A)


for _ in range(int(input())):
    n = int(input())
    m = int(input())
    l = int(input())
    arr = list(map(int, input().split()))
    print(minimize_max_element(n,arr,m,l))
