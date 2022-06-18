package java_algorithms_homework6;

public class CreateTree {
    public static void main(String[] args) {

        int numberTree = 1000;// количество создаваемых деревьев
        int numberItems = 15; // количество элементов в создаваемых деревьях
        int isBalanceForRoot = 0; // количество деревьев, сбалансированных  относительно корня
        int isBalanceForEachNode = 0; // количество деревьев, сбалансированных  относительно каждой вершины дерева

        for (int i = 0; i<numberTree; i++){
            int score = 0;
            Tree tree = new Tree();
            while (score<numberItems){
                int item = (-100 + (int)(Math.random()*201));
                if (tree.find(item) == null) {
                    tree.insert (item);
                    score++;
                }
            }
            if (tree.isBalanceForRoot())
                isBalanceForRoot++;
            if (tree.isBalanceForEachNode())
                isBalanceForEachNode++;
        }

        System.out.printf("Из %d созданных деревьев, содержащих %d элементов каждое,\nсбалансированных относительно корня %d деревьев (или %.1f %%),\n" +
                        "сбалансированных относительно каждого из узлов %d деревьев (или %.1f %%).", numberTree, numberItems, isBalanceForRoot, (float)isBalanceForRoot*100/numberTree,
                isBalanceForEachNode, (float)isBalanceForEachNode*100/numberTree);









    }
}
