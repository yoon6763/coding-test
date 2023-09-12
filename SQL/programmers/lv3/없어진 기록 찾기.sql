select animal_id, name
from animal_outs
where animal_id not in (select animal_id
                        from animal_ins)
                        
order by animal_id, name