public class DivideConquerSortingAlgorithms {
    // Properties
    private Vector vector;

    // Constructor
    public DivideConquerSortingAlgorithms(Vector vector) {
        this.vector = vector;
    }

    // Getter
    public Vector getVector () {
        return vector;
    }

    // Algorithms
    public int pivotSorting (Vector vector, int i0, int iN) { // N
        int pivot = vector.getArray()[iN];
        int i = i0;
        int j = iN - 1;
        while (i < j) {
            while (vector.getArray()[i] <= pivot && i < j) { // while elements are smaller than pivot, we advance to center
                i++;
            }
            while (vector.getArray()[j] > pivot && i < j) { // while elements are greater than pivot, we go back to center
                j--;
            }
            int aux = vector.getArray()[i]; // exchange of elements in incorrect positions
            vector.getArray()[i] = vector.getArray()[j];
            vector.getArray()[j] = aux;
        } // i==j
        if (vector.getArray()[i] > pivot) { // when we locate where should be the pivot, the element should be greater
            vector.getArray()[iN] = vector.getArray()[i];
            vector.getArray()[i] = pivot;
            return i;
        }
        else // if element is not greater than pivot, pivot is already well positioned
            return iN;
    }

    public int centralPivotSorting (Vector vector, int i0, int iN) {
        int i = (i0 + iN) / 2;
        int aux = vector.getArray()[iN]; // we exchange the last element with the central one
        vector.getArray()[iN] = vector.getArray()[i];
        vector.getArray()[i] = aux;
        return pivotSorting(vector, i0, iN);
    }

    public void quickSort (Vector vector) {
        quickSortAux(vector, 0, vector.getArray().length - 1);
    }

    private void quickSortAux (Vector vector, int i0, int iN){ // best: N*log N ; average: N*log N; worst: N^2
        if (i0 >= iN)
            return;
        else {
            int m = pivotSorting(vector, i0, iN); // Divide, if we use the centralPivot we get worse the best
            quickSortAux(vector, i0, m - 1); // Conquer, pivot stays the same
            quickSortAux(vector, m+1, iN);
        }
    }

    public void merge (Vector vector, int i0, int k, int iN) {
        int i = i0;
        int j = k + 1;
        int[] aux = new int[iN - i0 + 1]; // disk memory problem computationally
        int f = 0;
        while (i <= k  && j <= iN) {
            if (vector.getArray()[i] <= vector.getArray()[j]) {
                aux[f] = vector.getArray()[i];
                i++;
            }
            else {
                aux[f] = vector.getArray()[j];
                j++;
            }
            f++;
        }
        for (; i <= k; i++) {
            aux[f] = vector.getArray()[i];
            f++;
        }
        for (; j <= iN; j++) {
            aux[f] = vector.getArray()[j];
            f++;
        }
        for (f = 0; f < aux.length; f++) {
            vector.getArray()[i0 + f] = aux[f];
        }
    }

    public void mergeSort (Vector vector) {
        mergeSortAux(vector, 0, vector.getArray().length - 1);
    }

    private void mergeSortAux (Vector vector, int i0, int iN) {
        if (i0 >= iN) {
            return;
        }
        else {
            int k = (i0 + iN) / 2;
            mergeSortAux(vector, i0, k);
            mergeSortAux(vector, k + 1, iN);
            merge(vector, i0, k, iN);
        }
    }
}