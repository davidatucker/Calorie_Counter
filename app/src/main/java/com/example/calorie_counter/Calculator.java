package com.example.calorie_counter;

public class Calculator {

    private float time_spent;
    private float weight;
    private float MET;

    public Calculator(float newTime_spent, float newWeight ) {
        setTimeSpent( newTime_spent );
        setWeight( newWeight );
    }

    public float getTime_spent( ) {
        return time_spent;
    }

    public float getWeight( ) {
        return weight;
    }

    public void setTimeSpent( float newTime_spent ) {
        if( newTime_spent > 0 )
            time_spent = newTime_spent;
        time_spent = time_spent / (float)60;
    }

    public void setWeight( float newWeight ) {
        if( newWeight > 0 )
            weight = newWeight;
        //convert to kg
        weight = (weight / (float)2.2);
    }

    public void setMET( float newMET ) {
        if( newMET > 0 )
            MET = newMET;
    }


    public float CaloriesUsed( )
    {
        return (MET * weight * time_spent);
    }

}
