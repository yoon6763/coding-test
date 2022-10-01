st = input()
for i in ['dz=','c=','c-','d-','lj','nj','s=','z=',]:
    st = st.replace(i,"a")
print(len(st))