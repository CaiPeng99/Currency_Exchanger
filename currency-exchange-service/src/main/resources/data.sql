-- insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
-- values(10001,'USD','CNY',7,'');
-- insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
-- values(10002,'USD','EUR',8,'');
-- insert into currency_exchange(id,currency_from,currency_to,conversion_multiple,environment)
-- values(10003,'USD','GBP',9,'');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment)
-- values(10001,'USD','INR',65,'');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment)
-- values(10002,'EUR','INR',75,'');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment)
-- values(10003,'AUD','INR',25,'');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment,country_in)
-- values(10001,'USD','INR',65,'','USA');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment,country_in)
-- values(10002,'EUR','INR',75,'','EU');
-- insert into currency_exchange
-- (id,currency_from,currency_to,conversion_multiple,environment,country_in)
-- values(10003,'AUD','INR',25,'','Australia');
--
-- UPDATE currency_exchange SET country_in = 'USA' WHERE id = 10001;
-- UPDATE currency_exchange SET country_in = 'EU' WHERE id = 10002;
-- UPDATE currency_exchange SET country_in = 'Australia' WHERE id = 10003;

INSERT INTO currency_exchange
(id, currency_from, currency_to, conversion_multiple, environment, in_country)
VALUES
    (10001, 'USD', 'INR', 65, '', 'USA'),
    (10002, 'EUR', 'INR', 75, '', 'EU'),
    (10003, 'AUD', 'INR', 25, '', 'Australia');
