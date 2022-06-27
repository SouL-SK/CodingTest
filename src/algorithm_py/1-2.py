s = input()

def solution(s):
    answer = 0
    list(s)

    if str(s[0]) == '-' or '+':
        answer += str(s[0])
    for i in range(len(s)):
        answer += str(s[i])
    return answer