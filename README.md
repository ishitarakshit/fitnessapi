# fitnessapi

User credentials for all requests : user/user

### To add new record :

Request Method - POST

URL - http://localhost:8080/api/weight

Input Body -  
```
{
   "userName": "billu",
   "amount": 150.33,
   "unit": "LB"
}
```

Result - 
```
{
  "id": 1,
  "userName": "billu",
  "amount": 150.33,
  "unit": "LB",
  "dateTime": "13-05-2017 08:29:55"
}
```

### To get all records : 

Request Method - GET

URL - http://localhost:8080/api/weights

Result - 
```
[
  {
    "id": 1,
    "userName": "pinky",
    "amount": 51.7,
    "unit": "KG",
    "dateTime": "12-05-2017 05:06:10"
  },
  {
    "id": 2,
    "userName": "billu",
    "amount": 150.33,
    "unit": "LB",
    "dateTime": "13-05-2017 08:14:56"
  }
]
```
