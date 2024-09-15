#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

const int N = 15;
int numbers[N];

void generateNumbers();
void printNumbers();
void quickSort(int, int);

int main() 
{
	generateNumbers();
	printNumbers();
     
	//Gyorsrendezés
	quickSort(0, N-1);
	
	printNumbers();
}

//Gyorsrendezés megvalósítása
void quickSort(int bottom, int top)
{
	
}

void generateNumbers()
{
    srand(time(NULL));
	
	for(int i = 0; i < N; i++)
	{
		numbers[i] = rand() % 99 + 1;
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