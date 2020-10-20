public class DivideConquerSearchingAlgorithms {
    // properties
    private Vector vector;

    // constructor
    public DivideConquerSearchingAlgorithms(Vector vector) {
        this.vector = vector;
    }

    // getter
    public Vector getVector () {
        return vector;
    }

    // algorithms
    // brute force
    public boolean containsValueBrute (Vector vector, int element) {
        int i = 0;
        boolean greater = false;
        boolean found = false;
        while (!found && !greater && i < vector.getArray().length) {
            if (vector.getArray()[i] == element)
                found = true;
            else if (vector.getArray()[i] > element)
                greater = true;
            i++;
        }
        return found;
    }

    public int maxSubArrayBrute (Vector vector) {
        int max = Integer.MIN_VALUE;
        int i0Max = 0;
        int iNMax = 0;
        for (int i0= 0; i0 < vector.getArray().length; i0++) {
            int addition = 0;
            for (int iN = 0; iN < vector.getArray().length; iN++) {
                addition += vector.getArray()[iN];
                if (addition > max) {
                    max = addition;
                    i0Max = i0; // Optionals, not useful in this case
                    iNMax = iN;
                }
            }
        }
        return max;
    }

    public int maxBrute (Vector vector) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < vector.getArray().length; i++) {
            if (vector.getArray()[i] > max)
                max = vector.getArray()[i];
        }
        return max;
    }

    public void transposeBrute (Vector[] vector) {
        for (int i = 0; i < vector[i].getArray().length; i++)
            for (int j = 0; j < i; j++) {
                int aux = vector[i].getArray()[j];
                vector[i].getArray()[j] = vector[j].getArray()[i];
                vector[j].getArray()[i] = aux;
            }
    }

    //devide and conquer
    public boolean containsValue (Vector vector, int element) {
        return containsValueAux(vector, 0, vector.getArray().length - 1, element);
    }

    private boolean containsValueAux (Vector vector, int i0, int iN, int element) {
        if (i0 == iN) // In the case vector has 1 element, we do not devide
            return element == vector.getArray()[i0];
        else {
            int k = (i0 + iN) / 2; // Divides
            if (element < vector.getArray()[k])
                return containsValueAux(vector, i0, k, element);
            else if (element == vector.getArray()[k])
                return true;
            else
                return containsValueAux(vector, k + 1, iN, element);
        }
    }

    public int maxSubArray (Vector vector) {
        return maxSubArrayAux (vector, 0, vector.getArray().length - 1);
    }

    private int maxSubArrayAux (Vector vector, int i0, int iN) {
        if (i0 == iN)
            return  vector.getArray()[i0];
        else {
            int k = (i0 + iN) / 2;
            int max1 = maxSubArrayAux(vector, 0,k);
            int max2 = maxSubArrayAux(vector, k, iN);
            int max3 = maxSubArrayCrossed(vector, 0, iN, k);
            return  Math.max(max1, Math.max(max2, max3));
        }

    }

    public int maxSubArrayCrossed (Vector vector, int i0, int iN, int k) {
        int max = Integer.MIN_VALUE;
        int addition = 0;
        int iMax = 0;
        int jMax = 0;
        for (int i = k; k >= i0; i--) {
            addition += vector.getArray()[i];
            if (addition > max) {
                max = addition;
                iMax = i;
            }
        }
        addition = max;
        for (int j = k + 1; j <= iN; j++) {
            addition += vector.getArray()[j];
            if (addition > max) {
                max = addition;
                jMax = j;
            }
        }
        return max;
    }

    public int max (Vector vector) { // do not improve the complexity
        return maxAux(vector, 0, vector.getArray().length - 1);
    }

    private int maxAux (Vector vector, int i0, int iN) {
        if (i0 == iN)
            return vector.getArray()[i0];
        else {
            int k = (i0 + iN) / 2;
            int max1 = maxAux(vector, i0, k);
            int max2 = maxAux(vector, k + 1, iN);
            return Math.max(max1, max2);
        }
    }

    public void transpose (Vector[] vector) {
        transposeAux(vector, 0, vector.length, 0, vector[0].getArray().length);
    }

    private void transposeAux (Vector[] vector, int i0, int iN, int j0, int jN) {
        if (i0 >= iN || j0 >= jN)
            return;
        else {
            int ik = (i0 + iN) / 2;
            int jk = (j0 + jN) / 2;
            transposeAux(vector, i0, ik, j0, jk);
            transposeAux(vector, i0, ik, jk + 1, jN);
            transposeAux(vector, ik +1, iN, j0, jN);
            transposeAux(vector, ik +1, iN, jk + 1, jN);
            for (int i = 0; i < ik - i0 + 1; i++)
                for (int j = 0; j < jk - j0 +1; j++) {
                    int aux = vector[i + ik + 1].getArray()[j +j0];
                    vector[i + ik + 1].getArray()[j + j0] = vector[i + i0].getArray()[j + jk + 1];
                    vector[i + i0].getArray()[j + jk + 1] = aux;
                }
        }
    }
}
