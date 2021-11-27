public class Sorting {

    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfMin]) indexOfMin = j;
            }
            int temp = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = temp;
        }
    }

    // With boolean flag
    public void bubbleSort(int[] arr) {
        boolean swapped = true;
        int n = arr.length;
        int temp;
        while (swapped) {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swapped = true;
                }
            }
            n--;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }

    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    public void insertionSort(int[] arr) {
        for (int j = 1; j < arr.length; j++) {
            int current = arr[j];
            int i = j - 1;
            while ((i > -1) && (arr[i] > current)) {
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = current;
        }
    }

    public void heapSort(int[] arr) {

        buildHeap(arr);
        int sizeOfHeap = arr.length-1;
        for(int i = sizeOfHeap; i > 0; i--) {
            exchange(arr,0, i);
            sizeOfHeap = sizeOfHeap-1;
            heapify(arr, 0,sizeOfHeap);
        }
    }

    private static void buildHeap(int []arr) {
        for(int i = (arr.length-1)/2; i >= 0; i--){
            heapify(arr,i,arr.length-1);
        }
    }

    private static void heapify(int[] arr, int i,int size) {
        int left = 2*i+1;
        int right = 2*i+2;
        int max;
        if(left <= size && arr[left] > arr[i]){
            max = left;
        } else {
            max = i;
        }

        if(right <= size && arr[right] > arr[max]) {
            max = right;
        }

        if(max!=i) {
            exchange(arr,i, max);
            heapify(arr, max,size);
        }
    }

    private static void exchange(int[] arr,int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
