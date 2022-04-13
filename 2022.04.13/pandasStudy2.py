import pandas as pd


def avg(list1):
    avg = [n/5 for n in list1]
    return avg


df = pd.DataFrame({'이름': ['서준', '우현', '인아'],
                  '수학': [90, 80, 70],
                   '영어': [98, 89, 95],
                   '음악': [85, 95, 100],
                   '체육': [100, 90, 90]})
df.set_index('이름', inplace=True)

sumAll = []
for name in df.index:
    sum = 0
    for score in list(df.loc[name]):
        sum += score
    sumAll.append(sum)
df['총점'] = sumAll
df['평균'] = avg(sumAll)
print(df)
print("\n")

subjectSum = [df[n].sum(axis=0) for n in df.columns]  # 열 합계
df.loc['평균'] = subjectSum
print(df)
print('\n')

df.to_excel('./to_excel_20183343.xlsx', index=False)
df.to_csv('./to_csv_20183343.csv', index=False)
df.to_json('./to_json_20183343.json')
print("\nexcel->")
print(pd.read_excel("./to_excel_20183343.xlsx"), end='\n')
print("\ncsv->")
print(pd.read_csv("./to_csv_20183343.csv"), end='\n')
print("\njson->")
print(pd.read_json("./to_json_20183343.json"), end='\n')
