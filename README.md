# fitnessapi

User credentials for all requests : user/user

### To add new user :

Request Method - POST

URL - http://localhost:8080/api/users

Input Body -  
```
{
    "name": "tina",
    "goals":[
    	{
    		"startWeight": {
    			"amount": 200.00,
    			"unit": "LB",
    			"dateTime":"13-05-2017"
    		},
    		"targetWeight": {
    			"amount": 170.00,
    			"unit": "LB",
    			"dateTime":"01-09-2017"
    		}
    	}],
    "currentWeight": {
    	"amount": 190.33,
    	"unit": "LB",
    	"dateTime":"20-05-2017"
    }
  }
```

Result - 
```
{
  "id": 1,
  "name": "tina",
  "goals": [
    {
      "startWeight": {
        "amount": 200,
        "unit": "LB",
        "dateTime": "13-05-2017"
      },
      "targetWeight": {
        "amount": 170,
        "unit": "LB",
        "dateTime": "01-09-2017"
      }
    }
  ],
  "currentWeight": {
    "amount": 190.33,
    "unit": "LB",
    "dateTime": "20-05-2017"
  }
}
```
### To add new goal to existing user : 

Request Method - POST

URL - http://localhost:8080/api/users/1/goals

Input Body - 
```
 {
      "startWeight": {
        "amount": 180,
        "unit": "LB",
        "dateTime": "31-05-2017"
      },
      "targetWeight": {
        "amount": 150.50,
        "unit": "LB",
        "dateTime": "01-10-2017"
      }
 }
```

Result - 
```
{
  "id": 1,
  "name": "tina",
  "goals": [
    {
      "startWeight": {
        "amount": 200,
        "unit": "LB",
        "dateTime": "13-05-2017"
      },
      "targetWeight": {
        "amount": 170,
        "unit": "LB",
        "dateTime": "01-09-2017"
      }
    },
    {
      "startWeight": {
        "amount": 180,
        "unit": "LB",
        "dateTime": "31-05-2017"
      },
      "targetWeight": {
        "amount": 150.5,
        "unit": "LB",
        "dateTime": "01-10-2017"
      }
    }
  ],
  "currentWeight": {
    "amount": 190.33,
    "unit": "LB",
    "dateTime": "20-05-2017"
  }
}
```

### To get user details for id = 1: 

Request Method - GET

URL - http://localhost:8080/api/users/1

Result - 
```
{
  "id": 1,
  "name": "tina",
  "goals": [
    {
      "startWeight": {
        "amount": 180,
        "unit": "LB",
        "dateTime": "31-05-2017"
      },
      "targetWeight": {
        "amount": 150.5,
        "unit": "LB",
        "dateTime": "01-10-2017"
      }
    },
    {
      "startWeight": {
        "amount": 200,
        "unit": "LB",
        "dateTime": "13-05-2017"
      },
      "targetWeight": {
        "amount": 170,
        "unit": "LB",
        "dateTime": "01-09-2017"
      }
    }
  ],
  "currentWeight": {
    "amount": 190.33,
    "unit": "LB",
    "dateTime": "20-05-2017"
  }
}
```

### To get goals for User id = 1

Request Method - GET

URL - http://localhost:8080/api/users/1/goals

Result - 
```
[
  {
    "startWeight": {
      "amount": 200,
      "unit": "LB",
      "dateTime": "13-05-2017"
    },
    "targetWeight": {
      "amount": 170,
      "unit": "LB",
      "dateTime": "01-09-2017"
    }
  },
  {
    "startWeight": {
      "amount": 180,
      "unit": "LB",
      "dateTime": "31-05-2017"
    },
    "targetWeight": {
      "amount": 150.5,
      "unit": "LB",
      "dateTime": "01-10-2017"
    }
  }
]
```
