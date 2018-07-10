package com.azhen.P721OA;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
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
        Comparator<String> comparator = (o1, o2)->  o1.compareTo(o2);
        for (int i = 0; i < accounts.size(); i ++) {
            if (uf.isGroup(i)) {
                for (int j = i + 1; j < accounts.size(); j ++) {
                    List<String> firstAccounts = accounts.get(i);
                    int ig = i;
                    if (firstAccounts == null) {
                        ig = uf.find(i);
                        firstAccounts = accounts.get(ig);
                    }
                    TreeSet<String> treeSet = new TreeSet(comparator);
                    String personName = firstAccounts.get(0);
                    addTreeSet(firstAccounts, treeSet);

                    int jg = uf.find(j);
                    List<String> secondAccounts = accounts.get(jg);
                    if (same(firstAccounts, secondAccounts)) {
                        uf.connect(ig,jg);
                        addTreeSet(secondAccounts, treeSet);
                        List<String> result = new ArrayList<>();
                        result.add(personName);
                        result.addAll(treeSet.stream().collect(Collectors.toList()));

                        int jg1 = uf.find(jg);
                        if (ig == jg1) {
                            accounts.set(jg, null);
                            accounts.set(ig, result);
                        } else {
                            accounts.set(ig, null);
                            accounts.set(jg, result);
                        }
                    }
                }
            }

            List<String> firstAccounts = accounts.get(i);
            if (firstAccounts != null) {
                TreeSet<String> treeSet = new TreeSet(comparator);
                String personName = firstAccounts.get(0);
                addTreeSet(firstAccounts, treeSet);

                List<String> result = new ArrayList<>();
                result.add(personName);
                result.addAll(treeSet.stream().collect(Collectors.toList()));
                accounts.set(i, result);
            }
        }

        accounts = accounts.stream().filter(elem -> elem != null).collect(Collectors.toList());
        return accounts;
    }

    private void addTreeSet(List<String> list, TreeSet treeSet) {
        for (int i = 1; i < list.size(); i ++) {
            String str = list.get(i);
            treeSet.add(str);
        }
    }

    private boolean same(List<String> firstAccounts, List<String> secondAccounts) {
        for (int i = 1; i < firstAccounts.size(); i ++) {
            String a = firstAccounts.get(i);
            for (int j = 1; j < secondAccounts.size(); j ++) {
                String b = secondAccounts.get(j);
                if (a.equals(b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main33(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com");
        List<String> data2 = Arrays.asList("John", "johnnybravo@mail.com");
        List<String> data3 = Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com");
        List<String> data4 = Arrays.asList("Mary", "mary@mail.com");
        datas.add(data1);
        datas.add(data2);
        datas.add(data3);
        datas.add(data4);

        Solution solution = new Solution();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main3(String[] args) {
        List<List<String>> datas = new ArrayList<>();
        List<String> data1 = Arrays.asList("David","David0@m.co","David1@m.co","David2@m.co");
        List<String> data2 = Arrays.asList("David","David2@m.co","David3@m.co","David4@m.co","David5@m.co");
        datas.add(data1);
        datas.add(data2);

        Solution solution = new Solution();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main4(String[] args) {
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

        Solution solution = new Solution();
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

        Solution solution = new Solution();
        List<List<String>> results = solution.accountsMerge(datas);
        solution.showResult(results);
    }

    public static void main(String[] args) {
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

        Solution solution = new Solution();
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
