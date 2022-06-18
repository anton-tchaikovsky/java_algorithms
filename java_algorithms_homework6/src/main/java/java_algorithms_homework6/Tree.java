package java_algorithms_homework6;

public class Tree  {
    public Node root;

    public Tree() {
        root = null;
    }

    public Node find(int item){
        if (root == null)
            return null;
        Node current = root;
        while (current.getItem()!= item){
            if (current.getItem()<item)
                current = current.rightChild;
            else
                current = current.leftChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int item){
        Node node = new Node(item);
        if (root == null){
            root = node;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (item < current.getItem()){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else if (item > current.getItem()) {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = node;
                        return;
                    }
                } else {
                    return; // если item уже существует в дереве, то повторно его не вставляем
                }
            }
        }
    }

    private void inOrder(Node rootNode){
        if(rootNode != null){
            inOrder(rootNode.leftChild);
            rootNode.display();
            inOrder(rootNode.rightChild);
        }
    }

    private void preOrder(Node rootNode){
        if(rootNode != null){
            rootNode.display();
            preOrder(rootNode.leftChild);
            preOrder(rootNode.rightChild);
        }
    }

    private void postOrder(Node rootNode){
        if(rootNode != null){
            postOrder(rootNode.leftChild);
            postOrder(rootNode.rightChild);
            rootNode.display();
        }
    }

    public void display (){
        inOrder(root);
    }

    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node max() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int item){
        Node current = root;
        Node parent = current;
        boolean isLeftChild = true;

        while (current.getItem() != item) {
            parent = current;
            if (item < current.getItem()){
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null){
                return false;
            }
        }

        // Если нет потомков
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if(isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // Если нет правого потомка
        else if(current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if(isLeftChild) {
                parent.leftChild = current.leftChild;
            }else{
                parent.rightChild = current.leftChild;
            }
        }

        // Если нет левого потомка
        else if(current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if(isLeftChild) {
                parent.leftChild = current.rightChild;
            }else{
                parent.rightChild = current.rightChild;
            }
        }
        // Если есть и левый, и правый потомки
        else {
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }else if(isLeftChild){
                parent.leftChild = successor;
            }else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;

    }

    private Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    /**
     * Метод определяет высоту (количесвто уровней) дерева.
     * @param root корень дерева или поддерева
     * @return высота дерева
     */
    private int getHeight(Node root) {
        if(root!=null)
            return 1 + Math.max(getHeight(root.leftChild),getHeight(root.rightChild));
        else
            return 0;
    }

    /**
     * Метод определяет, сбалансировано ли дерево относительно корня:
     * высоты левого и правого поддерева должны быть равны или отличаться не более, чем на один уровень.
     * @return true - дерево сбаоансированно, false - дерево не сбалансированно
     */
    public boolean isBalanceForRoot (){
        if (root == null)
            return true;
        return Math.abs(getHeight(root.rightChild) - getHeight(root.leftChild))<=1;
    }

    /**
     * Метод определяет, сбалансировано ли дерево относительно каждой из вершин,
     * т.е. сбалансированно ли каждое поддерево:
     * высоты левого и правого поддерева для каждой из вершин должны быть равны или отличаться не более, чем на один уровень.
     * @param root корень дерева или поддерева
     * @return true - дерево сбаоансированно, false - дерево не сбалансированно
     */
    private boolean isBalanceForEachNode (Node root){
        if (root == null)
            return true;
        else return (Math.abs(getHeight(root.rightChild) - getHeight(root.leftChild)) <= 1) &&
                isBalanceForEachNode(root.leftChild) && isBalanceForEachNode(root.rightChild);
    }

    /**
     * Метод определяет, сбалансировано ли дерево относительно каждой из вершин,
     * т.е. сбалансированно ли каждое поддерево:
     * высоты левого и правого поддерева для каждой из вершин должны быть равны или отличаться не более, чем на один уровень.
     * @return true - дерево сбаоансированно, false - дерево не сбалансированно
     */
    public boolean isBalanceForEachNode(){
        return isBalanceForEachNode (root);
    }

}
