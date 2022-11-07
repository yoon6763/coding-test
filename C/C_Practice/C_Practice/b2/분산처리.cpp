#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int n;

	cin >> n;

	long long a, b;
	int i;
	long long ab;

	for (i = 0; i < n; i++)
	{
		cin >> a;
		cin >> b;



		if (b == 0)
		{
		}

		else if ((b % 4) == 0)
			b = 4;
		else
			b = b % 4;

		ab = pow(a, b);
		ab = ab % 10;

		if (ab == 0)
			ab = 10;

		cout << ab << endl;

	}
}