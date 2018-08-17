package com.demo.Sort.QuickSort;

public class QuickSort {
    private int array[];
    private int length;

    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        this.array = inputArr;
        length = inputArr.length;
        quickSort(0, length - 1);
    }

    private void quickSort(int lowerIndex, int higherIndex) {

        int i = lowerIndex;
        int j = higherIndex;
        // 选取中轴参考点
        int idx = lowerIndex+(higherIndex-lowerIndex)/2;
        int pivot = array[idx];
        // 把比轴大的移到右边，比轴小的移到左边
        while (i <= j) {
            // 查找一个比轴大的数
            while (array[i] < pivot) {
                i++;
            }
            // 查找一个比轴小的数
            while (array[j] > pivot) {
                j--;
            }
            // 交换这两个数
            if (i <= j) {
                exchangeNumbers(i, j);
                i++;
                j--;
            }
        }
        show(array, idx, lowerIndex, higherIndex);
        // 对轴左右两边的数组继续进行分治处理，把数据放在合理的位置上
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }

    private void exchangeNumbers(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void show (int[] nums, int idx, int low, int high) {
        System.out.println("[" + low + ":" + high + "] " + idx + " : " + array[idx]);
        for (int i : nums) {
            System.out.printf(i + " ");
        }
        System.out.println();
    }

    public static void main(String a[]){
        QuickSort sorter = new QuickSort();
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        // int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // int[] input = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        sorter.sort(input);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }
}
