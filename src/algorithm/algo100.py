n = int(input())
if n == 12 or n == 1 or n == 2:
    print("winter")
elif n // 3 == 1:
    print("spring")
elif n // 6 == 1:
    print("summer")
elif n // 9 == 1 and n != 12:
    print("fall")
else:
    print("None")