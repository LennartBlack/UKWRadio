import java.awt.*;

public class UKWRadioGUI extends Frame {
    UKWRadioGUI() {
        super("UKWRadio");
        UKWRadio radio = new UKWRadio(2);
        this.setLayout(new GridLayout(4, 1));
            Label showFrequency = new Label("" + radio.deliverCurrentFrequency());
            Panel changeF = new Panel();
            Panel save1Panel = new Panel();
            Panel save2Panel = new Panel();
            this.add(showFrequency);
            this.add(changeF);
            this.add(save1Panel);
            this.add(save2Panel);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new UKWRadio();
    }
}
