public class UKWRadio {
    private double minFrequency = 87.5; //private - only for bordering currentFrequency
    private double maxFrequency = 108.0; //private - only for bordering currentFrequency

    private double currentFrequency = 87.5; //private - but there is a getter
    protected double[] saveButtons; //represents Buttons that change the frequency to saved values

    //constructors
    UKWRadio(int n){
        saveButtons = new double[n];
    } //constructs a radio with an individual amount of save buttons
    UKWRadio(){
        saveButtons = new double[3];}

    //methods for the frequency
    protected double deliverCurrentFrequency(){return currentFrequency;}
    protected void lowerFrequency(){
        if(currentFrequency == minFrequency){
        }
        else{
            currentFrequency-=0.5;
        }
    }
    protected void raiseFrequency(){
        if(currentFrequency==maxFrequency){
        }
        else {
            currentFrequency += 0.5;
        }
    }

    //methods for save Buttons
    protected void saveFrequency(int n){
        saveButtons[n]=currentFrequency;}
    protected void setFrequency(int n){currentFrequency= saveButtons[n];}
}
