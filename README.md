# 💱Exchange Rate App

Hello! My name is Danylo Krupnyk and I am Java Developer! 

This is my Simple project that provides service to retrieve data from Exchange Rate API!
This application reads provided url (every 60 seconds), saves all data into in-memory Database and provige controllers to access Data.

The project is made in accordance with the so-called three-tier development dividing the entire business application into:
- Presentation layer-business logic (controllers)
- Application layer (services)
- Data access layer (DAO)

Layering is to achieve "high cohesion, low coupling". The idea of "divide and conquer" is adopted to divide the problem into individual solutions, which is easy to control, easy to extend, and easy to allocate resources. 

## 🔧Install it by yourself and try
- Download this project (clone and open in your IDE).
- Configure connection to API via ApiFetcherService
- Run ExchangeRateAppApplication via Spring Boot
- Data will be fetched automatically in every 60 seconds.

## 🔗There are different URL to work with:
- http://localhost:8080/rates/average to get average rates based on all resources
- http://localhost:8080/rates/average-in-period?fromDate=2021-07-09&toDate=2021-07-09 to get average rates based on all resources between specified dates

## 👨‍💻Technologies trained
- Spring Boot
- Tomcat
- Hibernate Framework
- Maven
- Json
- Lombok
- Cron job

## 📝Contact me
- [Telegram](https://t.me/DKrupnyk)
- [LinkedIn](http://www.linkedin.com/in/danyloKrupnyk)
- [Skype](https://join.skype.com/invite/IX5MwBVFkWTg)
- [CodeWars](https://www.codewars.com/users/Danylo24)
