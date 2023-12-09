package com.example.demo;

import com.example.demo.Base.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.sql.*;
import java.time.LocalDate;

public class HelloController {

    @FXML
    private Button DiagDel;

    @FXML
    private Button DiagDob;

    @FXML
    private Text DiagnosisDateOfApplication;

    @FXML
    private TextField DiagnosisImprovement;

    @FXML
    private ComboBox<String> DiagnosisStatus;

    @FXML
    private TableView<Diagnosis1> Diagnoz;

    @FXML
    private TableColumn<?, ?> DiagnozData;

    @FXML
    private TableColumn<?, ?> DiagnozID;

    @FXML
    private TableColumn<?, ?> DiagnozJaloba;

    @FXML
    private TableColumn<?, ?> DiagnozLechenie;

    @FXML
    private TableColumn<?, ?> DiagnozPatient;

    @FXML
    private TableColumn<?, ?> DiagnozVrach;

    @FXML
    private TableColumn<?, ?> DiagnozYlychenie;

    @FXML
    private TableColumn<?, ?> DiagnozZabolevanie;

    @FXML
    private TextField DiseaseDizgnosis;

    @FXML
    private TextField DizgnosisComplaints;

    @FXML
    private AnchorPane DobavlenieDiagnoz;

    @FXML
    private Button Exit;

    @FXML
    private TextField FIODizgnosis;

    @FXML
    private BorderPane IstoriaBolezni;

    @FXML
    private BorderPane Menu;

    @FXML
    private Button MenuReturn;

    @FXML
    private Button MenuReturn1;

    @FXML
    private Button MenuReturn2;

    @FXML
    private TextField NumFIO;

    @FXML
    private TextField NumID;

    @FXML
    private TextField NumMedBook;

    @FXML
    private TextField NumPol;

    @FXML
    private TextField NumPolOsn;

    @FXML
    private TextField NumStrash;

    @FXML
    private TableColumn<?, ?> PatData;

    @FXML
    private TableColumn<?, ?> PatFIO;

    @FXML
    private TableColumn<?, ?> PatID;

    @FXML
    private TableColumn<?, ?> PatMesto;

    @FXML
    private TableColumn<?, ?> PatNomerKnigi;

    @FXML
    private TableColumn<?, ?> PatNomerPol;

    @FXML
    private Button PatienntDel;

    @FXML
    private Button PatienntDob;

    @FXML
    private TableView<Patient1> Patient;

    @FXML
    private Button Pechat;

    @FXML
    private Button PoiskPatient;

    @FXML
    private Button PoiskVrach;

    @FXML
    private TextField PolFIO;

    @FXML
    private TextField PolsData;

    @FXML
    private TextField PolsMesto;

    @FXML
    private Button SilkaBolezn;

    @FXML
    private Button SilkaPatient;

    @FXML
    private Button SilkaVrachi;

    @FXML
    private Button SohranDiagnosis;

    @FXML
    private TextField SpecDizgnosis;

    @FXML
    private BorderPane SpisokPatientov;

    @FXML
    private TableColumn<?, ?> Status;

    @FXML
    private ComboBox<String> StatusPoisk;

    @FXML
    private TextField TreatmentDiagnosis;

    @FXML
    private TableView<Vrach1> Vrach;

    @FXML
    private Button VrachDob;
    @FXML
    private Text id;

    @FXML
    private Button VrachDobav;
    @FXML
    private Button Obn1;
    @FXML
    private Button Obn2;
    @FXML
    private Button Obn3;
    @FXML
    private Button IzmenPat;
    @FXML
    private Button Menu5;
    @FXML
    private TextField DataDiz;
    @FXML
    private TextField JalobDiz;
    @FXML
    private TextField ULUCDIZ;
    @FXML
    private TextField LechDiz;


    @FXML
    private TableColumn<?, ?> VrachFIO;

    @FXML
    private ComboBox<String> VrachFIOCombox;

    @FXML
    private TableColumn<?, ?> VrachID;

    @FXML
    private TextField VrachIDText;
    @FXML
    private TextField VrachFIOText;
    @FXML
    private TextField VrachSpecText;

    @FXML
    private TextField VrachPoisk;

    @FXML
    private TableColumn<?, ?> VrachSpec;

    @FXML
    private ComboBox<String> VrachSpecCombox;

    @FXML
    private TableColumn<?, ?> VrachStaj;

    @FXML
    private TextField VrachStajText;

    @FXML
    private BorderPane Vrachi;

    @FXML
    private TextField Zabol;

    @FXML
    void DelDiag(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from diagnosis where IdDiagnosis =" + NumID.getText() + ";");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);
        }
    }

    @FXML
    void DelPatient(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from patient where IDPatient =" + Integer.parseInt(NumPolOsn.getText()) + ";");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);
        }
    }

    @FXML
    void DelVrach(ActionEvent event) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("delete from doctor where IDPatient =" + Integer.parseInt(VrachID.getText()) + ";");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);
        }
    }

    @FXML
    void DobDiag(ActionEvent event) {
        IstoriaBolezni.setVisible(false);
        DobavlenieDiagnoz.setVisible(true);
        if (Diagnoz.getSelectionModel().isEmpty()) {
            LocalDate currentDate = LocalDate.now();
            id.setText("");
            SpecDizgnosis.setText("Специалист:");
            FIODizgnosis.setText("");
            DizgnosisComplaints.setText("");
            DiseaseDizgnosis.setText("");
            TreatmentDiagnosis.setText("");
            DiagnosisImprovement.setText("");
            DiagnosisDateOfApplication.setText("Дата приёма: " + currentDate.toString());
            try {
                dataTable6 = ZapStatus();
                StatusPoisk.getItems().clear();
                for (int i = 0; i < dataTable6.size(); i++) {
                    comboBox3.add(dataTable6.get(i).getCol2());
                }
                DiagnosisStatus.setItems(comboBox3);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            id.setText(String.valueOf(dataTable4.get(0).getCol1()));
            SpecDizgnosis.setText("Специалист:" + dataTable4.get(0).getCol6());
            FIODizgnosis.setText(dataTable4.get(0).getCol2());
            DizgnosisComplaints.setText(dataTable4.get(0).getCol7());
            DiseaseDizgnosis.setText(dataTable4.get(0).getCol4());
            TreatmentDiagnosis.setText(dataTable4.get(0).getCol5());
            DiagnosisImprovement.setText(dataTable4.get(0).getCol8());
            DiagnosisDateOfApplication.setText("Дата приёма: " + dataTable4.get(0).getCol3());
            try {
                dataTable6 = ZapStatus();
                StatusPoisk.getItems().clear();
                for (int i = 0; i < dataTable6.size(); i++) {
                    comboBox3.add(dataTable6.get(i).getCol2());
                }
                DiagnosisStatus.setItems(comboBox3);
                DiagnosisStatus.setValue(dataTable4.get(0).getCol9().toString());
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @FXML
    void Perehod(MouseEvent event) {
        dataTable4.clear();
        Diagnosis1 selectedPerson = Diagnoz.getSelectionModel().getSelectedItem();
        dataTable4.add(selectedPerson);
    }


    @FXML
    void Pechat(ActionEvent event) {
       MedSpravka.med(FIODizgnosis.getText(),SpecDizgnosis.getText(),DizgnosisComplaints.getText(),DiseaseDizgnosis.getText(),TreatmentDiagnosis.getText());

    }
    @FXML
    void MouseVrach(MouseEvent event) {
        dataTableIZV.clear();
        Vrach1 selectedPerson = Vrach.getSelectionModel().getSelectedItem();
        dataTableIZV.add(selectedPerson);
        VrachIDText.setText(String.valueOf(dataTableIZV.get(0).getCol1()));
        VrachFIOCombox.setValue(String.valueOf(dataTableIZV.get(0).getCol2()));
        VrachSpecCombox.setValue((dataTableIZV.get(0).getCol3()));
        VrachStajText.setText(String.valueOf(dataTableIZV.get(0).getCol4()));
    }
    @FXML
    void MousePat(MouseEvent event) {
        dataTableIZP.clear();
        Patient1 selectedPerson = Patient.getSelectionModel().getSelectedItem();
        dataTableIZP.add(selectedPerson);
        NumPolOsn.setText(String.valueOf(dataTableIZP.get(0).getCol1()));
        NumStrash.setText(dataTableIZP.get(0).getCol2());
        NumMedBook.setText(dataTableIZP.get(0).getCol3());
        PolFIO.setText(dataTableIZP.get(0).getCol4());
        PolsMesto.setText(dataTableIZP.get(0).getCol5());
        PolsData.setText(dataTableIZP.get(0).getCol6());
    }

    @FXML
    void Save(ActionEvent event) {

        String originalString = SpecDizgnosis.getText();
        String textToRemove = "Специалист: ";
        String originalString1 = DiagnosisDateOfApplication.getText();
        String textToRemove1 = "Дата приёма: ";
        String Vrach = originalString.replace(textToRemove, "");
        String Dat = originalString1.replace(textToRemove1, "");

        if (id.getText().isEmpty()) {
            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/med",
                        "root", "1234");
                Statement statement = connection.createStatement();

                String a=("INSERT INTO Diagnosis (Patient, DateOfApplication, Disease, Treatment, Doctor, Complaints, Improvement, Status) " +
                        "VALUES ((SELECT IdPatient FROM Patient WHERE FIO ='" + FIODizgnosis.getText() + "'),'" + Dat + "','" + DiseaseDizgnosis.getText() + "','" + TreatmentDiagnosis.getText() + "'," +
                        "(SELECT IdDoctor FROM Doctor WHERE FIOVrach ='" + Vrach + "'),'" + DizgnosisComplaints.getText() + "','" + DiagnosisImprovement.getText() + "', " +
                        "(SELECT IDStatus FROM Status WHERE Name ='" + DiagnosisStatus.getValue() + "' ));");

                System.out.println(a);
                statement.executeUpdate(a);
                connection.close();
            } catch (SQLException e) {

                throw new RuntimeException("Error while executing SQL query", e);
            }
        } else {


            try {
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/med",
                        "root", "1234");
                Statement statement = connection.createStatement();

                statement.executeUpdate("UPDATE Diagnosis " +
                        "Set Patient= (SELECT IdPatient FROM Patient WHERE FIO ='" + FIODizgnosis.getText() + "'), DateOfApplication='" + Dat + "', Disease='" + DiseaseDizgnosis.getText() + "',Treatment='" + TreatmentDiagnosis.getText() + "'," +
                        "Doctor=(SELECT IdDoctor FROM Doctor WHERE FIOVrach ='" + Vrach + "'),Complaints='" + DizgnosisComplaints.getText() + "',Improvement='" + DiagnosisImprovement.getText() + "', " +
                        "Status= (SELECT IDStatus FROM Status WHERE Name ='" + DiagnosisStatus.getValue() + "' ) Where IdDiagnosis="+id.getText()+";");
                connection.close();
            } catch (SQLException e) {

                throw new RuntimeException("Error while executing SQL query", e);
            }
        }
    }


    @FXML
    void DobPatient(ActionEvent event) {
        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into patient (InsurancePolicyNumber,MedicalBookNumber,FIO,PlaceOfResidence,DateOfBirth) values ("+NumStrash.getText()+", "+NumMedBook.getText()+", '"+PolFIO.getText()+"', '"+PolsMesto.getText()+"', '"+ PolsData.getText()+"');");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);

        }
    }

    @FXML
    void DobVrach(ActionEvent event) {
        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("insert into doctor (FIOVrach,Specialty,WorkExperience) values ('"+VrachFIOText.getText()+"', (SELECT IdSpecialty FROM Specialty WHERE SpecialtyName='"+VrachSpecCombox.getValue()+"'),"+VrachStajText.getText()+");");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException(e);

        }
    }
    @FXML
    void Obn(ActionEvent event) {
        try {
            StatusPoisk.getItems().clear();
            dataTable3 = ZapDiagnosis();

            DiagnozID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            DiagnozPatient.setCellValueFactory(new PropertyValueFactory<>("col2"));
            DiagnozData.setCellValueFactory(new PropertyValueFactory<>("col3"));
            DiagnozJaloba.setCellValueFactory(new PropertyValueFactory<>("col7"));
            DiagnozZabolevanie.setCellValueFactory(new PropertyValueFactory<>("col4"));
            DiagnozYlychenie.setCellValueFactory(new PropertyValueFactory<>("col8"));
            DiagnozLechenie.setCellValueFactory(new PropertyValueFactory<>("col5"));
            DiagnozVrach.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Status.setCellValueFactory(new PropertyValueFactory<>("col9"));
            dataTable6=ZapStatus();
            for(int i=0;i<dataTable6.size();i++){
                comboBox3.add(dataTable6.get(i).getCol2());
            }
            StatusPoisk.setItems(comboBox3);
            Diagnoz.setItems(dataTable3);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            dataTable = ZapPat();
            PatID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            PatNomerPol.setCellValueFactory(new PropertyValueFactory<>("col2"));
            PatNomerKnigi.setCellValueFactory(new PropertyValueFactory<>("col3"));
            PatFIO.setCellValueFactory(new PropertyValueFactory<>("col4"));
            PatMesto.setCellValueFactory(new PropertyValueFactory<>("col5"));
            PatData.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Patient.setItems(dataTable);
        }catch (Exception e){
            System.out.println(e);
        }
        try {
            VrachFIOCombox.getItems().clear();
            VrachSpecCombox.getItems().clear();

            dataTable2 = ZapVrach();

            VrachID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            VrachFIO.setCellValueFactory(new PropertyValueFactory<>("col2"));
            VrachSpec.setCellValueFactory(new PropertyValueFactory<>("col3"));
            VrachStaj.setCellValueFactory(new PropertyValueFactory<>("col4"));

            Vrach.setItems(dataTable2);
            dataTable5=ZapSpec();
            for(int i=0;i<dataTable2.size();i++){
                comboBox1.add(dataTable2.get(i).getCol2());
                comboBox2.add(dataTable5.get(i).getCol2());
            }
            VrachFIOCombox.setItems(comboBox1);
            VrachSpecCombox.setItems(comboBox2);
            VrachFIOCombox.setValue("");
            VrachSpecCombox.setValue("");
            StatusPoisk.setValue("");

            NumPolOsn.setText("");
            NumStrash.setText("");
            NumMedBook.setText("");
            PolFIO.setText("");
            PolsMesto.setText("");
            PolsData.setText("");

            NumID.setText("");
            NumFIO.setText("");
            DataDiz.setText("");
            JalobDiz.setText("");
            Zabol.setText("");
            ULUCDIZ.setText("");
            LechDiz.setText("");
            VrachPoisk.setText("");

            VrachIDText.setText("");
            VrachStajText.setText("");
            VrachFIOText.setText("");
        }catch (Exception e){
            System.out.println(e);
        }

    }
    @FXML
    void PoisDiagnoza(ActionEvent event) {
        String a=null;
        String b="";
        ObservableList<Diagnosis1> diagnoz = FXCollections.observableArrayList();
        if(!NumID.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" IdDiagnosis="+NumID.getText();

        }
        if(!NumFIO.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" FIO='"+NumFIO.getText()+"'";

        }
        if(!DataDiz.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" DateOfApplication='"+DataDiz.getText()+"'";

        }
        if(!Zabol.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" Disease LIKE '%"+Zabol.getText()+"%'";

        }
        if(!LechDiz.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" Treatment LIKE'%"+LechDiz.getText()+"%'";

        }
        if(!JalobDiz.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" Complaints Like'%"+JalobDiz.getText()+"%'";
        }
        if(!ULUCDIZ.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" Improvement Like'%"+ULUCDIZ.getText()+"%'";
        }
        if(!VrachPoisk.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" FIOVrach='"+VrachPoisk.getText()+"'";
        }
        if(StatusPoisk.getValue()!=null){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" Status.Name ='"+StatusPoisk.getValue()+"'";
        }


        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();
            a="SELECT Diagnosis.IdDiagnosis, Patient.FIO, Diagnosis.DateOfApplication,Diagnosis.Disease,Diagnosis.Treatment, Doctor.FIOVrach,Diagnosis.Complaints,Diagnosis.Improvement,Status.Name FROM Diagnosis INNER JOIN Patient ON Diagnosis.Patient = Patient.IdPatient INNER JOIN Doctor ON Diagnosis.Doctor = Doctor.IdDoctor INNER JOIN Status ON Diagnosis.Status = Status.IDStatus where "+b+" ;";
            System.out.println(a);

            ResultSet results = statement.executeQuery(a);
            while (results.next()) {
                diagnoz.add(new Diagnosis1(results.getInt("IDDiagnosis"), results.getString("FIO"),
                        results.getString("DateOfApplication"), results.getString("Disease"), results.getString("Treatment")
                        , results.getString("FIOVrach"), results.getString("Complaints"), results.getString("Improvement"), results.getString("Name")));
            }
            } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);

        }
        try {
            dataTable3 = diagnoz;

            DiagnozID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            DiagnozPatient.setCellValueFactory(new PropertyValueFactory<>("col2"));
            DiagnozData.setCellValueFactory(new PropertyValueFactory<>("col3"));
            DiagnozJaloba.setCellValueFactory(new PropertyValueFactory<>("col7"));
            DiagnozZabolevanie.setCellValueFactory(new PropertyValueFactory<>("col4"));
            DiagnozYlychenie.setCellValueFactory(new PropertyValueFactory<>("col8"));
            DiagnozLechenie.setCellValueFactory(new PropertyValueFactory<>("col5"));
            DiagnozVrach.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Status.setCellValueFactory(new PropertyValueFactory<>("col9"));
            Diagnoz.setItems(dataTable3);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    void PoiskPatienta(ActionEvent event) {
        String a=null;
        String b="";
        ObservableList<Patient1> patients1 = FXCollections.observableArrayList();
        if(!NumPolOsn.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
        b+=" IdPatient="+NumPolOsn.getText();

        }
        if(!NumStrash.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" InsurancePolicyNumber="+NumStrash.getText();

        }
        if(!NumMedBook.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" MedicalBookNumber="+NumMedBook.getText();

        }
        if(!PolFIO.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" FIO='"+PolFIO.getText()+"'";

        }
        if(!PolsMesto.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" PlaceOfResidence='"+PolsMesto.getText()+"'";

        }
        if(!PolsData.getText().toString().isEmpty()){
            if(!b.isEmpty()){b+=" AND ";}
            b+=" DateOfBirth='"+PolsData.getText()+"'";
        }

        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();
            a="select*from patient where "+b+" ;";

            ResultSet results = statement.executeQuery(a);
            while (results.next()) {
                patients1.add(new Patient1(results.getInt("IdPatient"), results.getString("InsurancePolicyNumber"),
                        results.getString("MedicalBookNumber"), results.getString("FIO"),
                        results.getString("PlaceOfResidence"), results.getString("DateOfBirth")));
            }
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);

        }
        try {
            dataTable = patients1;
            PatID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            PatNomerPol.setCellValueFactory(new PropertyValueFactory<>("col2"));
            PatNomerKnigi.setCellValueFactory(new PropertyValueFactory<>("col3"));
            PatFIO.setCellValueFactory(new PropertyValueFactory<>("col4"));
            PatMesto.setCellValueFactory(new PropertyValueFactory<>("col5"));
            PatData.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Patient.setItems(dataTable);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @FXML
    void SpDiag(ActionEvent event) {
    Menu.setVisible(false);
    IstoriaBolezni.setVisible(true);
        try {
            StatusPoisk.getItems().clear();
            dataTable3 = ZapDiagnosis();

            DiagnozID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            DiagnozPatient.setCellValueFactory(new PropertyValueFactory<>("col2"));
            DiagnozData.setCellValueFactory(new PropertyValueFactory<>("col3"));
            DiagnozJaloba.setCellValueFactory(new PropertyValueFactory<>("col7"));
            DiagnozZabolevanie.setCellValueFactory(new PropertyValueFactory<>("col4"));
            DiagnozYlychenie.setCellValueFactory(new PropertyValueFactory<>("col8"));
            DiagnozLechenie.setCellValueFactory(new PropertyValueFactory<>("col5"));
            DiagnozVrach.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Status.setCellValueFactory(new PropertyValueFactory<>("col9"));
            dataTable6=ZapStatus();
            for(int i=0;i<dataTable6.size();i++){
                comboBox3.add(dataTable6.get(i).getCol2());
            }
            StatusPoisk.setItems(comboBox3);
            Diagnoz.setItems(dataTable3);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    private ObservableList<Patient1> dataTable = FXCollections.observableArrayList();
    private ObservableList<Vrach1> dataTable2 = FXCollections.observableArrayList();

    private ObservableList<Patient1> dataTableIZP = FXCollections.observableArrayList();
    private ObservableList<Vrach1> dataTableIZV = FXCollections.observableArrayList();

    private ObservableList<Diagnosis1> dataTable3 = FXCollections.observableArrayList();
    private ObservableList<Diagnosis1> dataTable4 = FXCollections.observableArrayList();
    private ObservableList<Specialty1> dataTable5 = FXCollections.observableArrayList();
    private ObservableList<Status1> dataTable6 = FXCollections.observableArrayList();
    @FXML
    void SpPatient(ActionEvent event) {
        Menu.setVisible(false);
        SpisokPatientov.setVisible(true);
        try {
            dataTable = ZapPat();
            PatID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            PatNomerPol.setCellValueFactory(new PropertyValueFactory<>("col2"));
            PatNomerKnigi.setCellValueFactory(new PropertyValueFactory<>("col3"));
            PatFIO.setCellValueFactory(new PropertyValueFactory<>("col4"));
            PatMesto.setCellValueFactory(new PropertyValueFactory<>("col5"));
            PatData.setCellValueFactory(new PropertyValueFactory<>("col6"));
            Patient.setItems(dataTable);
        }catch (Exception e){
            System.out.println(e);
        }

    }
    ObservableList<String> comboBox1 = FXCollections.observableArrayList();
    ObservableList<String> comboBox2 = FXCollections.observableArrayList();
    ObservableList<String> comboBox3 = FXCollections.observableArrayList();


    @FXML
    void SpVrach(ActionEvent event) {
    Menu.setVisible(false);
    Vrachi.setVisible(true);
        try {
            dataTable2 = ZapVrach();
            VrachFIOCombox.getItems().clear();
            VrachSpecCombox.getItems().clear();
            VrachID.setCellValueFactory(new PropertyValueFactory<>("col1"));
            VrachFIO.setCellValueFactory(new PropertyValueFactory<>("col2"));
            VrachSpec.setCellValueFactory(new PropertyValueFactory<>("col3"));
            VrachStaj.setCellValueFactory(new PropertyValueFactory<>("col4"));
            dataTable5=ZapSpec();
            Vrach.setItems(dataTable2);
            for(int i=0;i<dataTable2.size();i++){
                comboBox1.add(dataTable2.get(i).getCol2());
            }
            for (int j=0;j<dataTable5.size();j++){
                comboBox2.add(dataTable5.get(j).getCol2());

            }
            VrachFIOCombox.setItems(comboBox1);
            VrachSpecCombox.setItems(comboBox2);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    @FXML
    void Vihod(ActionEvent event) {
        System.exit(0);
    }
    @FXML
    void Izmen(ActionEvent event) {

    if(SpisokPatientov.isVisible() == true){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE patient " +
                    "Set InsurancePolicyNumber= '"+NumStrash.getText()+"',MedicalBookNumber='"+NumMedBook.getText()+"',FIO='"+PolFIO.getText()+"',PlaceOfResidence='"+PolsMesto.getText()+"',DateOfBirth='"+PolsData.getText()+"' Where IdPatient="+NumPolOsn.getText()+";");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);
        }
    }
    if(Vrachi.isVisible() == true){
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            Statement statement = connection.createStatement();

            statement.executeUpdate("UPDATE doctor Set FIOVrach='"+VrachFIOCombox.getValue()+"',Specialty=(SELECT IdSpecialty FROM Specialty WHERE SpecialtyName ='"+VrachSpecCombox.getValue()+"'),WorkExperience="+VrachStajText.getText()+" ;");
            connection.close();
        } catch (SQLException e) {

            throw new RuntimeException("Error while executing SQL query", e);
        }
    }
    }

    @FXML
    void poiskVracha(ActionEvent event) {

    }

    @FXML
    void returnMenu(ActionEvent event) {
    Menu.setVisible(true);
    IstoriaBolezni.setVisible(false);
    Vrachi.setVisible(false);
    SpisokPatientov.setVisible(false);
    DobavlenieDiagnoz.setVisible(false);
    }
    @FXML
    private AnchorPane ALL;
    @FXML
    private void initialize() {
        ObservableList<String> stylesheets = ALL.getStylesheets();
        stylesheets.add(getClass().getResource("styles.css").toExternalForm());

    }
    public ObservableList<Patient1> ZapPat() {
        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            ObservableList<Patient1> patients1 = FXCollections.observableArrayList();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM patient");
            while (results.next()) {
                patients1.add(new Patient1(results.getInt("IdPatient"), results.getString("InsurancePolicyNumber"),
                        results.getString("MedicalBookNumber"), results.getString("FIO"),
                        results.getString("PlaceOfResidence"), results.getString("DateOfBirth")));
            }
            connection.close();
            return patients1;
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing SQL query", e);
        }
    }
    public ObservableList<Specialty1> ZapSpec() {
        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            ObservableList<Specialty1> specialties = FXCollections.observableArrayList();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM Specialty");
            while (results.next()) {
                specialties.add(new Specialty1(results.getInt("IdSpecialty"), results.getString("SpecialtyName")));
            }
            connection.close();
            return specialties;
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing SQL query", e);
        }
    }
    public ObservableList<Status1> ZapStatus() {
        try {
            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");
            ObservableList<Status1> statuses = FXCollections.observableArrayList();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM status");
            while (results.next()) {
                statuses.add(new Status1(results.getInt("IDStatus"), results.getString("Name")));
            }
            connection.close();
            return statuses;
        } catch (SQLException e) {
            throw new RuntimeException("Error while executing SQL query", e);
        }
    }
    public ObservableList<Vrach1> ZapVrach() {
        try {

            Connection connection  = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/med",
                    "root", "1234");

            ObservableList<Vrach1> vraches = FXCollections.observableArrayList();

            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery("SELECT Doctor.IdDoctor, Doctor.FIOVrach, Specialty.SpecialtyName, Doctor.WorkExperience FROM Doctor INNER JOIN Specialty ON Doctor.Specialty = Specialty.IdSpecialty;");

            while (results.next()) {
                vraches.add(new Vrach1(results.getInt("IdDoctor"), results.getString("FIOVrach"),
                        results.getString("SpecialtyName")
                        ,results.getFloat("WorkExperience")));

            }
            connection.close();
            return vraches;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        public ObservableList<Diagnosis1> ZapDiagnosis() {
            try {

                Connection connection  = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/med",
                        "root", "1234");

                ObservableList<Diagnosis1> diagnoses = FXCollections.observableArrayList();

                Statement statement = connection.createStatement();
                ResultSet results = statement.executeQuery("SELECT Diagnosis.IdDiagnosis, Patient.FIO, Diagnosis.DateOfApplication,Diagnosis.Disease,Diagnosis.Treatment, Doctor.FIOVrach,Diagnosis.Complaints,Diagnosis.Improvement,Status.Name FROM Diagnosis INNER JOIN Patient ON Diagnosis.Patient = Patient.IdPatient INNER JOIN Doctor ON Diagnosis.Doctor = Doctor.IdDoctor INNER JOIN Status ON Diagnosis.Status = Status.IDStatus;");
                while (results.next()) {
                    diagnoses.add(new Diagnosis1(results.getInt("IDDiagnosis"), results.getString("FIO"),
                            results.getString("DateOfApplication"),results.getString("Disease"),results.getString("Treatment")
                            ,results.getString("FIOVrach"),results.getString("Complaints"),results.getString("Improvement"),results.getString("Name")));
                }
                connection.close();
                return diagnoses;
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
    }
}
