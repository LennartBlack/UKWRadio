import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UKWRadioGUI extends Frame {
    public static void main(String[] args) {
        new UKWRadioGUI();
    }
   //constructor for Radio GUI
    UKWRadioGUI() {
        super("UKWRadio");
        UKWRadio radio = new UKWRadio(2); //constructs a radio with 2 save Buttons
        this.addWindowFocusListener(new WindowCloseAction()); //?
        //outter Layout for pop up radio/ first row
        this.setLayout(new GridLayout(4, 1));
            Label showFrequency = new Label("" + radio.getFrequency());
            Panel changeF = new Panel();
            Panel save1Panel = new Panel();
            Panel save2Panel = new Panel();
            this.add(showFrequency);
            this.add(changeF);
            this.add(save1Panel);
            this.add(save2Panel);

        //inner Layout/ second row
        changeF.setLayout(new GridLayout(1,2));
        Button lowerFrequency = new Button("Lower frequency");
        Button raiseFrequency = new Button("Raise frequency");
        lowerFrequency.addActionListener(new LowerFrequencyAction(showFrequency, radio));
        raiseFrequency.addActionListener(new RaiseFrequencyAction(showFrequency, radio));
        changeF.add(lowerFrequency);
        changeF.add(raiseFrequency);

        //inner Layout/ third row
        save1Panel.setLayout(new GridLayout(1,3));
        Label name1 = new Label("Saved frequency 1");
        Button saveF1 = new Button("Save Frequency");
        Button changeF1 = new Button("Set Frequency");
        saveF1.addActionListener(new SaveFAction(showFrequency, radio, 0));
        changeF1.addActionListener(new SetFAction(showFrequency, radio, 0));
        save1Panel.add(name1);
        save1Panel.add(saveF1);
        save1Panel.add(changeF1);

        //inner Layout/ fourth row
        save2Panel.setLayout(new GridLayout(1,3));
        Label name2 = new Label("Saved frequency 2");
        Button saveF2 = new Button("Save Frequency");
        Button setF2 = new Button("Set Frequency");
        saveF2.addActionListener(new SaveFAction(showFrequency, radio, 1));
        setF2.addActionListener(new SetFAction(showFrequency, radio, 1));
        save2Panel.add(name2);
        save2Panel.add(saveF2);
        save2Panel.add(setF2);

        this.pack();
        this.setVisible(true);
    }
}
// ActionListener classes
//SetFAction sets the radio on saved frequency
class SetFAction implements ActionListener{
    Label showFrequency;
    UKWRadio radio;
    int Button;
    SetFAction(Label f, UKWRadio r, int index){
        this.showFrequency = f;
        this.radio = r;
        this.Button = index;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        radio.setFrequency(Button);
        this.showFrequency.setText("" + this.radio.getFrequency());
    }
}
//SaveFAction saves current frequency
class SaveFAction implements ActionListener{
    Label showFrequency;
    UKWRadio radio;
    int Button;
    SaveFAction(Label f, UKWRadio r, int index){
        this.showFrequency = f;
        this.radio = r;
        this.Button = index;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        this.radio.saveFrequency(this.Button);
        this.showFrequency.setText("" + this.radio.getFrequency());
    }
}
//Lowers current frequency by 0.5Mhz
class LowerFrequencyAction implements ActionListener {
    Label showFrequency;
    UKWRadio radio;
    LowerFrequencyAction(Label f, UKWRadio r) {
        this.showFrequency = f;
        this.radio = r;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        this.radio.lowerFrequency();
        this.showFrequency.setText("" + this.radio.getFrequency());
    }
}
//Raises current frequency by 0.5Mhz
class RaiseFrequencyAction implements ActionListener {
    Label showFrequency;
    UKWRadio radio;
    RaiseFrequencyAction(Label f, UKWRadio r) {
        this.showFrequency = f;
        this.radio = r;
    }
    @Override
    public void actionPerformed(ActionEvent ev) {
        this.radio.raiseFrequency();
        this.showFrequency.setText("" + this.radio.getFrequency());
    }
}
//?
class WindowCloseAction extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}