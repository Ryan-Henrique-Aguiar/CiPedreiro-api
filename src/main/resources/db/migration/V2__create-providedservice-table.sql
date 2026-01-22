CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE TABLE providedService(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    description VARCHAR(200) NOT NULL,
    status VARCHAR(20) NOT NULL,
    stardate DATE not null,
    enddate DATE not null,
    client_id UUID REFERENCES users(id),
    amount DECIMAL(10,2)
)