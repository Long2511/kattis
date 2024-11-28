/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14752288">Relocation</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.61
 */

package Week1.Task6.H;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Relocation {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] locations = new int[n+1];
        ArrayList<Integer> ans = new ArrayList<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i=1;i<n+1;i++){
            locations[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            
            if (type == 1){
                int company = Integer.parseInt(st.nextToken());
                int new_lo = Integer.parseInt(st.nextToken());
                locations[company] = new_lo;
            }
            
            if (type == 2){
                int company_1 = Integer.parseInt(st.nextToken());
                int company_2 = Integer.parseInt(st.nextToken());
                int distance = Math.abs(locations[company_1]-locations[company_2]); 
                ans.add(distance);
            }
        }
        
        for (int distance : ans){
            System.out.println(distance);
        }
        br.close();
    }
}