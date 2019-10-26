using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NeutrosophicImplementation.FuzzySets
{
    public interface INeutrosophicSet
    {
         double Truth { get; set; }
         double Falsehood { get; set; }
         double Intermediancy { get; set; }
         INeutrosophicSet Complement();
        INeutrosophicSet Add(INeutrosophicSet set);
        INeutrosophicSet Multiply(INeutrosophicSet set);
        INeutrosophicSet AlphaMultiplication(double alpha);
        bool IsSubsetOf(INeutrosophicSet set);
         bool IsEqual(INeutrosophicSet set);
        double Score();
        double Accuracy();

         
    }
}