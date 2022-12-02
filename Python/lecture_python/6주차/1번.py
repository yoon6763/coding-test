import numpy as np
import random as rd

arr = np.empty((10, 10), int)

# axis = 0 행, axis = 1 열
for i in range(0, 10):
    arr[i] = np.array([rd.sample(range(1, 100), 10)])

print(arr)
print("최대값 : ", np.max(arr))
print("최소값 : ", np.min(arr))