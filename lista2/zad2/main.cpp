#include <iostream>
#include <vector>
#include <string>
#include "WierszTrojkataPascala.hpp"

using namespace std;

int main(int argc, char const *argv[])
{
    int a;
    int b;

    if(argc<=2){
        cout <<  "Za mała liczba argumentow, podaj conajmniej 2!\n";
        return 0;
    }

    try {
        a=stoi(argv[1]);
    } catch (...) {
        cout << argv[1] << " - Niepoprawny format numeru wiersz!\n";
    }

    if(a<0 || a>100000){
        cout << argv[1] << " - Niepoprawny zakres numeru wiersza!\n";
    } else {
        WierszTrojkataPascala myObj(a);
        for(int i=2; i<argc; i++){
            try {
                b=stoi(argv[i]);
            } catch (...) {
                cout << argv[i] << " - Niepoprawny format!\n";
                continue;
            }
                
            if(b>=0 && b<myObj.TriangleRow.size()){
                cout << b << " - " << myObj.wspolczynnik(b) << "\n";
            } else{
                cout << argv[i] << " - Niepoprawny zakres!\n";
                continue;
            }
        }
    }
    return 0;
}
        

