DROP DATABASE IF EXISTS amazon_books_db;
CREATE DATABASE IF NOT EXISTS amazon_books_db;
USE amazon_books_db;

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255),
    language VARCHAR(50),
    isbn VARCHAR(13),
    price DECIMAL(10,2) NOT NULL,
    amazon_url VARCHAR(500) NOT NULL,
    image_url VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    INDEX idx_title (title),
    INDEX idx_author (author),
    INDEX idx_isbn (isbn)
);
