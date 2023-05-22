import urllib.request, json, time
import threading
import random
import string
from datetime import datetime

correctas = 0
lock = threading.Lock()

def post(url, data):
    #print(data)
    #data = {'license': 'CAR123', 'arriveTime': '2023-05-21T13:00:00', 'parking': {'id':'3'}}
    data_json = json.dumps(data).encode('utf-8')
    request = urllib.request.Request(url, data=data_json, method='POST')
    request.add_header('Content-Type', 'application/json')

    response = urllib.request.urlopen(request)
    return response.status
    # data2 = response.read()
    # print(json.loads(data2))

def get(url):
    response = urllib.request.urlopen(url)
    return response.status
    
    
def hilo_gets():
    respuesta = get("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/car")
    #respuesta = get("http://ec2-3-88-176-126.compute-1.amazonaws.com:8080/car")
    global correctas
    if(respuesta == 200):
        with lock:
            correctas += 1

def hilo_posts():
    fecha_hora_actual = datetime.now()
    fecha_hora_formateada = fecha_hora_actual.strftime('%Y-%m-%dT%H:%M:%S')
    json = {'license': getLicense(), 'arriveTime':fecha_hora_formateada, 'parking':{'id': '2'}}

    respuesta = post("https://3u5n0ddvnj.execute-api.us-east-1.amazonaws.com/inicio/car", json)
    #respuesta = get("http://ec2-3-88-176-126.compute-1.amazonaws.com:8080/car")
    global correctas
    if(respuesta == 200):
        with lock:
            correctas += 1

def getLicense():
    letras = random.choices(string.ascii_uppercase, k=3)
    numeros = random.choices(string.digits, k=3)
    resultado = letras + numeros
    resultado_string = ''.join(resultado)
    return resultado_string

def mainDeVerdad():
    inicio = time.time()
    # Número de hilos y funciones
    n = 10

    # Crear una lista para almacenar los hilos
    hilos = []

    # Crear y iniciar los hilos
    for i in range(n):
        hilo = threading.Thread(target=hilo_gets)
        hilo2 = threading.Thread(target=hilo_posts)
        hilos.append(hilo)
        hilos.append(hilo2)
        hilo.start()
        hilo2.start()

    # Esperar a que todos los hilos finalicen
    for hilo in hilos:
        hilo.join()

    fin = time.time()
    tiempo_transcurrido = fin - inicio
    print("El programa tardó", tiempo_transcurrido, "segundos en ejecutarse.")
    print("Total de solicitudes respondidas correctamente: ", correctas)
    #print("Total de solicitudes respondidas post correctamente: ", correctasP)
    
mainDeVerdad()