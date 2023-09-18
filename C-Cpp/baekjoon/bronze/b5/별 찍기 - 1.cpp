#include <iostream>
using namespace std;

int main()
{
	int num;
	cin >> num;

	int i, k;

	for (k = 0; k < num; k++)
	{
		for (i = 0; i <= k; i++)
		{
			cout << "*";
		}
		cout << endl;
	}
}