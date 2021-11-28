package JavaProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GoldmanSachsJavaPractice {

    //Subarray with given sum
    public void subarraySum(int[] arr, int sum) {
        int result = 0;
        boolean flag = false;
        if (arr[0] == sum) {
            System.out.println(1);
        } else {
            for (int i = 0; i <= arr.length - 1; i++) {
                result = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    result += arr[j];
                    if (result == sum) {
                        System.out.println(i + " " + j);
                        flag = true;
                        break;
                    }
                }
                result = 0;
                if (flag == true) {
                    break;
                }
            }
        }
    }

    public void singleNumber(int[] myArr) {
        for (int i = 0; i < myArr.length - 1; i++)
            if (myArr[i] == myArr[i + 1]) {
                System.out.println(myArr[i]);
            }
    }

    public void maxLength() {
        String brack = "((()";
        String[] splitBrack = brack.split("\\(");
    }

    public void findTriplets(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {

        }
    }

    //Find all pairs with a given sum

    public void sumPair(int[] A, int[] B, int sum) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] + B[j] == sum) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }

    //int arr[]
    public void findFibSubset(int arr[]) {
        int n = arr.length;
        int n1 = 0;
        int n2 = 1;
        int x = 0;
        int[] compareArray = new int[n];
        System.out.print(n1 + " " + n2);
        while (n1 <= n) {
            compareArray[x] = n1;

            System.out.print(" " + n1);
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
            x++;
        }
        System.out.println();
        System.out.println(Arrays.toString(compareArray));
    }

    //Find Kth Largest element
    public void bubbleSort(int[] arr, int k) {
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                i = -1;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[arr.length - k]);
    }

    public void reverse(List<Integer> myList, int key) {
        int n = myList.size();
        ArrayList<Integer> myNewList = new ArrayList<>();
        for (Integer myListitr : myList) {
            if (n > key) {
                myNewList.add(myListitr);
                n--;
            }
        }
        myList.removeAll(myNewList);
        System.out.println(" New List " + myNewList);
        Collections.reverse(myNewList);
        System.out.println("Reversed new List " + myNewList);
        System.out.println(" Old List " + myList);
        Collections.reverse(myList);
        myNewList.addAll(myList);
        System.out.println(myNewList);
        for(Integer display : myNewList){
            System.out.println(display);
        }
    }


    public static void main(String[] args) {
        GoldmanSachsJavaPractice gold = new GoldmanSachsJavaPractice();
//        gold.subarraySum(new int[]{1, 2, 3, 7, 5}, 12);
//        gold.singleNumber(new int[]{1, 2, 2,3, 7, 5,5,6,6});
//        gold.maxLength();
//        gold.sumPair(new int[]{1, 2, 2, 3, 7, 5, 5, 6, 6}, new int[]{1, 2, 2, 3, 7, 5, 5, 6 6}, 12);
//        gold.findFibSubset(new int[]{1, 2, 2, 3, 7, 5, 5, 6, 6});
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
//        gold.bubbleSort(new int[]{1, 2, 9, 3, 17, 5, 6, 12, 6, 5, 7, 1, 49}, 3);
        gold.reverse(list, 3);


    }
}
