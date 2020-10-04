public class Vector {
    private int array[];

    //constructors
    public Vector (int size){
        array = new int[size];
    }

    public Vector (int[] array) {
        setArray(array); // otherwise it sets a pointer to array
    }

    // getter
    public int[] getArray () {
        return array;
    }

    // setter
    public void setArray (int[] array) {
        this.array = array.clone();
    }

    // methods
    public void show () {
        int i = 0;
        System.out.printf("\n Vector: [");
        for(; i < array.length - 1; i++) {
            System.out.printf(array[i] + ", ");
        }
        System.out.printf(array[i] + "] \n");
    }
}
