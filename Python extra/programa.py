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

def modificarGrafo(ciudad1, ciudad2, distancia, eleccion):
    if(eleccion=="1"):
        if((grafo.has_edge(ciudad1,ciudad2))==True): 
            
            grafo.remove_edge(ciudad1,ciudad2)            
            print()
            print("EL BLOQUEO SE REALIZO. GRACIAS POR REPORTAR")
            print()
        else:
            print("LA CONECCION NO PUEDE HACERSE")
        
    elif(eleccion=="2"):
            
        #add_edge(dato1, dato2, weight)
        grafo.add_edge(ciudad1,ciudad2,weight=float(distancia))
        print("LA RUTA SE ESTABLECIO CORRECTAMENTE.")
            

#-------------------PROGRAMA PRINCIPAL----------------------------------------
#Se crea un grafo
archivo=open("guategrafo.txt", "r")
for i in archivo:
    particion= i.split(" ")
    primeraCiudad = particion[0]
    segundaCiudad = particion[1]
    pesoArista = float(particion [2])
    
    #add_edge(dato1, dato2, weight)
    grafo.add_edge(primeraCiudad,segundaCiudad,weight=pesoArista)

archivo.close()

opcion =0
while(opcion !="4"):
    print("Elige una opcion: ")
    print("1. Ruta entre 2 ciudades")
    print("2. Mostrar centro de grafo")
    print("3. Realizar modificaciones")
    print("4. Salir")
    
    opcion = input()
    if(opcion=="1"):     
        
        #Impresion de datos
        nodosGrafo = grafo.nodes()
        num=1
        print ("Ciudades disponibles: ")
        for i in nodosGrafo:
                print(num,")",i)
                num=num+1
    
        listaNodos= nodosGrafo
        
        #---------------PEDIDO DE DATOS--------------------------
        ciudad1 = input("Ingrese la ciudad de origen: ")
        while ciudad1 not in listaNodos:
            ciudad1 = input("Ingrese una ciudad correcta: ")
        
        
        ciudad2 = input("Ingrese la ciudad destino: ")
        while ciudad2 not in listaNodos:
            ciudad2 = input("Ingrese una ciudad correcta: ")
        
        while ciudad2 == ciudad1:
            ciudad2 = input("No puede ser igual. Ingrese otra: ")
            while ciudad2 not in listaNodos:
                ciudad2 = input("Ingrese una ciudad correcta: ")
        
        #----------------------------------------------------------
                
        recorridoCiudades = [] #Lista para guardar la ciudad o ciudades intermedias
        floydDict = nx.floyd_warshall_predecessor_and_distance(grafo)  
        
        try:
            ruta = floydDict[0][ciudad1][ciudad2] #path[0] trae el diccionario de predecesores
            distanciaCiudades = floydDict[1][ciudad1][ciudad2] #path[1] trae el diccionario de distancias
            recorridoCiudades.append(ruta)
            
            while True:
                if (ruta != ciudad1):
                    intermediaS = floydDict[0][ciudad1][ruta]
                    recorridoCiudades.append(intermediaS)
                    ruta = intermediaS    
                else:
                    break
            
            
            listaVolteada = list(reversed(recorridoCiudades)) #Voltear la lista de ciudades intermedias
 
            
            print()
            print ("LA RUTA PARA IR A TU DESTINO ES: ")
            for i in listaVolteada:
                print(i)
            print(ciudad2)
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
            print ("Ciudades disponibles: ")
            for i in nodosGrafo:
                print(num,")",i)
                num=num+1
            
            #Se pide el ingreso de las ciudades
            ciudad1 = input("Ciudad 1: ")
            ciudad2 = input("Ciudad 2: ")
            modificarGrafo(ciudad1,ciudad2,0,"1") #Se modifica el grafo
            
        elif(opcion=="2"):
            #Se hace una nueva conexion
            ciudad1 = input("Ciudad 1: ")
            ciudad2 = input("Ciudad 2: ")
            distancia= input("Distancia: ")
            
            modificarGrafo(ciudad1, ciudad2, distancia, "2")
        
    else:
        print("Adios")
        opcion="4"