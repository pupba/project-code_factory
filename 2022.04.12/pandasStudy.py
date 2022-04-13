import pandas as pd

def avg(list1):
    avg = [n/5 for n in list1]
    return avg

df = pd.DataFrame({"이름":['서준','우현','인아'],
                  '수학':[90,80,70],
                  '영어':[98,89,95],
                  '음악':[85,95,100],
                  '체육':[100,90,90],
                  '국어':[80,80,80]})

sumAll = []
for i in range(3):
    sum = 0
    for j in list(df.loc[i]):
        if type(j) != type("a"):
            sum += j
    sumAll.append(sum)
    
df['총점'] = sumAll
df['평균'] = avg(sumAll)

print(df.set_index('이름'))

df.to_excel('./to_excel_20183343.xlsx',index=False)
df.to_csv('./to_csv_20183343.csv',index=False, encoding = 'euc-kr')
df.to_json('./to_json_20183343.json')
