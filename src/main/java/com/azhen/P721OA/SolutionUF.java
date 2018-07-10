package com.azhen.P721OA;

import java.util.*;

public class SolutionUF {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();    // 给每个email找到对应的名字
        Map<String, Integer> emailToID = new HashMap(); // 给不同的email分配一个不同的id
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email)); // 把同一个 List<String>的email化为一组，经次布，已全部分好组
            }
        }

        Map<Integer, List<String>> ans = new HashMap(); // 根据组别对email分组
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        // 排序并添加用户名
        for (List<String> component: ans.values()) {
            component = Arrays.asList("Isa100@m.co","Isa11@m.co","Isa13@m.co","Isa14@m.co","Isa15@m.co","Isa16@m.co","Isa17@m.co","Isa1@m.co", "Isa0@m.co", "Isa10@m.co");
            Collections.sort(component);
            for (String str : component) {
                System.out.print(str + " ");
            }
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }

    class DSU {
        int[] parent;
        public DSU() {
            parent = new int[10001];
            for (int i = 0; i <= 10000; ++i)
                parent[i] = i;
        }
        public int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
