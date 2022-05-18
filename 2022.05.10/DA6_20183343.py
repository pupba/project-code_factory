# 과제명:  데이터분석 과제6  - 필터링, 열 재배열, 시간값 행 인덱스

import pandas as pd

AIS_RAW = pd.read_csv('2017_10_07_AIS_RAW_5to6.csv')
df = pd.DataFrame(AIS_RAW)
print(df, end='\n\n')
print(df.info(), end='\n\n')
print(df.describe(), end='\n\n')

mask1 = df.SOG > 0
df_upper0 = df.loc[mask1, :]
print(df_upper0)

mask2 = (0 < df_upper0.HDG) & (df_upper0.HDG < 360)
df_hdg_0_360 = df_upper0.loc[mask2, :]


df_hdg_0_360['Date'] = df_hdg_0_360['Date'].astype('str')
df_hdg_0_360['Time'] = df_hdg_0_360['Time'].astype('str')

datetime = pd.to_datetime(df_hdg_0_360['Date'] + " " + df_hdg_0_360['Time'])
df_hdg_0_360['DateTime'] = datetime

df_hdg_0_360.drop(['Date', 'Time'], axis=1, inplace=True)
df_hdg_0_360 = df_hdg_0_360[['DateTime', 'MMSI',
                            'Longitude', 'Latitude', 'SOG', 'COG', 'HDG']]
df_hdg_0_360.set_index('DateTime', inplace=True)
print(df_hdg_0_360)
