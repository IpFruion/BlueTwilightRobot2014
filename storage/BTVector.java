package bt.storage;

/**
 * Creates a Vector
 * 
 * @author Derrick Lockwood 
 * @version Feb 26
 */
public class BTVector
{
    private double i;
    private double j;
    
    /**
     * Constructor for Vector class that uses the terminal form to define a vector
     * 
     * @param I Value of the x of the terminal point
     * @param J Value of the y of the terminal point
     */
    public BTVector (double i, double j)
    {
        this.i = i;
        this.j = j;
    }
    
    /**
     * Rounds a number to the hundreths place. Used only within Vector
     *
     * @param d is the number to round
     * @return The number rounded to the 100ths
     */
    private double roundHundred(double d)
    {
        d = Math.floor(d*100);
        d = d/100;
        return d;
    }
    
    /**
     * Constructor for Vector class that uses the directional and magnitude form to define a vector
     * 
     * @param Mag Value of the magnitude of the vector
     * @param Angle The direction of the vector
     * @param isDegrees Whether the angle is in degree or radians, true if degrees, false if radians
     */
    public BTVector (double magnitude, double angle, boolean isDegrees)
    {
        double answeri;
        double answerj;
        
        if (isDegrees)
        {
            answeri = magnitude*Math.cos(Math.toRadians(angle));
            answerj = magnitude*Math.sin(Math.toRadians(angle));
        }
        else
        {
            answeri = magnitude*Math.cos(angle);
            answerj = magnitude*Math.sin(angle);
        }
        i = answeri;
        j = answerj;
    }
    
    public double getMagnitude()
    {
        return roundHundred(Math.sqrt((i*i)+(j*j)));
    }
    
    public double getI()
    {
        return i;
    }
    
    public double getJ()
    {
        return j;    
    }
    
    public double getAngleDegreeXAxes()
    {
        double inverseTan;
        inverseTan = BTVector.aTan(j/i);
        inverseTan += Math.PI;
        return roundHundred(Math.toDegrees(inverseTan));   
    }
    
    public double getAngleRadianXAxes()
    {
        double inverseTan;
        inverseTan = BTVector.aTan(j/i);
        inverseTan += Math.PI;
        return roundHundred(inverseTan);
    }
    
    public static BTVector getResultantVector(BTVector v1, BTVector v2)
    {
        BTVector result;
        double resultI;
        double resultV;
        
        resultI = v2.getI() + v1.getI();
        resultV = v2.getJ() + v1.getJ();
        
        result = new BTVector(resultI, resultV);
        return result;
    }
    
    public void setI(double itemp)
    {
        j = itemp;
    }
    
    public void setJ(double jtemp)
    {
        j = jtemp;
    }
    
    public String toString()
    {
        return "Vector: "+i+"i+"+j+"j";
    }
    
    public static double getDotProduct(BTVector v1, BTVector v2)
    {
        double resultI;
        double resultJ;
        
        resultI = v1.getI() * v2.getI();
        resultJ = v1.getJ() * v2.getJ();
        
        return resultI+resultJ;
    }
    public static double getAngleBetweenVector(BTVector v1, BTVector v2, boolean isDegree)
    {
        double answer;
        
        answer = BTVector.aCos(BTVector.getDotProduct(v1,v2)/(v1.getMagnitude()*v2.getMagnitude()));
        if (isDegree)
        {
            answer = Math.toDegrees(answer);
        }
        
        return answer;
    }
    
    public BTVector getUnitVector()
    {
        double resultI;
        double resultJ;
        BTVector result;
        
        resultI = 1*Math.cos(getAngleRadianXAxes());
        resultJ = 1*Math.sin(getAngleRadianXAxes());
        result = new BTVector(resultI, resultJ);
        
        return result;
    }
    
    public BTVector[] getOrthogonalVectors(BTVector w)
    {
        BTVector[] vArray = new BTVector[3];
        BTVector projwV = getProjection(w);
        BTVector v = new BTVector(i,j);
        BTVector secondVector;
        
        secondVector = BTVector.subtractVector(this,projwV);
        vArray[0] = v;
        vArray[1] = projwV;
        vArray[2] = secondVector;
        
        return vArray;
    }
    
    public static BTVector subtractVector(BTVector v1, BTVector v2)
    {
        double resultI;
        double resultJ;
        BTVector result;
        
        resultI = v1.getI()-v2.getI();
        resultJ = v1.getJ()-v2.getJ();
        result = new BTVector(resultI, resultJ);
        
        return result;
    }
    public BTVector getProjection(BTVector w)
    {
        BTVector projwV;
        double scalarVal = 0;
        
        //scalarVal = (getDotProduct(w)/(w.getMagnitude()*w.getMagnitude()));
        projwV = new BTVector(scalarVal*w.getI(),scalarVal*w.getJ());
        return projwV;
    }
    
    public double getWork(double Forcemag)
    {
        double result;
        
        result = Forcemag*getMagnitude()*Math.cos(getAngleRadianXAxes());
        
        return result;
    }
    public static double aCos(double x)
    {
        double x3 = x*x*x;
        double x5 = x3*x*x;
        double x7 = x5*x*x;
        
        return (Math.PI/2)-x-(x3/6)-((3*x5)/40)-((5*x7)/112);
    }
    public static double aTan(double x)
    {
        double x3 = x*x*x;
        double x5 = x3*x*x;
        double x7 = x5*x*x;
        return x-((x3)/3)+((x5)/5)-((x7)/7);
    }
}
