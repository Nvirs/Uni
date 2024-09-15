#include <iostream>
using namespace std;

const int N = 6;
int graph[N][N] = {
    { 0, 7, 9, 0, 0,14}, //0   
    { 7, 0,10,15, 0, 0}, //1   
    { 9,10, 0,11, 0, 2}, //2   
    { 0,15,11, 0, 6, 0}, //3   
    { 0, 0, 0, 6, 0, 9}, //4   
    {14, 0, 2, 0, 9, 0}  //5   
//    0  1  2  3  4  5
};
int mins[N];
int path[N];
bool done[N];

void init();
void printEdges();
void printMins();
void printPath(int, int);

int main() 
{
    init();
    printEdges();
    
    //Algoritmus
	int start = 0; //Innen indulva
	int dest = 4; //Ide tervezünk menni
	
	
	printMins();
    printPath(start, dest);
}

void init()
{
    for(int i = 0; i < N; i++)
    {
        done[i] = false;
		mins[i] = 99999;
		path[i] = -1;
    }
}
void printEdges()
{
    cout << "Edges:" << endl;
    for(int i = 0; i < N; i++)
    {
        int count = 0;
        for(int j = 0; j < N; j++)
        {
            if(graph[i][j] != 0)
            {
				cout << "(" << i << ")--"; 
                cout << graph[i][j];
                cout << "--(" << j << ") , ";
                count++;
            }
        }
        if(count > 0) cout << endl;
    }
    cout << "------" << endl;
}
void printMins()
{
    cout << "Mins:" << endl;
    
    for(int i = 0; i < N; i++)
    {
        cout << "[" << i << "]:" << mins[i] << ", ";
    }
    cout << endl;
}
void printPath(int start, int dest)
{
    cout << "Path (" << start << " to " << dest << "):" << endl;
    
    int v = dest;
    while(v != start && v != -1)
    {
        cout << v << " <- ";
        v = path[v];
    }
    
    if(v != -1)
    {
        cout << v << endl;
    }
    else
    {
        cout << "??? <- " << start << endl;
    }
}