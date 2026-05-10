package ed.rdr2;

import ed.rdr2.model.CharacterRole;
import ed.rdr2.model.Character;
import ed.rdr2.model.Mission;
import ed.rdr2.model.MissionStatus;
import ed.rdr2.model.Event;
import ed.rdr2.model.EventType;
import ed.rdr2.model.InventoryItem;
import ed.rdr2.model.ItemCategory;
import ed.rdr2.tad.list.LinkedList;
import ed.rdr2.tad.queue.LinkedQueue;
import ed.rdr2.tad.stack.LinkedStack;
import ed.rdr2.tad.set.LinkedSet;
import ed.rdr2.tad.tree.BinaryTree;
import ed.rdr2.tad.graph.AdjacencyListGraph;

/**
 * Programa principal de la simulación RDR2.
 *
 * <p>
 * Este fichero está completamente desarrollado y no debe modificarse.
 * Su ejecución correcta depende exclusivamente de que los TADs estén
 * bien implementados.
 * </p>
 *
 * <p>
 * Escenario simulado:
 * </p>
 * <ol>
 * <li>Inicialización del sistema</li>
 * <li>Creación de Arthur Morgan</li>
 * <li>Gestión de misiones (Lista)</li>
 * <li>Eventos del mundo (Cola)</li>
 * <li>Historial de acciones (Pila)</li>
 * <li>Inventario (Conjunto)</li>
 * <li>Árbol de decisiones (recursivo)</li>
 * <li>Mapa del juego con BFS y DFS (iterativo)</li>
 * </ol>
 *
 * @author Daniel Palacios Alonso
 */
public class Main {

    public static void main(String[] args) {

        // =====================================================================
        // 1. Inicialización del sistema
        // =====================================================================
        printHeader("RDR2 Gang Simulation — Estructuras de Datos");

        // =====================================================================
        // 2. Creación de Arthur Morgan
        // =====================================================================
        Character arthur = new Character("Arthur Morgan", CharacterRole.OUTLAW);
        System.out.println("Personaje principal: " + arthur);

        // =====================================================================
        // 3. Lista de misiones — inserción al final
        // =====================================================================
        printSection("TAD Lista — Misiones de la banda");
        LinkedList<Mission> missionList = new LinkedList<>();
        missionList.addLast(new Mission("Train Robbery",
                "Asalto al tren de Lemoyne", MissionStatus.PENDING));
        missionList.addLast(new Mission("Hunting",
                "Cacería en las montañas de Ambarino", MissionStatus.PENDING));
        missionList.addLast(new Mission("Rescue",
                "Rescate de John en Valentine", MissionStatus.PENDING));

        System.out.println("Misiones iniciales (" + missionList.size() + "):");
        printList(missionList);

        // 4. Inserción intermedia en posición 1 (entre Train Robbery y Hunting)
        missionList.addAt(1, new Mission("Ambush",
                "Emboscada Pinkerton en Colter", MissionStatus.ACTIVE));
        System.out.println("\nTras insertar 'Ambush' en posición 1 (" + missionList.size() + " misiones):");
        printList(missionList);

        // =====================================================================
        // 5. Cola de eventos — FIFO
        // =====================================================================
        printSection("TAD Cola — Eventos del mundo (FIFO)");
        LinkedQueue<Event> eventQueue = new LinkedQueue<>();
        eventQueue.enqueue(new Event(EventType.AMBUSH,
                "Los Pinkertons atacan el campamento"));
        eventQueue.enqueue(new Event(EventType.ENCOUNTER,
                "Encuentro con un forastero en el camino"));
        eventQueue.enqueue(new Event(EventType.CAMP_EMERGENCY,
                "Pearson necesita provisiones urgentes"));

        System.out.println("Procesando " + eventQueue.size() + " eventos en orden FIFO:");
        while (!eventQueue.isEmpty()) {
            Event e = eventQueue.dequeue();
            System.out.println("  → " + e);
        }

        // =====================================================================
        // 6. Pila de acciones — LIFO + undo
        // =====================================================================
        printSection("TAD Pila — Historial de acciones (LIFO)");
        LinkedStack<String> actionStack = new LinkedStack<>();
        actionStack.push("Aceptar misión: Train Robbery");
        actionStack.push("Desplazarse a: Colter");
        actionStack.push("Abrir inventario");

        System.out.println("Pila de acciones: " + actionStack);
        System.out.println("Cima actual   : " + actionStack.peek());
        String undone = actionStack.undo();
        System.out.println("Acción deshecha: " + undone);
        System.out.println("Nueva cima    : " + actionStack.peek());
        System.out.println("Tamaño tras undo: " + actionStack.size());

        // =====================================================================
        // 7. Conjunto de inventario — sin duplicados
        // =====================================================================
        printSection("TAD Conjunto — Inventario (sin duplicados)");
        LinkedSet<InventoryItem> inventory = new LinkedSet<>();
        inventory.add(new InventoryItem("Cattleman Revolver", ItemCategory.WEAPON));
        inventory.add(new InventoryItem("Bread", ItemCategory.FOOD));
        inventory.add(new InventoryItem("Health Cure", ItemCategory.MEDICINE));
        inventory.add(new InventoryItem("Bread", ItemCategory.FOOD)); // duplicado

        System.out.println("Ítems en inventario (" + inventory.size() + ", sin duplicado 'Bread'):");
        inventory.toList().forEach(item -> System.out.println("  · " + item));

        // =====================================================================
        // 8. Árbol de decisiones — recursivo
        // =====================================================================
        printSection("TAD Árbol Binario — Decisiones narrativas (recursivo)");
        BinaryTree<String> decisionTree = new BinaryTree<>();
        decisionTree.setRoot("¿Ayudar a la banda o huir?");
        decisionTree.insertLeft("¿Ayudar a la banda o huir?", "Ayudar → Lealtad+");
        decisionTree.insertRight("¿Ayudar a la banda o huir?", "Huir → Supervivencia+");
        decisionTree.insertLeft("Ayudar → Lealtad+", "La banda sobrevive");
        decisionTree.insertRight("Ayudar → Lealtad+", "Arthur resulta herido");
        decisionTree.insertLeft("Huir → Supervivencia+", "Arthur escapa ileso");
        decisionTree.insertRight("Huir → Supervivencia+", "La banda se debilita");

        System.out.println("InOrden  : " + decisionTree.inOrder());
        System.out.println("PreOrden : " + decisionTree.preOrder());
        System.out.println("PostOrden: " + decisionTree.postOrder());
        System.out.println("contains('Arthur escapa ileso'): "
                + decisionTree.contains("Arthur escapa ileso"));
        System.out.println("contains('Rendirse'): "
                + decisionTree.contains("Rendirse"));

        // =====================================================================
        // 9. Grafo — mapa de localizaciones (BFS y DFS iterativos)
        // =====================================================================
        printSection("TAD Grafo — Mapa de RDR2 (iterativo)");
        AdjacencyListGraph worldMap = new AdjacencyListGraph();

        // Vértices
        worldMap.addVertex("Valentine");
        worldMap.addVertex("Colter");
        worldMap.addVertex("Cumberland Falls");
        worldMap.addVertex("Emerald Ranch");
        worldMap.addVertex("Annesburg");
        worldMap.addVertex("Strawberry");
        worldMap.addVertex("Riggs Station");
        worldMap.addVertex("Rhodes");
        worldMap.addVertex("Saint Denis");
        worldMap.addVertex("Van Horn");
        worldMap.addVertex("Sisika Penitentiary");

        // Aristas (orden de inserción determina el orden BFS)
        worldMap.addEdge("Valentine", "Colter");
        worldMap.addEdge("Valentine", "Cumberland Falls");
        worldMap.addEdge("Valentine", "Emerald Ranch");
        worldMap.addEdge("Colter", "Annesburg");
        worldMap.addEdge("Cumberland Falls", "Strawberry");
        worldMap.addEdge("Emerald Ranch", "Riggs Station");
        worldMap.addEdge("Strawberry", "Rhodes");
        worldMap.addEdge("Riggs Station", "Saint Denis");
        worldMap.addEdge("Rhodes", "Van Horn");
        worldMap.addEdge("Saint Denis", "Van Horn");
        worldMap.addEdge("Van Horn", "Sisika Penitentiary");

        System.out.println(worldMap);

        // BFS desde Valentine
        System.out.println("BFS desde Valentine:");
        java.util.List<String> bfsResult = worldMap.bfs("Valentine");
        for (int i = 0; i < bfsResult.size(); i++) {
            System.out.printf("  %2d. %s%n", i + 1, bfsResult.get(i));
        }

        // DFS desde Valentine
        System.out.println("\nDFS desde Valentine:");
        java.util.List<String> dfsResult = worldMap.dfs("Valentine");
        for (int i = 0; i < dfsResult.size(); i++) {
            System.out.printf("  %2d. %s%n", i + 1, dfsResult.get(i));
        }

        // =====================================================================
        // 10. Resumen final
        // =====================================================================
        printSection("Resumen de la simulación");
        System.out.println("Personaje    : " + arthur);
        System.out.println("Misiones     : " + missionList.size());
        System.out.println("Acciones     : " + actionStack.size() + " (tras undo)");
        System.out.println("Inventario   : " + inventory.size() + " ítems");
        System.out.println("Vértices mapa: " + worldMap.vertexCount());
        System.out.println("\n\"We're thieves in a world that don't want us no more.\" — Arthur Morgan");
    }

    // -------------------------------------------------------------------------
    // Auxiliares de presentación
    // -------------------------------------------------------------------------

    private static void printHeader(String title) {
        String border = "=".repeat(60);
        System.out.println(border);
        System.out.println("  " + title);
        System.out.println(border);
    }

    private static void printSection(String title) {
        System.out.println("\n--- " + title + " ---");
    }

    private static void printList(LinkedList<Mission> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("  [" + i + "] " + list.get(i));
        }
    }
}
