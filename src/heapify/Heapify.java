package heapify;

import java.util.Arrays;
import java.util.Scanner;

public class Heapify {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] numbers = input.split(",");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        if (isMinHeap(array)) {
            System.out.println("Dizi min heap'tir.");
        } else {
            System.out.println("Dizi min heap değildir.");
        }
        makeMinHeap(array);
        System.out.println("Heap haline getirilmiş dizi: " + Arrays.toString(array));
    }

    public static boolean isMinHeap(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;
            if (leftChild < array.length && array[i] > array[leftChild]) {
                return false;
            }
            if (rightChild < array.length && array[i] > array[rightChild]) {
                return false;
            }
        }
        return true;
    }

    public static void makeMinHeap(int[] array) {
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            heapify(array, array.length, i);
        }
    }

    public static void heapify(int[] array, int heapSize, int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        if (leftChild < heapSize && array[leftChild] < array[smallest]) {
            smallest = leftChild;
        }
        if (rightChild < heapSize && array[rightChild] < array[smallest]) {
            smallest = rightChild;
        }
        if (smallest != index) {
            int temp = array[index];
            array[index] = array[smallest];
            array[smallest] = temp;
            heapify(array, heapSize, smallest);
        }
    
        
    }
    
}
