package symbiote.h2020.eu.sampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class About extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        txt = (TextView) findViewById(R.id.txt);
        String nodata = "H εφαρμογή αυτή δημιουργήθηκε από την ερευνητική ομάδα “Νέα Μέσα, Νόηση, και Μάθηση” σε συνεργασία με το εργαστήριο του “Διαδικτύου των Πραγμάτων (IoTLab)” του Τμήματος Επικοινωνίας και Σπουδών Διαδικτύου του Τεχνολογικού Πανεπιστημίου Κύπρου στο πλαίσιο του ευρωπαϊκού ερευνητικού προγράμματος \"IoT for Education: Presenting air quality matters\"." +
                "\n" +
                "Το πρόγραμμα έλαβε χρηματοδότηση από το πρόγραμμα Έρευνας και Καινοτομίας της Ευρωπαϊκής Ένωσης Horizon 2020 βάσει της συμφωνίας επιχορήγησης με αριθμό 688156."+
                "\n" + "Τα δεδομένα ποιότητας αέρα για την πόλη της Λεμεσού παρέχονται από τον Κλάδο Ποιότητας Αέρα, του Τμήματος Επιθεώρησης Εργασίας του Υπουργείου Εργασίας, Πρόνοιας και Κοινωνικών Ασφαλίσεων Κύπρου.";

        txt.setText(Html.fromHtml(nodata));



    }
}
