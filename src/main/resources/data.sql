INSERT INTO COMMON_CODE (code_div, code_key, code_val)
VALUES
    ('DELIVERY_STATUS', 'READY', '배달섭외중'),
    ('DELIVERY_STATUS', 'OPERATE', '배달중'),
    ('DELIVERY_STATUS', 'COMPLETE', '배달완료'),
    ('DELIVERY_STATUS', 'CANCEL', '배달취소');


INSERT INTO AGENCY (name, address)
VALUES
    ('A업체', '서울시 A구 A동 AAA'),
    ('B업체', '서울시 B구 B동 BBB'),
    ('C업체', '서울시 C구 C동 CCC'),
    ('D업체', '서울시 D구 D동 DDD'),
    ('E업체', '서울시 E구 E동 EEE');

INSERT INTO ITEM (agency_pk, name, price)
VALUES
    (1, '라면', 3000),
    (1, '김밥', 4000),
    (1, '초밥', 5000),
    (2, '양념치킨', 1000),
    (2, '후라이드치킨', 2000),
    (2, '닭강정', 5000),
    (3, '콤비네이션피자', 1234),
    (3, '고구마피자', 5555),
    (3, '치즈피자', 6666),
    (4, '연어초밥', 5000),
    (4, '광어초밥', 3400),
    (4, '참치초밥', 2500),
    (5, '돼지고기', 1150),
    (5, '소고기', 2350),
    (5, '닭고기', 1000);