###  Application Description

This application simulates a customer registration and CPF validation workflow using Kafka, MongoDB, and external API integration.

### Flow application

- The hex-client API receives a request with customer data.
- It retrieves the customer's address using a fake api with Wiremock(via Feign Client).
- It saves the customer to the MongoDB database.
- It sends the customer CPF to a Kafka topic (topic-cpf-validation).
- A fake validation service consumes the CPF and validates it.
- If valid, the service sends the updated customer message to a second Kafka topic (topic-cpf-validated).
- The application listens to the topic-cpf-validated topic and updates the isValidCpf field in the database.

### Testing Instructions

You can find a test JSON collection for tools like Postman in the root directory of this Java application.

###  Run Docker (Kafka, MongoDB)

Navigate to the docker-local folder and run:

```docker compose up -d```

####  Manually Update isValidCpf Field

To simulate the CPF validation response manually, insert a message like the following into the Kafka topic cpf-validated:
{
"id": "68715e7be821e63330880e85",
"name": "Charles",
"cpf": "42828278754",
"zipCode": "06449120",
"isValidCpf": true
}

This will trigger the customer record to be updated with a valid CPF.

 #### WireMock

The application uses WireMock to mock responses from the external address API (ZIP code lookup).
Ex json to be inserted in the mappings folder of Wiremock standalone:

```json
{
  "request": {
    "method": "GET",
    "url": "/addresses/06449130"
  },
  "response": {
    "status":200,
    "headers":{
      "Content-Type" : "application/json"
    },
    "jsonBody": {
      "street": "Rua Barra Bonita",
      "city": "Barueri",
      "state": "São Paulo"
    }
  }
}
```


💡 Tip

Use the IntelliJ plugin Kafkalytic to view topics and insert Kafka messages manually.

