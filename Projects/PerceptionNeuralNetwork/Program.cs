using System;

namespace ANDGatePerceptionNeuralNetwork
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Write("Enter Weight 1 = ");
            float w1 = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.Write("Enter Weight 2 = ");
            float w2 = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.Write("Enter Alpha  = ");
            float Alpha = float.Parse(Console.ReadLine());
            Console.WriteLine();
            Console.WriteLine("=================================== Ahmed Khalil Perception Neural Networks ===============================================================");
            int[] x1 = new int[] { 0, 0, 1, 1 };
            int[] x2 = new int[] { 0, 1, 0, 1 };
            int[] y = new int[] { 0, 0,0,  1 };
            Console.WriteLine("X1    X2   Y    W1     W2      Z    Delta       W1     W2");
            Console.WriteLine("==================================================================================================");
            int error = 1;
            while ( error  ==1)
            {
                error = 0;


                for (int j = 0; j < 4; j++)
                {

                    float z = x1[j] * w1 + x2[j] * w2;
                    int Delta = 0;
                    if (z <= 0.5)
                    {
                        z = 0;
                    }
                    else
                        z = 1;
                    if (z != y[j])
                        Delta = 1;
                    //int z = x1[j] * w1 + x2[j] * w2 < 0.5 ? 0 : 1 ;
                    //int Delta = z != y[j] ? 1 : 0;
                    if (Delta ==1)
                    {
                        error = 1;
                        Console.ForegroundColor = ConsoleColor.Red;
                    }
                    Console.Write("{0}      {1}     {2}     {3}     {4}     {5}     {6}", x1[j], x2[j], y[j], w1, w2, z, Delta);
                    if (Delta == 1)
                    {
                        w1 += Delta * Alpha * x1[j];
                        w2 += Delta * Alpha * x2[j];
                        if (w1 > 1)
                        {
                            w1 -= 1;
                        }
                        if (w2 > 1)
                        {
                            w2 -= 1;
                        }
                    }
                    Console.Write("     {0}      {1}", w1, w2);
                    Console.WriteLine();
                    Console.ForegroundColor = ConsoleColor.White;
                }
                Console.WriteLine("==============================================================================");
            }
        }
    }
}
