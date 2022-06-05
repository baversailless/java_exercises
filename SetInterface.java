import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

       /* int N = scanner.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        // removeDuplicate(arr);
        // countOfDublicate(arr);
        // KthMaxMin(arr);
        */

        String s = scanner.next();
        NumberOfRepetitions(s);
    }


    static void removeDuplicate(int[] arr) {
        LinkedHashSet<Integer> s = new LinkedHashSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            s.add(arr[i]);
        }
        System.out.println(s);
    }

    static void countOfDublicate(int[] arr) {
        LinkedHashSet<Integer> s = new LinkedHashSet<Integer>();
        int q = 0;
        for (int i = 0; i < arr.length; i++) {
            if (s.add(arr[i]) == false) {
                q++;
            }
        }
        System.out.println(q);
    }

    static void KthMaxMin(int[] arr) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        TreeSet<Integer> s = new TreeSet<Integer>();

        for (int i = 0; i < arr.length; i++) {
            s.add(arr[i]);
        }

        while (k != 1) {
            s.pollFirst();
            s.pollLast();
            k--;
        }
        System.out.println("The kth minimum is: " + s.first());
        System.out.println("The kth maximum is: " + s.last());
    }

    static void NumberOfRepetitions(String s) {
        HashMap<Character, Integer> c = new HashMap<Character, Integer>();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (c.containsKey(ch)) {
                c.put(ch, c.get(ch) + 1);
            } else {
                c.put(ch, 1);
            }
        }

        Set<Character> a = c.keySet();
        for (Character q : a) {
            System.out.println(q + " = " + c.get(q));
        }
        
    }
}
