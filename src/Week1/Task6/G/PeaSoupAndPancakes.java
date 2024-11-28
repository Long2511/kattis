/**
 * Advanced Object Oriented Programming with Java, WiSe 2023/2024
 * Problem: <a href="https://open.kattis.com/contests/v499w5/submissions/14752466">Pea Soup and Pancakes	</a>
 * @author Thanh Phuc Le
 *
 * Method : Ad-Hoc
 * Status : Accepted
 * Runtime: 0.04
 */

package Week1.Task6.G;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PeaSoupAndPancakes {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        String ans = "Anywhere is fine I guess";
        
        for (int i=0;i<n;i++){

            int x = Integer.parseInt(br.readLine());
            String resname = br.readLine();
            boolean ps, pc;
            ps = pc = false;
            
            for (int j=0;j<x;j++){
                String menu = br.readLine();
                if (menu.equals("pea soup")){
                    ps = true;
                }
                if (menu.equals("pancakes")){
                    pc = true;
                }
            }
            
            if (ps && pc){
                ans = resname;
                break;
            }
        }
        System.out.println(ans);
        br.close();
    }
}