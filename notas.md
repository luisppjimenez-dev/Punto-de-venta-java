/*
--------------------------------------------------
En Swing se recomienda usar SwingUtilities.invokeLater:
🧠 ¿Por qué es mejor?

Porque Swing trabaja con algo llamado Event Dispatch Thread (EDT)

👉 Básicamente:

Evita errores raros en interfaces
Hace tu app más estable
--------------------------------------------------

📦 LAYOUTS EN JAVA SWING 🤔🤔
--------------------------------------------------
Mis notas
________________________________________________
🧩 BorderLayout
Divide la ventana en 5 zonas:
- NORTH (arriba)
- SOUTH  -sur (abajo)
- EAST -Este (derecha)
- WEST -Oeste (izquierda)
- CENTER (centro)

✔ Solo un componente por zona
✔ CENTER ocupa el espacio restante

Ejemplo:
add(panel, BorderLayout.NORTH);


--------------------------------------------------

🧩 FlowLayout
Coloca componentes en fila.

✔ De izquierda a derecha
✔ Si no caben → bajan a otra línea

Ejemplo:
[Botón1] [Botón2] [Botón3]


--------------------------------------------------

🧩 GridLayout
Divide en tabla (filas y columnas).

✔ Todos los componentes tienen el mismo tamaño
✔ Llena toda la cuadrícula

Ejemplo:
[1] [2]
[3] [4]

Uso:
new GridLayout(filas, columnas);


--------------------------------------------------

🧩 BoxLayout
Coloca componentes en línea vertical u horizontal.

✔ Más control que FlowLayout
✔ Respeta tamaños preferidos

Tipos:
- Y_AXIS (vertical)
- X_AXIS (horizontal)

Ejemplo vertical:
[Botón]
[Botón]
[Botón]


--------------------------------------------------

🧠 JPanel

Es un contenedor (como una caja) donde puedes meter:
- JButton
- JLabel
- JTextField
- otros JPanel

✔ Layout por defecto: FlowLayout

Ejemplo:
JPanel panel = new JPanel();
panel.add(new JButton("Click"));


--------------------------------------------------

📍 setLocationRelativeTo()

Sirve para posicionar la ventana.

Valores:
- null → centra en pantalla
- this → relativo a la ventana actual
- otro componente → relativo a ese componente

Ejemplo:
frame.setLocationRelativeTo(null);

----------------------------------------------
🧩 setLayout
👉Ahora todo lo que agregues se acomoda en fila automáticamente
Define CÓMO se acomodan los componentes dentro de un contenedor (JFrame, JPanel, etc.)
--ejemplo--
setLayout(new FlowLayout());

add(new JButton("A"));
add(new JButton("B"));
se acomodan
[A] [B]

-----------------------------------------------

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
- `EXIT_ON_CLOSE` → **cierra TODO el programa**
(Otras opciones: `HIDE_ON_CLOSE`, `DISPOSE_ON_CLOSE`, etc.)
- 
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  Solo cierra esa ventana
- 
setLocationRelativeTo(null); Centra la ventana en la pantalla
--------------------------------------------------

⚠️ Recordar

✔ Usar Layout Managers
✔ NO usar setLayout(null)
✔ Mantener consistencia visual
✔ Dividir la interfaz en paneles

Ejemplo:
add(new PanelBotones(), BorderLayout.NORTH);
add(new PanelContenido(), BorderLayout.CENTER);

--------------------------------------------------
*/