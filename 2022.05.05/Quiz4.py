try:
    # print(100/0) << 사용 가능
    raise ZeroDivisionError
except ZeroDivisionError as zd:
    print("0으로 나눌수 없습니다.")
