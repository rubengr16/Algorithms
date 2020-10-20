public class Main {
    public static void main(String[] args){
        int array[] = {4,9,5,1};
        int array2[] = {90,-27,71,30,29,-50,1};

        Vector vector = new Vector(array);
        Vector vector2 = new Vector(array2);

        BasicSortingAlgorithms selection = new BasicSortingAlgorithms(vector);
        BasicSortingAlgorithms insertion = new BasicSortingAlgorithms(vector);
        BasicSortingAlgorithms bubble = new BasicSortingAlgorithms(vector);
        BasicSortingAlgorithms bubbleRemastered = new BasicSortingAlgorithms(vector);
        BasicSortingAlgorithms comb = new BasicSortingAlgorithms(vector);
        BasicSortingAlgorithms returnBasicSortingAlgorithms = new BasicSortingAlgorithms(vector2);


        System.out.println("\n Unordered Vectors: ");
        selection.getVector().show();
        insertion.getVector().show();
        bubble.getVector().show();
        comb.getVector().show();
        returnBasicSortingAlgorithms.getVector().show();

        selection.selectionSort();
        Vector selectionReturn = returnBasicSortingAlgorithms.selectionSortReturn();

        System.out.println("\n Selection: ");
        selection.getVector().show();
        System.out.println("\n SelectionReturn: ");
        selectionReturn.show();

        insertion.insertionSort();
        Vector insertionReturn = returnBasicSortingAlgorithms.insertionSortReturn();

        System.out.println("\n Insertion: ");
        insertion.getVector().show();
        System.out.println("\n InsertionReturn: ");
        insertionReturn.show();

        bubble.bubbleSort();
        Vector bubbleReturn = returnBasicSortingAlgorithms.bubbleSortReturn();

        System.out.println("\n Bubble: ");
        bubble.getVector().show();
        System.out.println("\n BubbleReturn: ");
        bubbleReturn.show();

        bubbleRemastered.bubbleRemasteredSort();
        Vector bubbleRemasteredReturn = returnBasicSortingAlgorithms.bubbleRemasteredSortReturn();

        System.out.println("\n BubbleRemastered: ");
        bubbleRemastered.getVector().show();
        System.out.println("\n BubbleRemasteredReturn: ");
        bubbleRemasteredReturn.show();

        comb.combSort();
        Vector combReturn = returnBasicSortingAlgorithms.combSortReturn();

        System.out.println("\n CombSort: ");
        comb.getVector().show();
        System.out.println("\n CombSortReturn: ");
        combReturn.show();
    }
}
