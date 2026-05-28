package com.sistemascompras.lista;

import com.sistemascompras.modelo.Cliente;

/**
 * Clase ListaCliente - Implementa una lista doble enlazada manualmente
 * Gestiona operaciones de agregar, consultar y ordenar clientes
 */
public class ListaCliente {
    
    // Atributos
    private Nodo cabeza;    // Primer nodo de la lista
    private Nodo cola;      // Último nodo de la lista
    private int cantidad;   // Cantidad de nodos en la lista
    
    /**
     * Constructor - Inicializa la lista vacía
     */
    public ListaCliente() {
        this.cabeza = null;
        this.cola = null;
        this.cantidad = 0;
    }
    
    /**
     * Verifica si la lista está vacía
     * @return true si está vacía, false en caso contrario
     */
    public boolean estaVacia() {
        return cabeza == null;
    }
    
    /**
     * Retorna la cantidad de elementos en la lista
     * @return Cantidad de nodos
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Agrega un cliente al final de la lista
     * @param cliente Cliente a agregar
     */
    public void agregarFinal(Cliente cliente) {
        Nodo nuevoNodo = new Nodo(cliente);
        
        if (estaVacia()) {
            // Primera inserción
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            // Agregar al final
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        cantidad++;
    }
    
    /**
     * Consulta un cliente por DNI
     * @param dni DNI a buscar
     * @return Cliente encontrado o null si no existe
     */
    public Cliente consultarPorDni(String dni) {
        Nodo actual = cabeza;
        
        while (actual != null) {
            if (actual.getDato().getDni().equals(dni)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        
        return null;  // No encontrado
    }
    
    /**
     * Obtiene el nodo cabeza de la lista
     * @return Nodo cabeza
     */
    public Nodo getCabeza() {
        return cabeza;
    }
    
    /**
     * Obtiene el nodo cola de la lista
     * @return Nodo cola
     */
    public Nodo getCola() {
        return cola;
    }
    
    /**
     * Ordena la lista por monto de compra en orden descendente
     * Utiliza algoritmo Insertion Sort adaptado a lista doble enlazada
     */
    public void ordenarPorMontoDescendente() {
        if (cantidad <= 1) {
            return;  // Lista ya está ordenada
        }
        
        Nodo actual = cabeza.getSiguiente();
        
        while (actual != null) {
            Nodo siguiente = actual.getSiguiente();
            
            // Buscar la posición correcta para insertar
            Nodo posicion = actual.getAnterior();
            
            while (posicion != null && 
                   posicion.getDato().getMontoCompra() < actual.getDato().getMontoCompra()) {
                posicion = posicion.getAnterior();
            }
            
            // Remover el nodo actual de su posición
            if (siguiente != null) {
                siguiente.setAnterior(actual.getAnterior());
            } else {
                cola = actual.getAnterior();
            }
            
            if (actual.getAnterior() != null) {
                actual.getAnterior().setSiguiente(siguiente);
            }
            
            // Insertar en la nueva posición
            if (posicion == null) {
                // Insertar al inicio
                actual.setAnterior(null);
                actual.setSiguiente(cabeza);
                cabeza.setAnterior(actual);
                cabeza = actual;
            } else {
                // Insertar después de posicion
                actual.setSiguiente(posicion.getSiguiente());
                actual.setAnterior(posicion);
                
                if (posicion.getSiguiente() != null) {
                    posicion.getSiguiente().setAnterior(actual);
                } else {
                    cola = actual;
                }
                
                posicion.setSiguiente(actual);
            }
            
            actual = siguiente;
        }
    }
    
    /**
     * Obtiene todos los clientes de la lista como un array
     * @return Array de clientes
     */
    public Cliente[] obtenerTodos() {
        Cliente[] clientes = new Cliente[cantidad];
        Nodo actual = cabeza;
        int indice = 0;
        
        while (actual != null) {
            clientes[indice] = actual.getDato();
            actual = actual.getSiguiente();
            indice++;
        }
        
        return clientes;
    }
    
    /**
     * Limpia la lista eliminando todos los nodos
     */
    public void limpiar() {
        cabeza = null;
        cola = null;
        cantidad = 0;
    }
    
    /**
     * Retorna una representación en string de la lista
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo actual = cabeza;
        sb.append("[");
        
        while (actual != null) {
            sb.append(actual.getDato().toString());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        
        sb.append("]");
        return sb.toString();
    }
}