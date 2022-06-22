package java_algorithms_homework7;

public class Graph {
    private final int MAX_VERTEX = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;
    private Stack stack;
    private Queue queue;
    public Graph(){
        vertexList = new Vertex[MAX_VERTEX];
        adjMat = new int[MAX_VERTEX][MAX_VERTEX];
        size = 0;
        for (int i = 0; i < MAX_VERTEX; i++) {
            for (int j = 0; j < MAX_VERTEX; j++) {
                adjMat[i][j] = 0;
            }
        }
    }
    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }
    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }
    public void displayVertex(int vertex){
        System.out.print(vertexList[vertex]);
    }
    private int getAdjUnvisitedVertex(int vertex) {
        for (int i = 0; i < size; i++) {
            if(adjMat[vertex][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void dfs(){
        stack = new Stack(MAX_VERTEX);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getAdjUnvisitedVertex(stack.peek());
            if (v == -1){
                stack.pop();
            } else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }

    public void bfs(){
        queue = new Queue(MAX_VERTEX);
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0); // Вставка в конец очереди
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true; // Пометка
                displayVertex(v2); // Вывод
                queue.insert(v2);
            }
        }
        for(int i=0; i<size; i++) // Сброс флагов
            vertexList[i].wasVisited = false;
    }


    /**
     * Метод возвращает индекс, под которым сохранен узел со значением label в массиве vertexList
     * @param label значение узла
     * @return индекс узла со значением label или -1, если нет узла со значением label
     */
    private int finedIndex (char label){
        for (int i = 0; i<size; i++)
            if (vertexList[i].label==label)
                return i;
        return -1;
    }

    /**
     * Метод путем обхода графа в ширину, начиная с узла с индексом start, находит узел с индексов current
     * и возвращает индекс узла, предшествующего в процессе поиска узлу current
     * @param start индекс узла, с которого начинается обход графа
     * @param current индекс, заданного узла
     * @return индекс узла, предшествующего в процессе поиска узлу current, или -1, если узла
     * current нет в графе
     */
    private int bsfFinedPrevious (int start, int current){
        queue = new Queue(MAX_VERTEX);
        vertexList[start].wasVisited = true;
        queue.insert(start);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2=getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                if (v2==current){
                    for(int i=0; i<size; i++)
                        vertexList[i].wasVisited = false;
                    return v1;
                }
                queue.insert(v2);
            }
        }
        for(int i=0; i<size; i++)
            vertexList[i].wasVisited = false;
        return -1;
    }

    /**
     * Метод выводит в консоль наименьший путь от узла со значением labelStart
     * до узла со значением labelFinish. Если наименьших путей несколько, выводится в консоль только один.
     * @param labelStart значение стартового узла
     * @param labelFinish значение конечного узла
     */
    public void minDistance (char labelStart, char labelFinish){
        if (finedIndex (labelStart)==-1)
            System.out.println("Узла " + labelStart + " не существует.");
        else if (finedIndex (labelFinish)==-1)
            System.out.println("Узла " + labelFinish + " не существует.");
        else {
            int currentVertex = finedIndex (labelStart);
            displayVertex(currentVertex); //печатаем узлы, начиная со стартового
            //пока не дошли до узла со значением labelFinish, рекурсивно находим все узлы,
            // находящиеся на наименьшем пути
            if (currentVertex!=finedIndex (labelFinish)){
                System.out.print("->");
                currentVertex = bsfFinedPrevious (finedIndex (labelFinish), currentVertex);
                minDistance (vertexList [currentVertex].label, labelFinish);
            }
        }
    }
}
