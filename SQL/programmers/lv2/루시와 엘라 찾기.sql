-- 코드를 입력하세요
SELECT ANIMAL_ID,NAME,SEX_UPON_INTAKE FROM ANIMAL_INS
WHERE NAME = "Lucy" or NAME = "Ella" or NAME = "Pickle" or NAME = "Rogan" or NAME = "Sabrina"
or NAME = "Mitty"
order by ANIMAL_ID