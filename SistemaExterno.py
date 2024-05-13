import requests
import pandas as pd
import tkinter as tk
from tkinter import ttk

def obtener_datos_de_api(url):
    response = requests.get(url)
    if response.status_code == 200:
        return response.json()
    else:
        print("Error al obtener los datos de la API")
        return None

def mostrar_datos_en_ventana(datos):
    root = tk.Tk()
    root.title("Datos de la API")

    tree = ttk.Treeview(root)
    tree["columns"] = tuple(datos[0].keys())
    tree.heading("#0", text="Index")
    for col in tree["columns"]:
        tree.heading(col, text=col)
        tree.column(col, width=100)

    for i, dato in enumerate(datos):
        tree.insert("", i, text=str(i), values=tuple(dato.values()))

    tree.pack(expand=tk.YES, fill=tk.BOTH)

    root.mainloop()

def main():
    url_api = "http://localhost:8080/api/datos-externos"
    datos = obtener_datos_de_api(url_api)
    if datos:
        mostrar_datos_en_ventana(datos)

if __name__ == "__main__":
    main()
