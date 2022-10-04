public class UKWRadio {
    private final double minFrequency = 87.5; //private - only for bordering currentFrequency
    private final double maxFrequency = 108.0; //private - only for bordering currentFrequency

    private double currentFrequency = 87.5; //private - but there is a getter
    protected double[] saveButtons; //represents Buttons that change the frequency to saved values

    //constructor
    UKWRadio(int n){
        saveButtons = new double[n];
    }

    //methods for the frequency
    protected double getFrequency(){
        return currentFrequency;
    }
    protected void lowerFrequency(){
        if(currentFrequency > minFrequency){
            currentFrequency-=0.5;
        }
    }
    protected void raiseFrequency(){
        if(currentFrequency < maxFrequency){
            currentFrequency += 0.5;
        }
    }

    //methods for save Buttons
    protected void saveFrequency(int n){
        saveButtons[n]=currentFrequency;}
    protected void setFrequency(int n){
        currentFrequency= saveButtons[n];
    }
}
