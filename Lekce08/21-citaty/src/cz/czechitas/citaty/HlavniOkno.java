package cz.czechitas.citaty;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import cz.czechitas.citaty.zdroje.*;
import net.miginfocom.swing.*;

public class HlavniOkno extends JFrame {

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner non-commercial license
    JMenuBar menuHlavni;
    JMenu menuSoubor;
    JMenuItem menuOtevritSoubor;
    JMenuItem menuUlozitSoubor;
    JMenu menuZobrazit;
    JCheckBoxMenuItem menuPouzeOblibene;
    JButton btnNahodnyCitat;
    JButton btnAutoruvCitat;
    JCheckBox chckOblibeny;
    JLabel labAutorTitle;
    JLabel labAutor;
    JLabel labCitatTitle;
    JScrollPane scrollPane1;
    JTextArea txtCitat;
    JLabel labPocetCitatuCelkemTitle;
    JLabel labPocetCitatuCelkem;
    JLabel labPocetAutoruTitle;
    JLabel labPocetAutoru;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    JPanel contentPane;
    MigLayout migLayoutManager;

    ZdrojCitatu zdrojCitatu;
    CitacniSluzba citacniSluzba;
    Citat aktualniCitat;


    public HlavniOkno() {
        initComponents();
        vytvorCitacniSluzbu(new StatickyZdrojCitatu());
    }

    private void vytvorCitacniSluzbu(ZdrojCitatu zdroj) {
        citacniSluzba = new CitacniSluzba(zdroj);
        nastavPocetCitatu(zdrojCitatu);
        nastavPocetAutoru(zdrojCitatu);
    }

    private void nastavPocetCitatu(ZdrojCitatu zdroj) {
        int pocet = citacniSluzba.getPocetCitatu();
        labPocetCitatuCelkem.setText(String.valueOf(pocet));
    }

    private void nastavPocetAutoru(ZdrojCitatu zdroj) {
        int pocet = citacniSluzba.getPocetAutoru();
        labPocetAutoru.setText(String.valueOf(pocet));
    }

    private void zobrazCitat(Citat citat) {
        aktualniCitat = citat;
        labAutor.setText(citat.getAuthor());
        txtCitat.setText(citat.getText());
    }

    private void menuNacistSoubor(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            vytvorCitacniSluzbu(new SouborovyZdrojCitatu(file.getPath()));
        }
    }

    private void stisknutoNahodnyCitat(ActionEvent e) {
        Citat citat = citacniSluzba.getNahodnyCitat();
        zobrazCitat(citat);
        btnAutoruvCitat.setEnabled(true);
    }

    private void stisknutoNahodnyiAutoruvCitat(ActionEvent e) {
        Citat citat = citacniSluzba.getAutoruvCitat(aktualniCitat.getAuthor());
        zobrazCitat(citat);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner non-commercial license
        menuHlavni = new JMenuBar();
        menuSoubor = new JMenu();
        menuOtevritSoubor = new JMenuItem();
        menuUlozitSoubor = new JMenuItem();
        menuZobrazit = new JMenu();
        menuPouzeOblibene = new JCheckBoxMenuItem();
        btnNahodnyCitat = new JButton();
        btnAutoruvCitat = new JButton();
        chckOblibeny = new JCheckBox();
        labAutorTitle = new JLabel();
        labAutor = new JLabel();
        labCitatTitle = new JLabel();
        scrollPane1 = new JScrollPane();
        txtCitat = new JTextArea();
        labPocetCitatuCelkemTitle = new JLabel();
        labPocetCitatuCelkem = new JLabel();
        labPocetAutoruTitle = new JLabel();
        labPocetAutoru = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Prohl\u00ed\u017ee\u010d cit\u00e1t\u016f");
        Container contentPane = getContentPane();
        contentPane.setLayout(new MigLayout(
            "insets rel,hidemode 3",
            // columns
            "[fill]" +
            "[left]" +
            "[fill]" +
            "[fill]" +
            "[grow,fill]",
            // rows
            "[fill]" +
            "[]" +
            "[]" +
            "[grow]" +
            "[]" +
            "[]"));
        this.contentPane = (JPanel) this.getContentPane();
        this.contentPane.setBackground(this.getBackground());
        LayoutManager layout = this.contentPane.getLayout();
        if (layout instanceof MigLayout) {
            this.migLayoutManager = (MigLayout) layout;
        }

        //======== menuHlavni ========
        {

            //======== menuSoubor ========
            {
                menuSoubor.setText("Soubor");

                //---- menuOtevritSoubor ----
                menuOtevritSoubor.setText("Otev\u0159\u00edt");
                menuOtevritSoubor.addActionListener(e -> menuNacistSoubor(e));
                menuSoubor.add(menuOtevritSoubor);

                //---- menuUlozitSoubor ----
                menuUlozitSoubor.setText("Ulo\u017eit");
                menuSoubor.add(menuUlozitSoubor);
            }
            menuHlavni.add(menuSoubor);

            //======== menuZobrazit ========
            {
                menuZobrazit.setText("Zobrazit");

                //---- menuPouzeOblibene ----
                menuPouzeOblibene.setText("Pouze Obl\u00edben\u00e9");
                menuZobrazit.add(menuPouzeOblibene);
            }
            menuHlavni.add(menuZobrazit);
        }
        setJMenuBar(menuHlavni);

        //---- btnNahodnyCitat ----
        btnNahodnyCitat.setText("N\u00e1hodn\u00fd cit\u00e1t");
        btnNahodnyCitat.addActionListener(e -> stisknutoNahodnyCitat(e));
        contentPane.add(btnNahodnyCitat, "cell 0 0 2 1");

        //---- btnAutoruvCitat ----
        btnAutoruvCitat.setText("N\u00e1hodn\u00fd od autora");
        btnAutoruvCitat.addActionListener(e -> stisknutoNahodnyiAutoruvCitat(e));
        contentPane.add(btnAutoruvCitat, "cell 2 0 2 1");

        //---- chckOblibeny ----
        chckOblibeny.setText("Obl\u00edben\u00fd");
        contentPane.add(chckOblibeny, "cell 4 0");

        //---- labAutorTitle ----
        labAutorTitle.setText("Autor");
        contentPane.add(labAutorTitle, "cell 0 1,alignx center,growx 0");
        contentPane.add(labAutor, "cell 2 1 3 1,alignx left,growx 0");

        //---- labCitatTitle ----
        labCitatTitle.setText("Citat");
        contentPane.add(labCitatTitle, "cell 0 2,alignx center,growx 0");

        //======== scrollPane1 ========
        {

            //---- txtCitat ----
            txtCitat.setLineWrap(true);
            txtCitat.setColumns(60);
            txtCitat.setRows(20);
            txtCitat.setEditable(false);
            scrollPane1.setViewportView(txtCitat);
        }
        contentPane.add(scrollPane1, "cell 1 2 4 2,grow");

        //---- labPocetCitatuCelkemTitle ----
        labPocetCitatuCelkemTitle.setText("Cit\u00e1t\u016f celkem:");
        contentPane.add(labPocetCitatuCelkemTitle, "cell 0 5");

        //---- labPocetCitatuCelkem ----
        labPocetCitatuCelkem.setText("0");
        contentPane.add(labPocetCitatuCelkem, "cell 1 5,alignx left,growx 0");

        //---- labPocetAutoruTitle ----
        labPocetAutoruTitle.setText("| Celkem Autor\u016f:");
        contentPane.add(labPocetAutoruTitle, "cell 2 5");

        //---- labPocetAutoru ----
        labPocetAutoru.setText("0");
        contentPane.add(labPocetAutoru, "cell 3 5");
        pack();
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
}
