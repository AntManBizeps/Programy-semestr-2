public class Board {
    MyThreadThing threadsChart[][];
    Square squaresChart[][];
    public Board(int n, int m){
        threadsChart = new MyThreadThing[m][n];
        squaresChart = new Square[m][n];
    }
}
