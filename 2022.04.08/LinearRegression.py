# 사이킷런의 Linear-Regression 불러오기
# 사이킷런 패키지의 linear_model 모듈의 LinearRegression 클래스 가져옴
from sklearn.linear_model import LinearRegression
# 사이킷런 패키지의 datasets 모듈의 load_boston 클래스 가져옴
from sklearn.datasets import load_boston

# 데이터 로드
boston = load_boston()
features = boston.data[:,0:2] # 두개의 특성만 선택
target = boston.target # target data

# 선형 회귀 모델 생성
LR = LinearRegression()
# 모델 훈련
model = LR.fit(features,target)

print("bias :",model.intercept_)
print("weight : ",model.coef_ )
print("target value[0]:",target[0]*1000)
print("predict value[0]:",model.predict(features)[0]*1000)
print("인구당 범죄율 1만큼 증가 될때 주택 가격 변화 ---> ",model.coef_[0]*1000)
