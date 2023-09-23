select concat("/home/grep/src/",b.board_id,"/",file_id,file_name,file_ext) as file_path
from used_goods_file f
join used_goods_board b on f.board_id = b.board_id
where b.views = (select views from used_goods_board order by views desc limit 1)
order by file_id desc