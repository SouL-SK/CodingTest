"""
A = str(input())
B = str(input())
# 얘는 왜 str로 못감싸?
#A, B = input().split()

result = [0, 0]

print(A, B)
# 스페이스로 구분된 숫자를 받으면 값이 안담김

#최솟값 구하기
for i in range(len(A)):
    if A[i] == 5 or 6:

        #str 로 감쌌는데 뭘 어떻게 더 str 로 하라는건지?
        #str(A.replace(A[i], 5))

        #후.. 'str' object does not support item assignment
        list(A)
        A[i] = '5'
        


for i in range(len(B)):
    if B[i] == 5 or 6:
        B[i] = 5
result[0] = A + B

# 최댓값 구하기
for i in range(len(A)):
    if A[i] == 5 or 6:
        A[i] = 6

for i in range(len(B)):
    if B[i] == 5 or 6:
        B[i] = 6

result[1] = A + B
print(result)
"""
#2트
a, b = input().split()
min = int(a.replace('6', '5')) + int(b.replace('6', '5'))
max = int(a.replace('5', '6')) + int(b.replace('5', '6'))
print(min, max)