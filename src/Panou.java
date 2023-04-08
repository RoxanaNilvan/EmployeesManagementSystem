import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
public class Panou extends JFrame{

    private JTextField textFieldNume;
    private JTextField textFieldPrenume;
    private JTextField textFieldId;

    private JCheckBox jCheckBoxConcediu;


    ArrayList<Angajat> listOfAngajati = new ArrayList<Angajat>();
    ArrayList<Angajat> listOfAngajatiTeamBuilding = new ArrayList<>();

    ArrayList<Angajat> listOfAngajatiPrezenti = new ArrayList<>();
    public Panou(){
        JFrame frame = new JFrame ("Simple Frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1200, 800);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel labelNume = new JLabel ("Numele ");
        labelNume.setBounds(50, 50, 100, 30);
        panel.add(labelNume);

        textFieldNume = new JTextField("Introduceti numele");
        textFieldNume.setBounds(120, 50, 120, 30);
        panel.add(textFieldNume);

        JLabel labelPrenume = new JLabel ("Prenumele ");
        labelPrenume.setBounds(50, 100, 120, 30);
        panel.add(labelPrenume);

        textFieldPrenume = new JTextField("Introduceti prenumele");
        textFieldPrenume.setBounds(120, 100, 120, 30);
        panel.add(textFieldPrenume);

        JLabel labelId = new JLabel ("Id-ul ");
        labelId.setBounds(50, 150, 1020, 30);
        panel.add(labelId);

        textFieldId = new JTextField("Introduceti id-ul");
        textFieldId.setBounds(120, 150, 120, 30);
        panel.add(textFieldId);

        jCheckBoxConcediu = new JCheckBox("Concediu ?");
        jCheckBoxConcediu.setBounds(50, 200, 120, 30);
        Color color2 = new Color(0x57DBC0F1, true);
        panel.add(jCheckBoxConcediu);

        JLabel labelAngajati = new JLabel ("Lista cu toti angajatii :");
        labelAngajati .setBounds(50, 300, 220, 30);
        panel.add(labelAngajati);

        Font  f3  = new Font(Font.MONOSPACED,  Font.ROMAN_BASELINE, 15);
        labelAngajati.setFont(f3);

        JList listAngajati = new JList<>();
        listAngajati.setBounds(20, 350, 300, 400);
        panel.add(listAngajati);

        JLabel labelAngajatiTeamBuildind = new JLabel ("Angajatii in team building :");
        labelAngajatiTeamBuildind .setBounds(450, 300, 220, 30);
        panel.add(labelAngajatiTeamBuildind);

        Font teamBuilding = new Font(Font.SERIF, Font.ROMAN_BASELINE, 15);
        labelAngajatiTeamBuildind.setFont(teamBuilding);

        JList listAngajatiTeamBuilding = new JList<>();
        listAngajatiTeamBuilding.setBounds(420, 350, 300, 400);
        panel.add(listAngajatiTeamBuilding);

        JLabel labelAngajatiPrezentiLaBirou = new JLabel ("Angajatii prezenti la birou:");
        labelAngajatiPrezentiLaBirou .setBounds(850, 300, 220, 30);
        panel.add(labelAngajatiPrezentiLaBirou);

        Font angajatiPrezenti = new Font(Font.SERIF, Font.ROMAN_BASELINE, 15);
        labelAngajatiPrezentiLaBirou.setFont(angajatiPrezenti);

        JList listAngajatiPrezentiLaBirou = new JList<>();
        listAngajatiPrezentiLaBirou.setBounds(820, 350, 300, 400);
        panel.add(listAngajatiPrezentiLaBirou);

        JButton adaugaAngajat = new JButton("Adauga angajat");
        adaugaAngajat.setBounds(120, 250, 120, 30);
        adaugaAngajat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = textFieldNume.getText();
                String prenume = textFieldPrenume.getText();
                int idAngajat;
                try {
                    idAngajat = Integer.parseInt(textFieldId.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Id-ul trebuie sa fie un numar", "Inset Error", JOptionPane.ERROR_MESSAGE);
                    throw new IllegalArgumentException("idAngajat must be a number");
                }
                boolean concediu = jCheckBoxConcediu.isSelected();

                Angajat angajat = new Angajat(idAngajat, nume, prenume, concediu);
                listOfAngajati.add(angajat);
                JOptionPane.showMessageDialog(frame,"Successfully Updated.","Info",JOptionPane.INFORMATION_MESSAGE);
                rewriteAngajatList(listOfAngajati,listAngajati);

            }
        });



        panel.add(adaugaAngajat);

        JButton stergeAngajat = new JButton("Sterge angajat");
        stergeAngajat.setBounds(250, 250, 120, 30);
        stergeAngajat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

                for(int i = 0; i < listOfAngajati.size(); i++){
                    if(listOfAngajati.get(i).getIdAngajat() == idToBeDeleted){
                        angajatToBeDeleted = listOfAngajati.get(i);
                    }
                }

                if(angajatToBeDeleted == null){
                    JOptionPane.showMessageDialog(frame,
                            "Angajatul cu id-ul " + userInput + "nu a fost gasit",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                }else{
                    listOfAngajati.remove(angajatToBeDeleted);
                    rewriteAngajatList(listOfAngajati, listAngajati);
                }

            }
        });
        panel.add(stergeAngajat);

        JButton mutaAngajat = new JButton("Muta angajat");
        mutaAngajat.setBounds(380, 250, 120, 30);
        mutaAngajat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = JOptionPane.showInputDialog(null, "Introduceti id-ul al angajatului pe care doriti sa-l timiteti in team building!");
                int idToBeMoved;
                try {
                    idToBeMoved = Integer.parseInt(userInput);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Id-ul trebuie sa fie un numar",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Angajat angajatToBeMoved = null;

                for(int i = 0; i < listOfAngajati.size(); i++){
                    if(listOfAngajati.get(i).getIdAngajat() == idToBeMoved){
                        angajatToBeMoved = listOfAngajati.get(i);
                    }
                }

                if(angajatToBeMoved == null){
                    JOptionPane.showMessageDialog(null, "Angajatul cu id-ul " + userInput + " nu a fost gasit!");
                }else{
                    listOfAngajatiTeamBuilding.add(angajatToBeMoved);
                    rewriteAngajatList(listOfAngajatiTeamBuilding, listAngajatiTeamBuilding);
                }
            }
        });
        panel.add(mutaAngajat);

        JButton afiseazaAngajatii = new JButton("Afiseaza Angajatii prezenti");
        afiseazaAngajatii.setBounds(510, 250, 220, 30);
        afiseazaAngajatii.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(int i = 0; i <listOfAngajati.size(); i++){
                    if(listOfAngajati.get(i).isConcediu() == false){
                        listOfAngajatiPrezenti.add(listOfAngajati.get(i));
                    }
                }

                rewriteAngajatList(listOfAngajatiPrezenti, listAngajatiPrezentiLaBirou);
            }
        });
        panel.add(afiseazaAngajatii);


        Color color = new Color(0x64B993E0, true);
        panel.setBackground(color);
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
