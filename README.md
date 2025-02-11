Skill Extraction API

Description

The Skill Extraction API is a Spring Boot-based application designed to extract technical skills and job-related keywords from resumes. The API supports PDF and DOCX file formats, processing the resume's content and extracting relevant skills using an AI-based chat model powered by OpenAI's GPT technology.

This project demonstrates the integration of AI-powered skill extraction for HR and recruitment purposes, making it easier to analyze resumes automatically and efficiently.

Features

-> Skill Extraction: Extracts technical skills and keywords from resumes.

-> File Format Support: Supports PDF and DOCX file formats.

-> AI Integration: Uses OpenAI's GPT model to extract skills from resume text.

-> API Endpoints: Provides a simple RESTful API to handle requests and return the extracted skills.

Technologies Used

-> Spring Boot: Framework for building Java-based backend services.

-> OpenAI GPT: AI model for generating skill extraction results from resume text.

-> Apache PDFBox: Used for extracting text from PDF files.

-> Apache POI: Used for extracting text from DOCX files. -> Java 17+: Programming language used for development.

Installation

Clone the repository:

git clone https://github.com/yourusername/skill-extraction-api.git

Navigate to the project directory:

cd skill-extraction-api

Build the project using Maven:

mvn clean install

Run the application:

mvn spring-boot:run

The application will start on http://localhost:8080.

Usage

POST /api/skills/extract

Description: Extract skills and job-related keywords from a resume.

Request Body:

{ "filePath": "path_to_resume_file" }

Response:

{ "skills": [ "Java", "Spring Boot", "Machine Learning", "SQL", "Python" ] }

Contributing

Feel free to fork the repository, submit issues, and create pull requests. Please make sure to follow the coding standards and write tests for new features.
