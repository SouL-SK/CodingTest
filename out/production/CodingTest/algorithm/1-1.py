#d = [1, 3, 2, 5, 4]
#budget = 9

d = [2, 2, 3, 3]
budget = 10
count = 0   
def solution(d, budget):
    answer = 0

    recur(d, count, budget)
    
    return answer

def recur(d, count, budget):
    if d[count] >= budget:
        budget -= d[count]
        count += 1
        
    elif d[count] < budget:
        count += 1

    