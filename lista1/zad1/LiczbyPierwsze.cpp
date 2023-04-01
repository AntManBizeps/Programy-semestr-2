#include <iostream>
#include <vector>
#include <bits/stdc++.h>
#include "LiczbyPierwsze.hpp"

using namespace std;

// vector<int> SieveOfEratosthenes(int n);

//class LiczbyPierwsze {                          //
    // public: 
    //     LiczbyPierwsze(int n); // constructor
    //     int liczba(int m);
    // private:
    //     vector<int> listOfPrimeNumbers;
//};

LiczbyPierwsze::LiczbyPierwsze(int n){
    listOfPrimeNumbers = SieveOfEratosthenes(n);

}


vector<int> SieveOfEratosthenes(int n)
{
    bool prime[n+1] = {true};
    memset(prime, true, sizeof(prime));
 
    for (int p=2; p*p<=n; p++)
    {
        // If prime[p] is not changed, then it is a prime
        if (prime[p] == true)
        {
            // Update all multiples of p
            for (int i=p*2; i<=n; i += p)
                prime[i] = false;
        }
    }
    
    vector<int> arrayPrimeNumbers;

    for(int i=2; i<=n; i++){
        if(prime[i]){
            arrayPrimeNumbers.push_back(i);
        }
    }

    return arrayPrimeNumbers;
    
}

int LiczbyPierwsze::liczba(int m){
    return listOfPrimeNumbers.at(m-1);


}