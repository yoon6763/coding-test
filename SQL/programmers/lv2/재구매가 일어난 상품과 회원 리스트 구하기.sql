select user_id, product_id
from online_sale
group by product_id, user_id
having count(*) >= 2
order by user_id, product_id desc