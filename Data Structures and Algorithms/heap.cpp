#include<iostream>
#include<cstdlib>
#include<ctime>
#include<cmath>
using namespace std;

int N = 14;
int heap[100];

void heapRestore(int);
void heapDel(int);
void heapBuild();

void generateNumbers();
void printHeap();

int main() 
{
    generateNumbers();
    printHeap();
    
    heapBuild();
    printHeap();
    
    cout << "Kupacrendezés:" << endl;
    /*while(N > 0)
    {
        cout << heap[0] << " ";
        heapDel(0);
    }*/
}

void heapRestore(int x)
{

}
void heapDel(int x)
{
   
}
void heapBuild()
{
    for(int i = N - 1; i >= 0; i--)
    {
        heapRestore(i);
    }    
}

void generateNumbers()
{
    srand(time(NULL));
	
	for(int i = 0; i < N; i++)
	{
		heap[i] = rand() % 90 + 10;
	}
}
void printHeap()
{
    if(N > 0)
    {
        cout << "A kupac elemei:" << endl;

        int sep = 0;
        int block = 1;

        for(int i = 0; i < N; i++)
        {
            cout << heap[i] << " ";
            if(i == sep)
            {
                block *= 2;
                sep += block;
                cout << "| ";
            }
            else
            if(i % 2 == 0) cout << ", ";
        }
        cout << endl;
    }
    else cout << "A kupac üres" << endl;
}