using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace NeutrosophicImplementation.FuzzySets
{
    public class SingleValuedNeutrosophicNumber : INeutrosophicSet
    {
        public string Id { get; set; }

        public double Truth {
            get
            {
                return Truth;
            }

            set {

                if (value <= 1 && value >= 0)
                {
                    Truth = value;
                }
                else
                {
                    new ArgumentOutOfRangeException("Out of Scope , The Truth factor between 1 and 0");
                }

            } }
        public double Intermediancy
        {
            get
            {
                return Intermediancy;
            }

            set
            {

                if (value <= 1 && value >= 0)
                {
                    Intermediancy = value;
                }
                else
                {
                    new ArgumentOutOfRangeException("Out of Scope , The Intermediancy factor between 1 and 0");
                }

            }
        }
        public double Falsehood
        {
            get
            {
                return Falsehood;
            }

            set
            {

                if (value <= 1 && value >= 0)
                {
                    Falsehood = value;
                }
                else
                {
                    new ArgumentOutOfRangeException("Out of Scope , The Truth factor between 1 and 0");
                }

            }
        }
        public SingleValuedNeutrosophicNumber(double truth, double intermediancy, double falsehood)
        {
            this.Id = Guid.NewGuid().ToString();
            Truth = truth;
            Falsehood = falsehood;
            Intermediancy = intermediancy;
        }

        public INeutrosophicSet Complement() => new SingleValuedNeutrosophicNumber(Falsehood, 1 - Intermediancy, Truth);
    

        public bool IsSubsetOf(INeutrosophicSet set) =>Truth <= set.Truth && Intermediancy >= set.Intermediancy && Falsehood >= set.Falsehood;
      

        public bool IsEqual(INeutrosophicSet set) => (IsSubsetOf(set) && set.IsSubsetOf(this));
           

        public INeutrosophicSet Add(INeutrosophicSet set) =>
            new SingleValuedNeutrosophicNumber (
               Truth= Truth + set.Truth - Truth * set.Truth,
               Intermediancy = Intermediancy* set.Intermediancy,
               Falsehood =Falsehood*set.Falsehood
                );

        public INeutrosophicSet Multiply(INeutrosophicSet set) =>
            new SingleValuedNeutrosophicNumber(
                Truth = Truth * set.Truth,
                Intermediancy = Intermediancy + set.Intermediancy - Intermediancy * set.Intermediancy,
                Falsehood = Falsehood + set.Falsehood - Falsehood * set.Falsehood
                );

        public INeutrosophicSet AlphaMultiplication(double alpha) =>
            new SingleValuedNeutrosophicNumber(
            Truth = 1 - Math.Pow(1 - Truth, alpha),
            Intermediancy = Math.Pow(Intermediancy, alpha),
            Falsehood = Math.Pow(Falsehood, alpha)
            );

        public double Score() => (2 + Truth - Intermediancy - Falsehood) / 3;

        public double Accuracy() => Truth - Falsehood;

        public bool Ranking(INeutrosophicSet set)
        {
            if (Score()> set.Score())
            {
                return true;
            }

            if (Score()==set.Score() && Accuracy() > set.Accuracy())
	        {
                return true;

            }
            if (this.Score()==set.Score() && Accuracy() == set.Accuracy())
	        {
                return true;
	        }
            return false;
        }

    }
}
