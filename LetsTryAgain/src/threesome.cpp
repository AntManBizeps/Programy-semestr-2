#include <iostream>
#include <vector>
#include <string>

using namespace std;

class WierszTrojkataPascala{
    public:
        WierszTrojkataPascala(int n); // constructor
        int wspolczynnik(int m);

        std::vector<int> TriangleRow;

};


WierszTrojkataPascala::WierszTrojkataPascala(int n){
    TriangleRow.push_back(1);
    for(int k=1; k<n; k++){
        int x;
        int nPower=1;
        int kPower=1;
        for(int i=0; i<k; i++){
            nPower *= (n-i);
        }
        for(int j=1; j<=k; j++){
            kPower *= j;
        }
            
        x=nPower/kPower;
            
        TriangleRow.push_back(x);
    }
    TriangleRow.push_back(1);
}

int WierszTrojkataPascala::wspolczynnik(int m){
    return TriangleRow.at(m);
}

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
        

