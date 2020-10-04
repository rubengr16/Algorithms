public class Algorithms {
    // properties
    private Vector vector;

    // constructor
    public Algorithms (Vector vector) {
        this.vector = vector;
    }

    // getter
    public Vector getVector () {
        return vector;
    }

    // algorithms
    public void selectionSort () { // all: N^2; unstable
        for (int i = 0; i < vector.getArray().length; i++) {
            int k = i;
            for (int j = i + 1; j < vector.getArray().length; j++) {
                if (vector.getArray()[k] > vector.getArray()[j]) {
                    k = j;
                }
            }

            int aux = vector.getArray()[i];
            vector.getArray()[i] = vector.getArray()[k];
            vector.getArray()[k] = aux;
        }
    }

    public Vector selectionSortReturn () { // all: N^2; unstable
        Vector vector = new Vector(this.vector.getArray());
        for (int i = 0; i < vector.getArray().length; i++) {
            int k = i;
            for (int j = i + 1; j < vector.getArray().length; j++) {
                if (vector.getArray()[k] > vector.getArray()[j]) {
                    k = j;
                }
            }

            int aux = vector.getArray()[i];
            vector.getArray()[i] = vector.getArray()[k];
            vector.getArray()[k] = aux;
        }
        return vector;
    }

    public void insertionSort () { // best: N; average: N^2 ; worst: N^2; stable
        for (int i = 1; i < vector.getArray().length; i++) {
            int aux = vector.getArray()[i];
            int k = i;
            while(k > 0 && aux < vector.getArray()[k - 1]) {
                vector.getArray()[k] = vector.getArray()[k--];
            }
            vector.getArray()[k] = aux;
        }
    }

    public Vector insertionSortReturn () { // best: N; average: N^2 ; worst: N^2; stable
        Vector vector = new Vector(this.vector.getArray());
        for (int i = 1; i < vector.getArray().length; i++) {
            int aux = vector.getArray()[i];
            int k = i;
            while (k > 0 && aux < vector.getArray()[k - 1]) {
                vector.getArray()[k] = vector.getArray()[k--];
            }
            vector.getArray()[k] = aux;
        }
        return vector;
    }

    /* My algorithm
    public void bubbleSort () {
        for (int i = 0; i < vector.getArray().length; i++) {
            for (int j = 1; j < vector.getArray().length - i; j++) {
                if (vector.getArray()[j - 1] > vector.getArray()[j]) {
                    int aux = vector.getArray()[j];
                    vector.getArray()[j] = vector.getArray()[j - 1];
                    vector.getArray()[j - 1] = aux;
                }
            }
        }
    }*/

    // THE algorithm
    public void bubbleSort () { // all: N^2; stable
        for (int i = vector.getArray().length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vector.getArray()[j] > vector.getArray()[j + 1]) {
                    int aux = vector.getArray()[j];
                    vector.getArray()[j] = vector.getArray()[j + 1];
                    vector.getArray()[j + 1] = aux;
                }
            }
        }
    }

    public Vector bubbleSortReturn () { // all: N^2; stable
        Vector vector = new Vector(this.vector.getArray());
        for (int i = vector.getArray().length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (vector.getArray()[j] > vector.getArray()[j + 1]) {
                    int aux = vector.getArray()[j];
                    vector.getArray()[j] = vector.getArray()[j + 1];
                    vector.getArray()[j + 1] = aux;
                }
            }
        }
        return vector;
    }

    public void bubbleRemasteredSort () { // best: N; average:N^2 ; worst: N^2; stable
        boolean sorted = false;
        int j = vector.getArray().length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < j; i++) {
                if (vector.getArray()[i] > vector.getArray()[i + 1]) {
                    int aux = vector.getArray()[i];
                    vector.getArray()[i] = vector.getArray()[i + 1];
                    vector.getArray()[i + 1] = aux;
                    sorted = false;
                }
            }
            j--;
        }
    }

    public Vector bubbleRemasteredSortReturn () { // best: N; average:N^2 ; worst: N^2; stable
        Vector vector = new Vector(this.vector.getArray());
        boolean sorted = false;
        int j = vector.getArray().length - 1;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < j; i++) {
                if (vector.getArray()[i] > vector.getArray()[i + 1]) {
                    int aux = vector.getArray()[i];
                    vector.getArray()[i] = vector.getArray()[i + 1];
                    vector.getArray()[i + 1] = aux;
                    sorted = false;
                }
            }
            j--;
        }
        return vector;
    }

    public void combSort () { // best: N*logN; average: N^2/2^P; worst: N^2; unstable
        boolean sorted = false;
        int gap = vector.getArray().length - 1;
        if (vector.getArray()[0] > vector.getArray()[gap]) {
            int aux = vector.getArray()[0];
            vector.getArray()[0] = vector.getArray()[gap];
            vector.getArray()[gap] = aux;
        }
        while (!sorted || gap > 1) {
            if (gap > 1) {
                gap = (int) Math.floor(gap/1.3);
            }
            sorted = true;
            int i = 0;
            while (i + gap < vector.getArray().length) {
                if ( vector.getArray()[i] > vector.getArray()[i + gap]) {
                    int aux = vector.getArray()[i];
                    vector.getArray()[i] = vector.getArray()[i +gap];
                    vector.getArray()[i + gap] = aux;
                    sorted = false;
                }
                i++;
            }
        }
    }

    public Vector combSortReturn () { // best: N*logN; average: N^2/2^P; worst: N^2; unstable
        Vector vector = new Vector(this.vector.getArray());
        boolean sorted = false;
        int gap = vector.getArray().length - 1;
        if (vector.getArray()[0] > vector.getArray()[gap]) {
            int aux = vector.getArray()[0];
            vector.getArray()[0] = vector.getArray()[gap];
            vector.getArray()[gap] = aux;
        }
        while (!sorted || gap > 1) {
            if (gap > 1) {
                gap = (int) Math.floor(gap / 1.3);
            }
            sorted = true;
            int i = 0;
            while (i + gap < vector.getArray().length) {
                if (vector.getArray()[i] > vector.getArray()[i + gap]) {
                    int aux = vector.getArray()[i];
                    vector.getArray()[i] = vector.getArray()[i + gap];
                    vector.getArray()[i + gap] = aux;
                    sorted = false;
                }
                i++;
            }
        }
        return vector;
    }

    /*public void heapSort () {
        BinaryHeap heap = new;
        /*for (int i= 0; i < vector.getArray().length; i++) { // logN
            heap.insertar(vector.getArray()[i]);
        }*/
       /* heap.crearHeap(vector);
       for (int i = vector.getArray().length -1; i >= 0; i--) {
       ve cto.getArray()[i] = heap.extraerMax();
       }
    }*/

}
