select p.product_code,
        count(*) * p.price as sales
from product p
join offline_sale o
on p.product_id = o.product_id
group by p.product_code
order by sales desc, p.product_code