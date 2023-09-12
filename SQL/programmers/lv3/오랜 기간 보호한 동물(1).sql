select i.name, DATE_FORMAT(i.datetime, "%Y-%m-%d") as "datetime"
from animal_ins i
join animal_outs o
on i.animal_id = o.animal_id
where i not in (select animal_id
                from animal_outs)
order by datetime
limit 3