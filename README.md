# Sistema de Compras - Lista Doble Enlazada

Proyecto Java con Apache NetBeans usando Java Swing y Programación Orientada a Objetos.

## Descripción

Sistema para registrar compras de clientes implementando una **lista doble enlazada manualmente** (sin usar ArrayList ni LinkedList de Java).

## Características

✅ **Lista Doble Enlazada Manual** - Implementación desde cero sin colecciones Java
✅ **Cálculo de Descuentos** - Según tipo de tarjeta (Clásica 4%, Visa 6%, Premium 8%)
✅ **Ordenamiento** - Insertion Sort adaptado a lista doble enlazada
✅ **Interfaz Swing** - Formulario completo con tabla de datos
✅ **Persistencia** - Guardar/cargar datos en archivo de texto
✅ **Validaciones** - Campos requeridos y datos válidos
✅ **Arquitectura en Capas** - Separación de responsabilidades

## Estructura del Proyecto

```
SistemaCompras/
├── pom.xml
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/sistemascompras/
    │   │       ├── modelo/
    │   │       │   └── Cliente.java
    │   │       ├── lista/
    │   │       │   ├── Nodo.java
    │   │       │   └── ListaCliente.java
    │   │       ├── persistencia/
    │   │       │   └── Persistencia.java
    │   │       ├── procesos/
    │   │       │   └── ProcesosForma01.java
    │   │       ├── controlador/
    │   │       │   └── ControlForma01.java
    │   │       └── vista/
    │   │           └── FormularioPrincipal.java
    │   └── resources/
    │       └── datos.txt
```

## Clases Principales

### 1. Cliente (Modelo)
- Almacena datos del cliente
- Calcula descuento y monto final
- Getters y Setters completos

### 2. Nodo (Lista)
- Representa un nodo de la lista doble enlazada
- Referencias: anterior y siguiente
- Almacena objeto Cliente

### 3. ListaCliente (Lista)
- Implementa lista doble enlazada
- Métodos: agregarFinal(), consultarPorDni(), ordenarPorMontoDescendente()
- Ordenamiento con Insertion Sort

### 4. Persistencia
- Guarda datos en archivo de texto
- Carga datos desde archivo
- Separador: |

### 5. ProcesosForma01
- Lógica del formulario
- Lectura y validación de datos
- Mostrado en tabla

### 6. ControlForma01
- Controlador de eventos
- Maneja acciones de botones
- Integra todas las capas

### 7. FormularioPrincipal
- Interfaz Swing completa
- JTable con datos
- Componentes de entrada: JTextField, JComboBox
- Botones: Registrar, Consultar, Ordenar, Limpiar, Mostrar

## Cómo Compilar y Ejecutar

### Requisitos
- Java 11 o superior
- Maven 3.6 o superior

### Compilar
```bash
mvn clean compile
```

### Empaquetar
```bash
mvn package
```

### Ejecutar
```bash
mvn exec:java -Dexec.mainClass="com.sistemascompras.vista.FormularioPrincipal"
```

### En Apache NetBeans
1. File → Open Project
2. Seleccionar carpeta del proyecto
3. Click derecho → Run

## Funcionalidades

1. **Registrar Cliente** - Agrega nuevo cliente a la lista
2. **Consultar por DNI** - Busca cliente específico
3. **Ordenar** - Ordena por monto descendente
4. **Limpiar** - Limpia campos de entrada
5. **Mostrar** - Muestra todos los clientes en tabla
6. **Persistencia** - Guarda/carga automáticamente

## Descuentos por Tipo de Tarjeta

- **Clásica**: 4%
- **Visa**: 6%
- **Premium**: 8%

## Instrucciones de Descarga

1. Clona el repositorio:
```bash
git clone https://github.com/Kenji83946/SistemaCompras.git
```

2. Abre en Apache NetBeans o compila con Maven

3. ¡Disfruta del sistema!

## Autor

Kenji83946

## Licencia

Este proyecto es de código abierto y está disponible bajo licencia MIT.
