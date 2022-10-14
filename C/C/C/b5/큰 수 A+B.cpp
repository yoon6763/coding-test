#include <iostream>
#include <string.h>
using namespace std;

int main()
{
	char first[10002];
	char second[10002];
	cin >> first;
	cin >> second;

	int len1 = strlen(first);
	int len2 = strlen(second);

	int i;

	if (len1 < len2)
	{
		int def = len2 - len1;
		for (i = len1; i >= 0; i--)
			first[i + def] = first[i];
		for (i = 0; i < def; i++)
			first[i] = '0';
	}

	else if (len1 > len2)
	{
		int def = len1 - len2;
		for (i = len2; i >= 0; i--)
			second[i + def] = second[i];
		for (i = 0; i < def; i++)
			second[i] = '0';
	}

	for (i = strlen(first) - 1; i >= 0; i--)
	{
		first[i] = first[i] + second[i] - '0';
		if (first[i] - '0' >= 10)
		{
			first[i] = first[i] - 10;
			if (i == 0)
				cout << 1;
			else
				first[i - 1]++;
		}
	}

	cout << first;
}