select car.id as id1, car_.make as make, car.model as model, car0_.price as
price, car.year as year from car car where upper(car.model)=upper('86')