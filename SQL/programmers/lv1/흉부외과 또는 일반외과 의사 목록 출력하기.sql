select dr_name, dr_id, mcdp_cd, date_format(hire_ymd, "%Y-%m-%d") as HIRE_YMD
from doctor
where mcdp_cd = 'CS' or mcdp_cd = 'GS'
order by hire_ymd desc, dr_name