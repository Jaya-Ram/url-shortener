# URL Shortener

A simple URL Shortener application built using Java and Spring Boot.  
It converts long URLs into short, unique links and redirects them efficiently.

---

## 🚀 Features

- Generate short URLs using Base62 encoding
- Redirect short URLs to original URLs
- RESTful API design
- Layered architecture (Controller → Service → Repository)
- PostgreSQL database integration

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Maven

---

## 📌 API Endpoints

### 1. Create Short URL
**POST** `/api/url/shorten`

**Request Body:**
```json
{
  "originalUrl": "https://example.com"
}

```
**Response:**
```
{
  "shortUrl": "http://localhost:8080/abc123"
}
```
**Redirect to Original URL**
```
GET /{shortCode}
```
## How to Run
### 1.Clone the repository:
```
git clone https://github.com/your-username/url-shortener.git
```
### 2.Navigate to the project folder:
```
cd url-shortener
```
### 3.Configure MySQL in application.properties
### 4.Run the application:
```
mvn spring-boot:run
```
