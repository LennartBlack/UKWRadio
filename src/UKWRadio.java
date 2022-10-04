public class UKWRadio {
    protected double minFrequency = 87.5;
    protected double maxFrequency = 108.0;
    private double currentFrequency = 87.5;
    protected double[] saveButtons;

    UKWRadio(int n){
        saveButtons = new double[n];
    }
    UKWRadio(){
        saveButtons = new double[3];}
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
    protected void saveFrequency(int n){
        saveButtons[n]=currentFrequency;}
    protected void setFrequency(int n){currentFrequency= saveButtons[n];}
}
