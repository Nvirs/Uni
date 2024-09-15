#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

const int N = 15;
int numbers[N];

void generateNumbers(bool);
void printNumbers();
void mergeSort(int, int);

int main() 
{
	generateNumbers(false);
	printNumbers();
     
	//Összefésülő rendezés
	mergeSort(0, N-1);
	
	printNumbers();
}

//Összefésülő rendezés megvalósítása
void mergeSort(int bottom, int top)
{
	int tmp[N];
}

void generateNumbers(bool twoHalf)
{
    srand(time(NULL));
	
	for(int i = 0; i < N; i++)
	{
	    if(twoHalf)
	    {
	        int mid = (N - 1) / 2 + 1;
	        if(i == 0 || i == mid)
	        {
	            numbers[i] = rand() % 12 + 1;
	        }
	        else
	        {
	            numbers[i] = numbers[i - 1] + rand() % 12 + 1;
	        }
	    }
	    else
	    {
		    numbers[i] = rand() % 99 + 1;
	    }
	}
}
void printNumbers()
{
    for(int i = 0; i < N; i++)
	{
		cout << numbers[i] << " ";
	}
	cout << endl;
}