#include <vector>

std::vector<int> SieveOfEratosthenes(int n);

class LiczbyPierwsze{
    // private:
    //     std::vector<int> listOfPrimeNumbers;

     public: 
        LiczbyPierwsze(int n); // constructor
        int liczba(int m);

        // std::vector<int> getListOfPrimeNumbers(){
        //     return listOfPrimeNumbers;
        // }

        std::vector<int> listOfPrimeNumbers;

};