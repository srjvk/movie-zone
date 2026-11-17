MovieZone

A Spring Boot REST API for managing movie data inspired by IMDb’s Top 250 Movies.

Features

List all movies
Filter movies by title, director, cast, rank, genre, or certificate
Add new movies
Update existing movies
Delete movies by title
PostgreSQL persistence through Spring Data JPA
Tech Stack

Java 21
Spring Boot
Spring Web
Spring Data JPA
PostgreSQL
Maven
JUnit 5
API Endpoints

Base URL: /api/v1/movie

Method	Endpoint	Description
GET	/api/v1/movie	Get all movies
GET	/api/v1/movie?name=...	Filter by title
GET	/api/v1/movie?director=...	Filter by director
GET	/api/v1/movie?casts=...	Filter by cast
GET	/api/v1/movie?rank=...	Filter by rank
GET	/api/v1/movie?genre=...	Filter by genre
GET	/api/v1/movie?certificate=...	Filter by certificate
POST	/api/v1/movie	Add a movie
PUT	/api/v1/movie	Update a movie
DELETE	/api/v1/movie/{movieName}	Delete a movie
Prerequisites

Java 21
Maven or the included Maven Wrapper
PostgreSQL

Running the Project

Clone the repository:

bash
git clone https://github.com/srjvk/movie-zone.git
cd movie-zone
Run the application:

bash
./mvnw spring-boot:run
On Windows:

bash
mvnw.cmd spring-boot:run
The API is available at:

Text
http://localhost:8080/api/v1/movie
Running Tests

bash
./mvnw test
Example Movie Payload

JSON
{
  "rank": 1,
  "name": "The Shawshank Redemption",
  "year": 1994,
  "rating": 9.3,
  "genre": "Drama",
  "certificate": "A",
  "run_time": "142 min",
  "tagline": "Fear can hold you prisoner...",
  "budget": 25000000,
  "box_office": 58800000,
  "casts": "Tim Robbins, Morgan Freeman",
  "directors": "Frank Darabont",
  "writers": "Stephen King, Frank Darabont"
}
Project Structure

Text
src
├── main
│   ├── java/com/ml/movie/zone
│   │   ├── MovieZoneApplication.java
│   │   └── movie
│   │       ├── Movie.java
│   │       ├── MovieController.java
│   │       ├── MovieRepository.java
│   │       └── MovieService.java
│   └── resources
│       └── application.properties
└── test
    └── java/com/ml/movie/zone
        └── MovieZoneApplicationTests.java
