package algorithm;

import java.util.Random;

public class Sort {

    public static final int[] ARR_SIZE = {10000, 30000, 50000, 100000};
    public static Random r = new Random();

    public static void main(String[] args) {
        int[] arr, temp;
        double[] delay = new double[3];
        long startTime, endTime;

        for (int i = 0; i < ARR_SIZE.length; i++) {
            arr = new int[ARR_SIZE[i]];
            initArray(arr);
            System.out.println("#####################################################################");
            System.out.println("array size : " + ARR_SIZE[i]);

            temp = arr.clone();
            System.out.println();
            printArray(temp);
            startTime = System.currentTimeMillis();
            bubbleSort(temp);
            printArray(temp);
            endTime = System.currentTimeMillis();
            delay[0] = (endTime - startTime) / 1000.0;

            temp = arr.clone();
            printArray(temp);
            startTime = System.currentTimeMillis();
            mergeSort(temp, 0, temp.length - 1);
            printArray(temp);
            endTime = System.currentTimeMillis();
            delay[1] = (endTime - startTime) / 1000.0;

            temp = arr.clone();
            printArray(temp);
            startTime = System.currentTimeMillis();
            quickSort(temp, 0, temp.length - 1);
            printArray(temp);
            endTime = System.currentTimeMillis();
            delay[2] = (endTime - startTime) / 1000.0;
            System.out.println();

            System.out.printf("bubbleSort delay : %.3fs\n", delay[0]);
            System.out.printf("mergeSort delay  : %.3fs\n", delay[1]);
            System.out.printf("quickSort delay  : %.3fs\n", delay[2]);
            System.out.println("#####################################################################");
            System.out.println();
        }
    }

    public static void initArray(int[] arr) {
        //random number init
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(arr.length);
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j])
                    i--;
            }
        }
    }

    public static void printArray(int[] arr) {
        //배열의 맨 앞부분과 맨 뒷부분만 출력
        int len = 10;
        System.out.print("[");
        for (int i = 0; i < len / 2; i++) {
            System.out.print(arr[i]);
            System.out.print(", ");
        }

        System.out.print("... ,");

        for (int i = len / 2; i > 0; i--) {
            System.out.print(arr[arr.length - i]);
            if (i != 1)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void bubbleSort(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;

        int[] temp = new int[(high - low) + 1];

        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        if (i > mid)
            for (int l = j; l <= high; l++)
                temp[k++] = arr[l];
        else
            for (int l = i; l <= mid; l++)
                temp[k++] = arr[l];


        for (int l = low; l <= high; l++)
            arr[l] = temp[l - low];

    }

    public static void mergerSort2(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergerSort2(arr, low, mid);
            mergerSort2(arr, mid + 1, high);
            merge2(arr, low, mid, high);
        }
    }

    public static void merge2(int[] arr, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        int[] temp = new int[(high - low) + 1];
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        if (i > mid)
            for (int l = j; l <= high; l++)
                temp[k++] = arr[l];
        else
            for (int l = i; l <= mid; l++)
                temp[k++] = arr[l];


        for (int l = low; l <= high; l++)
            arr[l] = temp[l - low];
    }

    public static void quickSort(int[] arr, int low, int high) {
        int pivotPos;
        if (high > low) {
            pivotPos = partition(arr, low, high);
            quickSort(arr, low, pivotPos - 1);
            quickSort(arr, pivotPos + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int i, j, temp;
        int pivotItem;
        pivotItem = arr[low];
        j = low;
        for (i = low + 1; i <= high; i++) {
            if (arr[i] < pivotItem) {
                j++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int pivotPos = j;

        temp = arr[low];
        arr[low] = arr[pivotPos];
        arr[pivotPos] = temp;
        return pivotPos;
    }
}
