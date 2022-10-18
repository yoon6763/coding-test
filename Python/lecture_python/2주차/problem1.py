import os

fileList = os.listdir(".")

for f in fileList:
    if os.path.isdir(f):
        print("폴더: {0}".format(f))
    else:
        print("파일: {0}".format(f))
