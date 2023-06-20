package graph;

import java.util.Arrays;

/**
 * Leetcode 997
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 * You are given an array trust where trust[i] = [ai, bi] representing that
 * the person labeled ai trusts the person labeled bi. If a trust relationship does
 * not exist in trust array, then such a trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */

public class FindTheTownJudge {

    public static void main(String[] args) {
        int[][] twoDArr = {{1,3},{2,3},{3,4}, {1,4},{2,4}};

        System.out.println(findTheTownJudge(4, twoDArr));

    }

    public static int findTheTownJudge(int n, int[][] trust){
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for (int[] pair : trust){
            int firstPerson = pair[0];
            int secondPerson = pair[1];
            outDegree[firstPerson]++;
            inDegree[secondPerson]++;
        }

        for(int i = 0; i <= n; i++){
            if(inDegree[i] == n - 1 && outDegree[i] == 0){
                return i;
            }
        }
        return -1;

    }

}
