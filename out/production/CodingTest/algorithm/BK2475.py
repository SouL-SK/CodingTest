def fun_double(n):
    result = n*n
    return result

#a, b, c, d, e = map(int, input().split())
nums = map(int, input().split())
sum = list(map(fun_double,nums))
result = 0
for i in range(len(sum)):
    result += sum[i]
result = result%10
print(result)