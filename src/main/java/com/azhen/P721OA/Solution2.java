package com.azhen.P721OA;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2 {
    class UF {
        private int[] id;
        private int[] size; // 保存树的大小
        private int mergeCount;  // 树合并的次数

        public UF(int n) {
            mergeCount = n;
            id = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i ++) {
                id[i] = i;
                size[i] = 0;
            }
        }

        /**
         * 查找数的根结点
         * @param p
         * @return
         */
        int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        int getMergeCount() {
            return mergeCount;
        }

        boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }

        void connect(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) {
                return ;
            }

            // 确保小树合并到大树
            if (size[i] < size[j]) {
                id[i] = j;
            } else if (size[i] > size[j]) {
                id[j] = i;
            } else {
                id[j] = i;
                size[i]++;
            }
            mergeCount --;
        }

        public int getGroupCount() {
            int sum = 0;
            int group = 0;
            for (int i = 0; i < id.length; i ++) {
                group = find(i);
                if (i == group) {
                    sum ++;
                }
            }
            return sum;
        }

        public boolean isGroup(int i) {
            return i == find(i);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UF uf = new UF(accounts.size());
        List<Set<String>> setList = new ArrayList<>();
       for (List<String> list : accounts) {
            Set<String> set = new HashSet<>();
            for (int i = 1; i < list.size(); i ++) {
                set.add(list.get(i));
            }
            setList.add(set);
        }


        for (int i = 0; i < accounts.size(); i ++) {
            for (int j = i + 1; j < accounts.size(); j ++) {
                Set<String> set1 = setList.get(i);
                Set<String> set2 = setList.get(j);
                for (String str : set2) {
                    if (set1.contains(str)) {
                        uf.connect(i,j);
                        break;
                    }
                }
            }
        }

        Comparator<String> comparator = (o1, o2)->  o1.compareTo(o2);
        TreeMap<Integer, TreeSet<String>> treeMap = new TreeMap<>();
        List<String> personList = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i ++) {
            List<String> list = accounts.get(i);
            String personName = list.get(0);
            int g = uf.find(i);
            TreeSet<String> treeSet = null;
            if (!treeMap.containsKey(g)) {
                treeSet = new TreeSet<>(comparator);
                treeMap.put(g, treeSet);
                personList.add(personName);
            } else {
                treeSet = treeMap.get(g);
            }

            for (int j = 1; j < list.size(); j ++) {
                treeSet.add(list.get(j));
            }
        }

        List<List<String>> results = new ArrayList<>();
        int count = 0;
        for (Map.Entry<Integer, TreeSet<String>> entry : treeMap.entrySet()) {
            List<String> result = new ArrayList<>();
            List<String> list = entry.getValue().stream().collect(Collectors.toList());

            result.add(personList.get(count));
            result.addAll(list);
            results.add(result);
            count ++;
        }
        return results;
    }

    public static void main1(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> data2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> data3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> data4 = Arrays.asList("Mary", "mary@mail.com");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);

        Solution2 solution = new Solution2();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main55(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("David","David0@m.co","David1@m.co","David2@m.co");
        List<String> data2 = Arrays.asList("David","David2@m.co","David3@m.co","David4@m.co","David5@m.co");
        datas.add(data1);
        datas.add(data2);

        Solution2 solution = new Solution2();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("David","David0@m.co","David1@m.co");
        List<String> data2 = Arrays.asList("David","David3@m.co","David4@m.co");
        List<String> data3 = Arrays.asList("David","David4@m.co","David5@m.co");
        List<String> data4 = Arrays.asList("David","David2@m.co","David3@m.co");
        List<String> data5 = Arrays.asList("David","David1@m.co","David2@m.co");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);

        Solution2 solution = new Solution2();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main22(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("Hanzo","Hanzo2@m.co","Hanzo3@m.co");
        List<String> data2 = Arrays.asList("Hanzo","Hanzo4@m.co","Hanzo5@m.co");
        List<String> data3 = Arrays.asList("Hanzo","Hanzo0@m.co","Hanzo1@m.co");
        List<String> data4 = Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo4@m.co");
        List<String> data5 = Arrays.asList("Hanzo","Hanzo7@m.co","Hanzo8@m.co");
        List<String> data6 = Arrays.asList("Hanzo","Hanzo1@m.co","Hanzo2@m.co");
        List<String> data7 = Arrays.asList("Hanzo","Hanzo6@m.co","Hanzo7@m.co");
        List<String> data8 = Arrays.asList("Hanzo","Hanzo5@m.co","Hanzo6@m.co");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);
        datas.add(data6);
        datas.add(data7);
        datas.add(data8);

        Solution2 solution = new Solution2();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main66(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co");
        List<String> data2 = Arrays.asList("Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co");
        List<String> data3 = Arrays.asList("Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co");
        List<String> data4 = Arrays.asList("Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co");
        List<String> data5 = Arrays.asList("Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);
        datas.add(data5);

        Solution2 solution = new Solution2();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    private void showResult(List<List<String>> results) {
        for (List<String> list : results) {
            for (String str : list) {
                System.out.printf(str + " ");
            }
            System.out.println();
        }
    }
}
