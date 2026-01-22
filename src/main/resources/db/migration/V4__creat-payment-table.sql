CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE payment(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    payment_method VARCHAR(50),
    payment_status VARCHAR(50),
    payment_date DATE
)