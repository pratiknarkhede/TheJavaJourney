package com.pratik.thejavajourney.dsa.greedy;

import java.util.Arrays;

public class AssignReviews {
    public static void main(String[] args) {
        int[] g = {1, 5, 3, 3, 4};
        int[] s = {4, 2, 1, 2, 1, 3};
        AssignReviews assignReviews = new AssignReviews();
        int contentChildren = assignReviews.findContentChildren(g, s);
        System.out.println(contentChildren);
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int l = 0;
        int r = 0;
        while (l < g.length && r < s.length) {
            if (g[l] <= s[r]) {
                ans++;
                g[l] = -1;
                s[l] = -1;
                l++;
                r++;
            } else {
                r++;
            }
        }

        return ans;
    }
}
