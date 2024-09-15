#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

const int N = 15;
int numbers[N];

void generateNumbers();
void printNumbers();

int main() 
{
	generateNumbers();
	printNumbers();
     
	//Rendezés...
	
	printNumbers();
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