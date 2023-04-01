#include <iostream>
#include "LiczbyPierwsze.hpp"
#include <string>
#include <vector>

using namespace std;

int main(int argc, char const *argv[]) {

    if(argc<=2){
        cout <<  "Za mała liczba argumentow, podaj conajmniej 2!\n";
        return 0;
    }

    int a;
    try{
        a=stoi(argv[1]);
    }
    catch(...){
        cout<<argv[1]<< " - Niepoprawny format rozmiaru tablicy!\n";
        return 0;
    }

    if(a<=2 || a>100000){
        cout << argv[1] << " - Niepoprawny zakres rozmiaru tablicy!";
        return 0;
    } else {
        LiczbyPierwsze myObj(a);

        for (int i=2;i<argc;i++){
            int b;
            try{
                b=stoi(string(argv[i]));
            }
            catch(...){
                cout << argv[i] << " - Niepoprawny format liczby!\n";
                continue;
            }
            if(b<=0 || b> myObj.listOfPrimeNumbers.size()){
                cout<<b<< " - Niepoprawny zakres liczby!\n";
                continue;
            } else {
                cout<<b<<" - "<<myObj.liczba(b)<<"\n";
            }
        }
    }

    
    return 0;





}
