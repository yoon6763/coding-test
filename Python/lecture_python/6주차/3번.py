import numpy as np

def nearst_value(X, target):
    arr2 = np.abs(X - target)
    return X[np.where(arr2 == np.min(arr2))]


X = np.array([1, 2, 3, 4, 5, 6, 7])
target = 4.3

print("가장 인접한 값 :",nearst_value(X, target))