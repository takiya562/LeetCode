package com.takiya;

import java.util.HashMap;
import java.util.List;

public class LeetCode_399 {
    private class UnionSet {
        private HashMap<String, String> father;
        private HashMap<String, Double> ratio;

        public UnionSet() {
            father = new HashMap<>();
            ratio = new HashMap<>();
        }

        public String Find(String x) {
            while (!father.get(x).equals(x))
                x = father.get(x);
            return x;
        }

        public void init(String x) {
            if (!father.containsKey(x)) {
                father.put(x, x);
                ratio.put(x, 1.0);
            }
        }

        public void Union(String x, String y, double value) {
            init(x);
            init(y);
            String rootX = Find(x);
            String rootY = Find(y);
            if (rootX.equals(rootY))    return;
            father.put(rootX, rootY);
            ratio.put(rootX, value * (cal(y) / cal(x)));
        }

        public double cal(String x) {
            double res = ratio.get(x);
            while(!father.get(x).equals(x)) {
                x = father.get(x);
                res *= ratio.get(x);
            }
            return res;
        }

        public boolean contains(String x) {
            return father.containsKey(x);
        }

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        UnionSet us = new UnionSet();
        for (int i = 0; i < values.length; ++i) {
            List<String> equation = equations.get(i);
            us.Union(equation.get(0), equation.get(1), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); ++i) {
            List<String> query = queries.get(i);
            String x = query.get(0);
            String y = query.get(1);
            if (!us.contains(query.get(0)) || !us.contains(query.get(1)) || !us.Find(x).equals(us.Find(y)))
                ans[i] = -1;
            else
                ans[i] = us.cal(x) / us.cal(y);
        }
        return ans;
    }
}
