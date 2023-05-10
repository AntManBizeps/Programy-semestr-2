#include <iostream>
#include <vector>
#include "WierszTrojkataPascala.hpp"

using namespace std;



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
