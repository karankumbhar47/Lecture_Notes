from sklearn.linear_model import LinearRegression
import pandas as pd

df = pd.read_csv("/home/manjaro/coding/Python/MachineLearning/CS550/Labs_M23/MaterialStrength_Train.csv")
print(df)

# lin_reg = LinearRegression()
# lin_reg.fit(X, y)
# lin_reg.intercept_, lin_reg.coef_