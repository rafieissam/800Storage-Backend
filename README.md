# 800Storage Backend Assignment

## DB Diagram
---

<object data="DB%20Diagram.pdf" type="application/pdf" width="700px" height="700px">
    <embed src="DB%20Diagram.pdf">
        <p>This browser does not support PDFs. Please download the PDF to view it: <a href="DB%20Diagram.pdf">Download PDF</a>.</p>
    </embed>
</object>

---

## Endpoint Documentation

---

### BASE_URL
> `http://localhost:8000`

---

### Products

* Fetch All : `GET /products`
* Fetch One : `GET /products/{id}`
* Create One : `POST /products`
```
{
    name: String,
    description: String,
    category: String
}
```

* Update One : `PATCH /products/{id}`
```
{
    name: String,
    description: String,
    category: String
}
```
* Delete One : `DELETE /products/{id}`

---

### Clients

* Fetch All : `GET /clients`
* Fetch One : `GET /clients/{id}`
* Create One : `POST /clients`
```
{
    first_name: String,
    last_name: String,
    mobile: String
}
```

* Update One : `PATCH /clients/{id}`
```
{
    first_name: String,
    last_name: String,
    mobile: String
}
```
* Delete One : `DELETE /clients/{id}`

---

### Sales

* Fetch All : `GET /sales`
* Fetch One : `GET /sales/{id}`
* Create One : `POST /sales`
```
{
    client: Integer,
    seller: Integer,
    transactions: [{
        product: Integer,
        quantity: Integer,
        price: Float
    }]
}
```

* Update One : `PATCH /sales/{sale_id}/transactions/{transaction_id}`
```
{
    quantity: Integer,
    price: Float
}
```
* Delete One : `DELETE /sales/{id}`