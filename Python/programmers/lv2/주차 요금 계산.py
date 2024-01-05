import math

def solution(fees, records):
    (basic_min, basic_fee, unit_min, unit_fee) = fees

    record_dict = {}
    parking_dict = {}

    for record in records:
        (time, car_id, io) = record.split(" ")
        (hour, minute) = map(int, time.split(":"))
        min = hour * 60 + minute

        if io == "IN":
            record_dict[car_id] = min
        else:
            parking_dict[car_id] = parking_dict.get(car_id, 0) + min - record_dict[car_id]
            del record_dict[car_id]

    max_time = 23 * 60 + 59

    for (car_id, min) in record_dict.items():
        parking_dict[car_id] = parking_dict.get(car_id, 0) + max_time - min

    for (car_id, min) in parking_dict.items():
        fee = basic_fee
        min -= basic_min
        if min > 0:
            fee += math.ceil(min / unit_min) * unit_fee
        parking_dict[car_id] = fee

    return [parking_dict[car_id] for car_id in sorted(parking_dict.keys())]
