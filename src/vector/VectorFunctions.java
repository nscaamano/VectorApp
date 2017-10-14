/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;


/**
 *
 * @author Nick
 */
public class VectorFunctions 
{
    
     double[] addVectors(double[] vectorA, double[] vectorB)
    {
        double[] returnArr = new double[3];
        
        for(int i = 0; i < returnArr.length; i++)
            returnArr[i] = vectorA[i] + vectorB[i];
        
        return returnArr;
            
    }
    
    //returns scalar
    double dotProduct(double[] vectorA, double[] vectorB)
    {
        double dot = 0.0;
        
        for(int i = 0; i < 3; i++)
            dot += (vectorA[i] * vectorB[i]);
        
        return dot;
    }
    
    double[] crossProduct(double[] vectorA, double[] vectorB)
    {
        //<i,k,k>
        //<0,1,2>
        double[] returnArr = {0,0,0};
        double[] addVector = new double[3];
        double[] subVector = new double[3];
        
        addVector[0] = vectorA[1] * vectorB[2]; //i
        addVector[1] = vectorA[2] * vectorB[0]; //j
        addVector[2] = vectorA[0] * vectorB[1]; //k
        
        
        subVector[0] = -1 * (vectorA[2] * vectorB[1]); //i
        subVector[1] = -1 * (vectorA[0] * vectorB[2]); //j
        subVector[2] = -1 * (vectorA[1] * vectorB[0]); //k
        
        returnArr = addVectors(addVector,subVector);
        
        return returnArr;
    }
    
   double VectorAngle(double[] vectorA, double[] vectorB)
    {
        double dot = dotProduct(vectorA,vectorB);
        double denom = VectorMagnitude(vectorA) * VectorMagnitude(vectorB);
        double rads = Math.acos(dot/denom);
        double roundOff = Math.round(rads * 100.0) / 100.0;
        return roundOff;
    }
     
    double RadiansToDegrees (double radians)
    {
        double degrees = radians * (180/Math.PI);
        double roundOff = Math.round(degrees * 100.0) / 100.0;
        return roundOff;
    }
    
    double VectorMagnitude(double[] vector)
    {
        double magnitude;
        magnitude = Math.sqrt((vector[0] * vector[0]) +
                              (vector[1] * vector[1]) +
                              (vector[2] * vector[2])); 
        
        double roundOff = Math.round(magnitude * 100.0) / 100.0;
                        
        return roundOff;
    }
    
    double[] VectorNormalization(double[] vector)
    {
        double[] normalization = new double[vector.length];
        for(int i =0 ; i < vector.length; i++)
        {
              double temp = vector[i]/(VectorMagnitude(vector));
              normalization[i] = Math.round(temp * 100.0) / 100.0;
        }
        
        return normalization;
    }
    
    double[] Projection (double[] vectorA, double[] vectorB)
    {
        double numerator = dotProduct(vectorA,vectorB);
        double denom = 0;
        for(int i =0; i < 3; i++)
            denom += vectorA[i] * vectorA[i];
        
        double[] projection = new double[3];
        double ratio = numerator/ denom;
        
        for(int i =0 ; i < 3; i++)
        {
          projection[i] =Math.round(vectorA[i] * ratio * 100.0) / 100.0; ;  
        }
        return projection;
    }
    //will only ever have length of 3. Constant time complexity
    void printVector(double[] vector)
    {
        for(int i = 0; i < vector.length; i++)
        {
            switch(i)
            {
                case 0 : 
                    System.out.println("i : " + vector[i]);
                    continue;
                case 1 : 
                    System.out.println("j : " + vector[i]);
                    continue;
                case 2: 
                    System.out.println("i : " + vector[i]);
                    continue;
                default :
                    System.out.println("error");       
            } //switch
        }
        
        System.out.println("");
        
        for(int i = 0; i < vector.length; i++)
        {
            if(i == 0)
                System.out.print("<" + vector[0] + ", ");
            else if(i == 1)
                System.out.print(vector[1] + ", ");
            else if(i == 2)
                System.out.print(vector[2] + ">");     
        }
        
        System.out.println("\n");
    } //printVector
    
   
}

   