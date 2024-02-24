using System;

class Program
{
    static void Main(string[] args)
    {
        string[] inputs = Console.ReadLine().Split();
        int a = int.Parse(inputs[0]);
        int b = int.Parse(inputs[1]);
        Console.WriteLine(a + b);
    }
}
