CREATE EXTENSION IF NOT EXISTS "pgcrypto";
CREATE TABLE users(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    name VARCHAR(20) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(20) NOT NULL,
    role VARCHAR(20)
);