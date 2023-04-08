import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panou2 extends JFrame {
    ArrayList<Angajat> angajati = new ArrayList<>();
    ArrayList<Angajat> prezenti = new ArrayList<>();
    public Panou2(){
        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 900);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titlu = new JLabel("BOSH");
        titlu.setBounds(300, 50, 500, 50);
        Font font = new Font(Font.SERIF, Font.ITALIC, 50);
        titlu.setFont(font);
        panel.add(titlu);

        JLabel labelNume = new JLabel("Numele angajatului");
        labelNume.setBounds(50, 150, 200, 30);
        panel.add(labelNume);

        JTextField textFieldNume = new JTextField();
        textFieldNume.setBounds(200, 150, 200, 30);
        panel.add(textFieldNume);

        JLabel labelPrenume = new JLabel("Prenumele angajatului");
        labelPrenume.setBounds(50, 200, 200, 30);
        panel.add(labelPrenume);

        JTextField textFieldPrenume = new JTextField();
        textFieldPrenume.setBounds(200, 200, 200, 30);
        panel.add(textFieldPrenume);

        JLabel labelID = new JLabel("ID-ul angajatului");
        labelID.setBounds(50, 250, 200, 30);
        panel.add(labelID);

        JTextField textFieldID = new JTextField();
        textFieldID.setBounds(200, 250, 200, 30);
        panel.add(textFieldID);

        JCheckBox checkBoxConcediu = new JCheckBox("Concediu");
        checkBoxConcediu.setBounds(50, 300, 200, 30);
        panel.add(checkBoxConcediu);

        JList listaAngajati = new JList<>();
        listaAngajati.setBounds(50, 450, 300, 400);
        panel.add(listaAngajati);

        JList listaAngajatiPrezenti = new JList<>();
        listaAngajatiPrezenti.setBounds(450, 450, 300, 400);
        panel.add(listaAngajatiPrezenti);

        JButton adaugaAngajat = new JButton("Adauga angajat");
        adaugaAngajat.setBounds(50, 350, 200, 30);
        adaugaAngajat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Angajat angajat = null;
                String nume = textFieldNume.getText();
                String prenume = textFieldPrenume.getText();
                boolean conceddiu = checkBoxConcediu.isSelected();
                int id = 0;
                boolean found = false;
                try {
                    id = Integer.parseInt(textFieldID.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id-ul trebuie sa fie un numar", "Inset Error", JOptionPane.ERROR_MESSAGE);
                    throw new IllegalArgumentException("idAngajat must be a number");
                }
                for(int i = 0; i < angajati.size(); i++){
                    if(id == angajati.get(i).getIdAngajat()){
                        found = true;
                        JOptionPane.showMessageDialog(frame,
                                "Exista deja un angajat cu acest id",
                                "Insert error",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                if(found == false){
                    angajat = new Angajat(id, nume, prenume, conceddiu);
                    angajati.add(angajat);
                    rewriteAngajatList(angajati, listaAngajati);
                }
            }
        });
        panel.add(adaugaAngajat);

        JButton stergeAngajat = new JButton("Sterge angajat");
        stergeAngajat.setBounds(260, 350, 200, 30);
        stergeAngajat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listaAngajati.getSelectedIndex();
                if(index != -1){
                    angajati.remove(index);
                    rewriteAngajatList(angajati, listaAngajati);
                } else{
                    String userInput = JOptionPane.showInputDialog(null, "Introduceti id-ul al angajatului pe care doriti sa-l stergeti!");
                    int idToBeDeleted;
                    try {
                        idToBeDeleted = Integer.parseInt(userInput);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Id-ul trebuie sa fie un numar",
                                "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    Angajat angajatToBeDeleted = null;

                    for(int i = 0; i < angajati.size(); i++){
                        if(angajati.get(i).getIdAngajat() == idToBeDeleted){
                            angajatToBeDeleted = angajati.get(i);
                        }
                    }

                    if(angajatToBeDeleted == null){
                        JOptionPane.showMessageDialog(frame,
                                "Angajatul cu id-ul " + userInput + "nu a fost gasit",
                                "Inane error",
                                JOptionPane.ERROR_MESSAGE);
                    }else{
                        angajati.remove(angajatToBeDeleted);
                        rewriteAngajatList(angajati, listaAngajati);
                    }
                }
            }
        });
        panel.add(stergeAngajat);

        JButton angajatiPrezenti = new JButton("Angajati prezenti");
        angajatiPrezenti.setBounds(470, 350, 200, 30);
        angajatiPrezenti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i <angajati.size(); i++){
                    if(angajati.get(i).isConcediu() == false){
                        prezenti.add(angajati.get(i));
                    }
                }
                rewriteAngajatList(prezenti, listaAngajatiPrezenti);
            }
        });
        panel.add(angajatiPrezenti);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public void rewriteAngajatList(ArrayList<Angajat>listOfAngajati, JList listaPanou){
        DefaultListModel listaModel = new DefaultListModel<>();
        for(Angajat a : listOfAngajati){
            listaModel.addElement(a);
        }
        listaPanou.setModel(listaModel);
    }

}
