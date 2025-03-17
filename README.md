# API Documentation

## Get Training Centers by City and State

### Endpoint
**GET** `/trainingcenter/get`

### Description
Retrieves a list of training centers based on the specified `city` and `state` query parameters. Authentication is required via `Client-Id` and `Client-Token` headers. If no records are found, the response will be an empty list.

### Request

**URL:**
```
http://localhost:8080/trainingcenter/get?city={city}&state={state}
```

**Query Parameters:**
- `city` (string) - Name of the city.
- `state` (string) - Name of the state.

### Headers
- `Client-Id`
- `Client-Token`

### Response

**Example Success Response:**
```json
[
    {
        "id": 2,
        "centerName": "Training Center 2",
        "centerCode": "N0H3ZYY0SH9C",
        "address": {
            "city": "City 2",
            "state": "State 2",
            "detailedAddress": "Address 2",
            "pincode": "248237"
        },
        "studentCapacity": 274,
        "coursesOffered": [
            "Java",
            "Spring Boot",
            "Python",
            "Course 2"
        ],
        "contactEmail": "training2@example.com",
        "contactPhone": "4538798904",
        "createdOn": "2025-03-17T18:29:40.699479Z"
    }
]
```

**Example Failure Response:**
```json
[]
```

---

## Add a New Training Center

### Endpoint
**POST** `/trainingcenter/add`

### Description
Adds a new training center to the system. The request body must include all required fields, and the `contactPhone`, `contactEmail`, and `centerCode` fields must be valid.

### Headers
- `Client-Id`
- `Client-Token`

### Request Body
```json
{
  "centerName": "Tech Academy",
  "centerCode": "189984998893",
  "address": {
    "detailedAddress": "123 Street",
    "city": "a",
    "state": "delhi",
    "pincode": "110001"
  },
  "studentCapacity": 100,
  "coursesOffered": [
    "Java",
    "Spring Boot"
  ],
  "contactEmail": "info@techacademy.com",
  "contactPhone": "9876543217"
}
```

### Response

**Example Success Response:**
```json
{
    "id": 13,
    "centerName": "Tech Academy",
    "centerCode": "189984998893",
    "address": {
        "city": "a",
        "state": "delhi",
        "detailedAddress": "123 Street",
        "pincode": "110001"
    },
    "studentCapacity": 100,
    "coursesOffered": [
        "Java",
        "Spring Boot"
    ],
    "contactEmail": "info@techacademy.com",
    "contactPhone": "9876543217",
    "createdOn": "2025-03-17T19:03:53.821460Z"
}
```

**Example Failure Response:**
```json
{
    "timestamp": "2025-03-17T19:16:12.293+00:00",
    "status": 400,
    "error": "Bad Request",
    "message": "Validation failed for object='trainingCenter'. Error count: 1",
    "errors": [
        {
            "objectName": "trainingCenter",
            "field": "contactPhone",
            "rejectedValue": "98765432",
            "defaultMessage": "phone number must be of 10 digits"
        }
    ],
    "path": "/trainingcenter/add"
}
```
