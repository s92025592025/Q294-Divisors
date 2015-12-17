//Daniel Wang
//12/17/2015
//This is the java code to solve Q294 in UVa online judge
//when the user enter a pair of numbers each in the range of 0 ~ 1000000000, this program can find out which 
//number within this range contains the most divisor

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt(); //how many data will there be
        List<Integer> prime = findAllPrime(); //store all the prime numbers
        for(int i = 0; i < times; i++){
            int start = sc.nextInt();  //the start of the range
            int end = sc.nextInt(); //the end of the range
            int max = 0, maxNum = 0; //max stores the amount of the most divisors,
                                    // maxNum stores the munber that has the maxium divisors
            for(int s = start; s <= end; s++){ //count through all the numbers insode the assigned range
                int count = 0, n = s, divs = 1; //count use to count the power of the primes,
                                                //s stores to n for calculating the factorization
                                                //and the divs can store the the amount of divisors
                for(int g = 0; g < prime.size() && prime.get(g) <= n; g++){ //check every prime that is 
                                                                            //smaller than the n
                    while(n % prime.get(g) == 0 && n != 0){
                        count++; //if can divide, count(power) add 1
                        n = n / prime.get(g); //change the n to the divided one
                    }
                    divs *= count + 1; //total divisor is the mutipication of all (power + 1)
                    count = 0; //reset count
                }
                if(divs > max){ //if found a bigger one, replace it
                    max = divs;
                    maxNum = s;
                }
            }
            

            System.out.println("Between " + start + " and " + end + ", " + maxNum + " has a maximum of " + max +" divisors.");
        }
            
    }

    //post: find out all the essential prime numbers to caluculate the total divisors, so only have to record till the 
    //      square root of the assigned range
    public static List<Integer> findAllPrime(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2); //first add 2 into the prime list since it is the exception of the prime numbers
        for(int i = 3; i <= Math.sqrt(1000000000); i++){
            boolean flag = true;
            for(int s = 2; s <= Math.sqrt(i); s++){
                if(i % s == 0){ //if any number besides one and i itself can fully divide i, i is not prime
                    flag = false;
                    break;
                }
            }
            if(flag){ //add i in the list only when i is a prime number
                list.add(i);
            }
        }

        return list;
    }
}