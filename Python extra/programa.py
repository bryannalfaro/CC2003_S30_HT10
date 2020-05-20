#Bryann Eduardo Alfaro 19372
#Universidad del Valle de Guatemala

#Referencias usadas para la elaboracion de este programa:
#https://www.mclibre.org/consultar/python/lecciones/python-listas.html
#https://www.w3schools.com/python/ref_string_join.asp
#https://www.geeksforgeeks.org/connectivity-in-a-directed-graph/
#https://www.pythonista.io/cursos/py101/escritura-y-lectura-de-archivos
#https://networkx.github.io/documentation/latest/_downloads/networkx_reference.pdf

import networkx as nx

grafo = nx.DiGraph() #Se crea un grafo dirigido

#Metodo que dependiendo de la eleccion realizar la modificacion
def modificarGrafo(dpto1, dpto2, distancia, eleccion):
    if(eleccion=="1"):
        if((grafo.has_edge(dpto1,dpto2))==True): 
            
            grafo.remove_edge(dpto1,dpto2)            
            print()
            print("EL BLOQUEO SE REALIZO. GRACIAS POR REPORTAR")
            print()
        else:
            print("LA CONECCION NO PUEDE HACERSE")
        
    elif(eleccion=="2"):
            
        #add_edge(dato1, dato2, weight)
        grafo.add_edge(dpto1,dpto2,weight=float(distancia))
        print("LA RUTA SE ESTABLECIO CORRECTAMENTE.")
            

#-------------------PROGRAMA PRINCIPAL----------------------------------------
#Se crea un grafo
archivo=open("guategrafo.txt", "r")
for i in archivo:
    particion= i.split(" ")
    primerDepartamento = particion[0]
    segundoDepartamento = particion[1]
    pesoArista = float(particion [2])
    
    #add_edge(dato1, dato2, weight)
    grafo.add_edge(primerDepartamento,segundoDepartamento,weight=pesoArista)

archivo.close()

opcion =0
while(opcion !="4"):
    print("Elige una opcion: ")
    print("1. Ruta entre 2 departamentos")
    print("2. Mostrar centro de grafo")
    print("3. Realizar modificaciones")
    print("4. Salir")
    
    opcion = input()
    if(opcion=="1"):     
        
        #Impresion de datos
        nodosGrafo = grafo.nodes()
        num=1
        print ("Departamentos disponibles: ")
        for i in nodosGrafo:
                print(num,")",i)
                num=num+1
    
        listaNodos= nodosGrafo
        
        #---------------PEDIDO DE DATOS--------------------------
        departamento = input("Ingrese el departamento de donde quiere partir: ")
        while (departamento not in listaNodos):
            departamento = input("Ingrese un departamento correcto: ")
        
        
        segundoDepartamento = input("Ingrese el departamento al que desea ir: ")
        while (segundoDepartamento not in listaNodos):
            segundoDepartamento = input("Ingrese un departamento correcto: ")
        
        while (segundoDepartamento == departamento):
            segundoDepartamento = input("Son iguales. Debe ingresar una diferente ")
            while (segundoDepartamento not in listaNodos):
                segundoDepartamento = input("Ingrese un departamento correcto: ")
        
        recorridoCiudades = [] #Lista para guardar los departamentos intermedios
        #----------------------------------------------------------
        #Se aplica Floyd para obtener la ruta mas corta en forma de diccionario segun la documentacion
        floydDict = nx.floyd_warshall_predecessor_and_distance(grafo)  
        
        try:
            ruta = floydDict[0][departamento][segundoDepartamento] #ruta[0] trae el diccionario de predecesores
            distanciaCiudades = floydDict[1][departamento][segundoDepartamento] #ruta[1] trae el diccionario de distancias
            recorridoCiudades.append(ruta)
            
            #Se agregan rutas intermedias que no sean iguales al primer departamento
            while True:
                if (ruta != departamento):
                    intermediaS = floydDict[0][departamento][ruta]
                    recorridoCiudades.append(intermediaS)
                    ruta = intermediaS    
                else:
                    break
            
            listaVolteada = list(reversed(recorridoCiudades)) #Voltear la lista de ciudades intermedias
 
            
            print()
            print ("LA RUTA PARA IR A TU DESTINO ES: ")
            for i in listaVolteada:
                print(i)
            print(segundoDepartamento)
            print ("LA DISTANCIA SERA DE", distanciaCiudades, "km")
            print()
            
        except:
            print("Error, HAY UN BLOQUEO")
        
        
    elif (opcion =="2"):
        #Se hace el calculo del centro del grafo
        print()
        print("El centro del grafo esta determinado por: ")
        try:
            centro = nx.center(grafo) #El requisito es que debe ser fuertemente dirigido
            for i in centro:
                print(i)
        except:
            print("No se puede calcular debido a que el grafo no es fuertemente conectado. Lo siento")
        print()
        
    elif (opcion =="3"):
        print("Entraste a 3")
        print("Que deseas cambiar")
        print("1. Interrupcion de trafico")
        print("2. Establecer conexion")
        
        opcion = input()
        
        if(opcion=="1"):
            
            #Impresion de datos
            nodosGrafo = grafo.nodes()
            num=1
            print ("Departamentos disponibles: ")
            for i in nodosGrafo:
                print(num,")",i)
                num=num+1
            
            #Se pide el ingreso de los departamentos
            departamento = input("Departamento 1: ")
            segundoDepartamento = input("Departamento 2: ")
            modificarGrafo(departamento,segundoDepartamento,0,"1") #Se modifica el grafo
            
        elif(opcion=="2"):
            #Se hace una nueva conexion
            departamento = input("Departamento 1: ")
            segundoDepartamento = input("Departamento 2: ")
            distancia= input("Distancia en km: ")
            
            modificarGrafo(departamento, segundoDepartamento, distancia, "2")
        
    else:
        print("Adios")
        opcion="4"