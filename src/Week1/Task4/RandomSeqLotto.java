package Week1.Task4;

import java.util.HashSet;
import java.util.Random;

public class RandomSeqLotto {
        public static void main(String[] args) {
            HashSet<Integer> lottoNumber = new HashSet<>();
            Random random = new Random();
            while (lottoNumber.size() < 6){
                int randomNumber = 1 + random.nextInt(49);
                lottoNumber.add(randomNumber);
            }
            for (int number : lottoNumber){
                System.out.println(number + " ");
            }
    }
}
