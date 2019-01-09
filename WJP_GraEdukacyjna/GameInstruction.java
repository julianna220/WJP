package WJP_GraEdukacyjna;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Panel graficzny instrukcji
 * @author Julianna Wichowska
 */
public class GameInstruction extends JPanel {
    
    /**
     * Okno instrukcji
     * @param width szerokość okna
     * @param height wysokość okna
     */
    public GameInstruction(int width, int height){

    Runnable r;
        r = () -> {
            String html = "<html><body width='%9s'><h1>INSTRUKCJA</h1>"
                    + "<p>Witaj w grze MOZAIKA EUROPY! <br><br>"
                    + "Mozaika Europy to edukcyjna gra komputerowa o krajach Europy. "
                    + "Twoim zadaniem jest poprawna odpowiedź na pytania dotyczące danego kraju, za każdą poprawną odpowiedź otrzymasz 300 punktów!"
                    + "Odpowiedzi na pytania znajdują się przy wyjściach z labiryntu."
                    + "Spróbuj jak najszybciej wyjść z labiryntu poprawnym wyjściem i pamiętaj, że wybór niepoprawnej odpowiedzi wiąże się z utratą 150 punktów!"
                    + "<br><br>"
                    + "<p>Powodzenia :)";
            
            int w = 375;

            JOptionPane.showMessageDialog(null, String.format(html, w, w));
    };
        SwingUtilities.invokeLater(r);
        
    }}