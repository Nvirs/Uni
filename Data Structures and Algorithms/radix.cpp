#include <iostream>
#include <string>
using namespace std;

const int N = 20;
const int L = 5;
const int C = 26;
string words[N];

void generateWords();
void printWords();

int main() 
{
	generateWords();
	printWords();
     
	//Rendezés...
	string temp[C][N];
	int cX[C];
	
	printWords();
}

void generateWords()
{
    words[0] = "kutya";
    words[1] = "divat";
    words[2] = "forma";
    words[3] = "malac";
    words[4] = "fuvar";
    words[5] = "rohan";
    words[6] = "alkat";
    words[7] = "kapar";
    words[8] = "kalap";
    words[9] = "torma";
    words[10] = "alkar";
    words[11] = "vakar";
    words[12] = "kapor";
    words[13] = "alkot";
    words[14] = "kutas";
    words[15] = "cseng";
    words[16] = "csend";
    words[17] = "borul";
    words[18] = "abrak";
    words[19] = "ablak";
}
void printWords()
{
    for(int i = 0; i < N; i++)
	{
		cout << words[i] << endl;
	}
	cout << "------" << endl;
}