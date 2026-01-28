CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE TABLE providedService(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200) NOT NULL,
    status VARCHAR(20) NOT NULL,
    startdate DATE,
    enddate DATE,
    client_id UUID REFERENCES users(id),
    provider_id UUID REFERENCES provider(id),
    amount DECIMAL(10,2),
    payment_id UUID REFERENCES payment(id)
)