import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
from matplotlib import font_manager, rc

fontPath = "./SCDream4.otf"  # font path
fontName = font_manager.FontProperties(fname=fontPath).get_name()
rc('font', family=fontName)

# Mac OS font 직접 삽입
# rc('font', family='AppleGothic')
df = pd.DataFrame(np.random.rand(50, 4),
                  columns=['a', 'b', 'c', 'd'])
tdf = df.transpose()
aloc = tdf.loc['a']
plt.style.use('Solarize_Light2')  # 스타일 지정

plt.figure(figsize=(14, 5))  # 가로 14인치, 세로 5인치
# 생성하기 전에 선언
plt.plot(aloc.index, aloc.values, marker='o', markersize=10)

plt.title("랜덤 값 그래프")  # title
plt.xlabel("x축 값")  # xlabel
plt.ylabel("y축 값")  # ylabel

plt.xticks(rotation=45)  # x축 눈금 라벨 회전
plt.legend(labels=['랜덤 값'], loc='best')  # 범례

plt.ylim(0, 2.0)  # y 축 범위 지정
plt.annotate('',
             xy=(10, 1.5),
             xytext=(0, 1.25),
             xycoords='data',
             arrowprops=dict(arrowstyle='->', color='skyblue', lw=5),
             )
plt.annotate('랜덤 값들',
             xy=(5, 1.25),
             rotation=25,
             va='baseline',
             ha='center',
             fontsize=15,
             )

plt.show()
