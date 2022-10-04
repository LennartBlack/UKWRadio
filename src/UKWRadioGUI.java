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
   //constructor for Radio GUI
    UKWRadioGUI() {
        super("UKWRadio");
        UKWRadio radio = new UKWRadio(2); //constructs a radio with 2 save Buttons
        this.addWindowFocusListener(new WindowCloseAction());
        //basic Layout for pop up radio
        this.setLayout(new GridLayout(4, 1));
            Label showFrequency = new Label("" + radio.deliverCurrentFrequency());
            Panel changeF = new Panel();
            Panel save1Panel = new Panel();
            Panel save2Panel = new Panel();
            this.add(showFrequency);
            this.add(changeF);
            this.add(save1Panel);
            this.add(save2Panel);

        //changeF Layout
        changeF.setLayout(new GridLayout(1,2));
        Button lowerFrequency = new Button("Lower frequency");
        Button raiseFrequency = new Button("Raise frequency");
        lowerFrequency.addActionListener(new LowerFrequencyAction(showFrequency, radio));
        raiseFrequency.addActionListener(new RaiseFrequencyAction(showFrequency, radio));
        changeF.add(lowerFrequency);
        changeF.add(raiseFrequency);

        //save1Panel
        save1Panel.setLayout(new GridLayout(1,3));
        Label name1 = new Label("Saved frequence 1");
        Button saveF1 = new Button("Save Frequence");
        Button changeF1 = new Button("Set Frequence");
        saveF1.addActionListener(new SaveFAction(showFrequency, radio, 0));
        changeF1.addActionListener(new SetFAction(showFrequency, radio, 0));
        save1Panel.add(name1);
        save1Panel.add(saveF1);
        save1Panel.add(changeF1);

        //save2Panel
        save2Panel.setLayout(new GridLayout(1,3));
        Label name2 = new Label("Saved frequence 2");
        Button saveF2 = new Button("Save Frequence");
        Button setF2 = new Button("Set Frequence");
        saveF2.addActionListener(new SaveFAction(showFrequency, radio, 1));
        setF2.addActionListener(new SetFAction(showFrequency, radio, 1));
        save2Panel.add(name2);
        save2Panel.add(saveF2);
        save2Panel.add(setF2);

        this.pack();
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UKWRadioGUI();
    }
}
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
        this.showFrequency.setText("" + this.radio.deliverCurrentFrequency());
    }
}
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
        this.showFrequency.setText("" + this.radio.deliverCurrentFrequency());
    }
}
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
        this.showFrequency.setText("" + this.radio.deliverCurrentFrequency());
    }
}
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
        this.showFrequency.setText("" + this.radio.deliverCurrentFrequency());
    }
}
class WindowCloseAction extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}