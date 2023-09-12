line = input().strip().split("|")

ade_minor = ['A', 'D', 'E']
cfg_major = ['C', 'F', 'G']

ade_minor_cnt = 0
cfg_major_cnt = 0

# 음조는 가장조와 다장조 두 가지만 입력으로 주어지는 것이 아니므로 if - else 로 하면 안됨
for i in line:
    if i[0] in ade_minor:
        ade_minor_cnt += 1
    if i[0] in cfg_major:
        cfg_major_cnt += 1

# 가단조 ade -> minor
# 다장조 cfg -> major
if ade_minor_cnt == cfg_major_cnt:
    if line[-1][-1] in cfg_major:
        cfg_major_cnt += 1
    if line[-1][-1] in ade_minor:
        ade_minor_cnt += 1

if ade_minor_cnt < cfg_major_cnt:
    print("C-major")
else:
    print("A-minor")
