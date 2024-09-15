#include <iostream>
#include <cstdlib>
#include <ctime>
using namespace std;

const int M = 100;
const int N = 15;
int numbers[N];
int result[N];

void generateNumbers();
void printNumbers(int[]);

int main() 
{
	generateNumbers();
	printNumbers(numbers);
     
	//Rendezés...
	
	printNumbers(result);
}

void generateNumbers()
{
    srand(time(NULL));
	
	for(int i = 0; i < N; i++)
	{
		numbers[i] = rand() % (M - 1) + 1;
	}
}
void printNumbers(int array[])
{
    for(int i = 0; i < N; i++)
	{
		cout << array[i] << " ";
	}
	cout << endl;
}