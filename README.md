Get:
http://localhost:8080/trades
result ex:
[
    {
        "tradeId": 1,
        "quantity": 250,
        "version": 1
    }
]

post:
http://localhost:8080/trades
request data ex:
{
    "trade": {
        "quantity": 250
    },
    "shipmentList": [
        {
            "seq": 1,
            "quantity": 250
        }
    ]
}

Get:
http://localhost:8080/shipments/1
result ex:
[
    {
        "tradeId": 1,
        "seq": 1,
        "quantity": 250
    }
]

post:
http://localhost:8080/shipments
request data ex:
{
    "trade": {
        "tradeId":1,
        "quantity": 250
    },
    "shipmentList": [
        {
            "seq": 1,
            "quantity": 150
        },
         {
            "seq": 2,
            "quantity": 100
        }
    ]
}