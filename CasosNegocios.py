import urllib.request, json

def carro_sale_de_parqueadero():
    url = "https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/car/27456/2"
    request = urllib.request.Request(url, data={},method='PUT')
    request.add_header('Content-Type', 'application/json')
    response = urllib.request.urlopen(request)
    print("Código de respuesta de la API: ", response.status)

def get_parqueaderos():
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking")
    dict = json.loads(response.read())
    for jsons in dict:
        print("Nombre del parqueadero: ", jsons["name"])

def get_parqueadero_id():
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking/2")
    dict = json.loads(response.read())
    print(dict)

def getCarrosPorDia():
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking/3/diario?fecha=2023-05-22")
    dict = json.loads(response.read())
    count =len(dict)
    print("Parqueadero 3: ",len(dict))
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking/2/diario?fecha=2023-05-22")
    dict = json.loads(response.read())
    print("Parqueadero 2: ",len(dict))
    count += len(dict)
    print("Total carros: ", count)

def actualizar_parking():
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking")
    dict = json.loads(response.read())
    for jsons in dict:
        if(jsons["id"] == "2"):
            print(jsons["name"], "Horario:",jsons["schedule"], "Precio:",jsons["priceP"])

    url = "https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking/2"
    data = {"priceP": 69, "schedule": "7:00-19:00"}
    data_json = json.dumps(data).encode('utf-8')
    request = urllib.request.Request(url, data=data_json, method='PUT')
    request.add_header('Content-Type', 'application/json')
    response = urllib.request.urlopen(request)
    
    response = urllib.request.urlopen("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/parking")
    dict = json.loads(response.read())
    for jsons in dict:
        if(jsons["id"] == "2"):
            print(jsons["name"], "Horario:",jsons["schedule"], "Precio:",jsons["priceP"])


#carro_sale_de_parqueadero()
#get_parqueaderos()
#get_parqueadero_id()
#getCarrosPorDia()
actualizar_parking()