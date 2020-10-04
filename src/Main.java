public class Main {
    public static void main(String[] args){
        int array[] = {4,9,5,1};
        int array2[] = {90,-27,71,30,29,-50,1};

        Vector vector = new Vector(array);
        Vector vector2 = new Vector(array2);

        Algorithms selection = new Algorithms(vector);
        Algorithms insertion = new Algorithms(vector);
        Algorithms bubble = new Algorithms(vector);
        Algorithms bubbleRemastered = new Algorithms(vector);
        Algorithms comb = new Algorithms(vector);
        Algorithms returnAlgorithms = new Algorithms(vector2);


        System.out.println("\n Unordered Vectors: ");
        selection.getVector().show();
        insertion.getVector().show();
        bubble.getVector().show();
        comb.getVector().show();
        returnAlgorithms.getVector().show();

        selection.selectionSort();
        Vector selectionReturn = returnAlgorithms.selectionSortReturn();

        System.out.println("\n Selection: ");
        selection.getVector().show();
        System.out.println("\n SelectionReturn: ");
        selectionReturn.show();

        insertion.insertionSort();
        Vector insertionReturn = returnAlgorithms.insertionSortReturn();

        System.out.println("\n Insertion: ");
        insertion.getVector().show();
        System.out.println("\n InsertionReturn: ");
        insertionReturn.show();

        bubble.bubbleSort();
        Vector bubbleReturn = returnAlgorithms.bubbleSortReturn();

        System.out.println("\n Bubble: ");
        bubble.getVector().show();
        System.out.println("\n BubbleReturn: ");
        bubbleReturn.show();

        bubbleRemastered.bubbleRemasteredSort();
        Vector bubbleRemasteredReturn = returnAlgorithms.bubbleRemasteredSortReturn();

        System.out.println("\n BubbleRemastered: ");
        bubbleRemastered.getVector().show();
        System.out.println("\n BubbleRemasteredReturn: ");
        bubbleRemasteredReturn.show();

        comb.combSort();
        Vector combReturn = returnAlgorithms.combSortReturn();

        System.out.println("\n CombSort: ");
        comb.getVector().show();
        System.out.println("\n CombSortReturn: ");
        combReturn.show();
    }
}
