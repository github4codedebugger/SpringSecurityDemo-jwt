# SpringSecurityDemo-jwt

~~~
http://localhost:8080/auth/user/register
Authorization = Basic YWRtaW46YWRtaW4=
{
    "userName": "Dhananjay",
    "email": "dhananjaya@gmail.com",
    "mobile": "9566321505",
    "address": "Bangalore",
    "password": "dhananjaya123"

}


curl --location --request POST 'http://localhost:8080/auth/user/register' \
--header 'Authorization: Basic YWRtaW46YWRtaW4=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName": "Dhananjay",
    "email": "dhananjaya@gmail.com",
    "mobile": "9566321505",
    "address": "Bangalore",
    "password": "dhananjaya123"

}'
~~~

~~~
http://localhost:8080/auth/user/login
Authorization = Basic YWRtaW46YWRtaW4=
{
    "userName" : "Dhananjay",
    "password" : "dhananjaya123"
}

curl --location --request POST 'http://localhost:8080/auth/user/login' \
--header 'Authorization: Basic YWRtaW46YWRtaW4=' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userName" : "Dhananjay",
    "password" : "dhananjaya123"
}'

~~~

~~~
http://localhost:8080/auth/user/validate
Authorization = Basic YWRtaW46YWRtaW4=
x-auth-token = eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI4YmU1ZDAyYi0wYTM1LTRlYjQtOGEyMC1jOTRlYjdjNmRiODQiLCJpYXQiOjE1OTg2NDYwMDksImV4cCI6MTU5ODY0NjMwOSwidXNlck5hbWUiOiJEaGFuYW5qYXkiLCJyb2xlIjoiY3VzdG9tZXIifQ.WCOuYUgweMXfmNoCKvJlMxx9BJz4AAxcxz9QtnOGkB6ZE4QX61Z4rCUSbpJipj7dLoCTRQWRmd6naL9qP04maw
{
    "userName" : "Dhananjay",
    "password" : "dhananjaya123"
}

curl --location --request GET 'http://localhost:8080/auth/user/validate' \
--header 'x-auth-token: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI4YmU1ZDAyYi0wYTM1LTRlYjQtOGEyMC1jOTRlYjdjNmRiODQiLCJpYXQiOjE1OTg2NDYwMDksImV4cCI6MTU5ODY0NjMwOSwidXNlck5hbWUiOiJEaGFuYW5qYXkiLCJyb2xlIjoiY3VzdG9tZXIifQ.WCOuYUgweMXfmNoCKvJlMxx9BJz4AAxcxz9QtnOGkB6ZE4QX61Z4rCUSbpJipj7dLoCTRQWRmd6naL9qP04maw' \
--header 'Authorization: Basic YWRtaW46YWRtaW4='
~~~
