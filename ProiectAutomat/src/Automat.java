import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


public class Automat {
    private String stareInitiala="q0";
    private String stariFinale[];
    private ListaTranzitii lista=new ListaTranzitii();
    private String sir = "";//da
    private ExceptieValidare exceptie = new ExceptieValidare();
    
    Map<String, String> dictionar = new HashMap<>();
     public Automat(String nume_fisier) {
        try {
            BufferedReader buff = new BufferedReader(new FileReader(nume_fisier));
        
       String t [] = buff.readLine().split(",");
       for(int i = 0; i< t.length;i++){
           String l [] = t[i].split(" ");
           dictionar.put(l[0], l[1]);
           
       }
        String validator = "q0|q[1-9][0-9]*";
       this.stareInitiala=buff.readLine();
       if (!stareInitiala.matches(validator)){
            exceptie.adaugaExceptie("Eroare la starea initiala");
       }
       
       String stareFinala=buff.readLine();
       
       this.stariFinale=stareFinala.split(" ");
      
       if (!stareFinala.matches("(" + validator + ")( ("+ validator +"))*")){
            exceptie.adaugaExceptie("Eroare la starile finale");
       }

       while(true){
           String linie= buff.readLine();
           if(linie!=null){
               String elem[]=linie.split(" ");
               
                if (!linie.matches("(" + validator +") [a-z] ("+ validator+")")){
                      exceptie.adaugaExceptie("Eroare la tranzitie");
                 }
               Tranzitie tr = new Tranzitie(elem[0],elem[1].charAt(0),elem[2]);
               lista.adaugaTranzitie(tr);
           }
           else break;
       }
        if (!exceptie.verificaExceptii().isEmpty()) {
                throw new AutomatException("Au fost găsite erori: " + exceptie.verificaExceptii());
            }
        } catch (AutomatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Eroare în procesarea automatului", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Eroare la citirea fișierului: " + e.getMessage(), "Eroare IO", JOptionPane.ERROR_MESSAGE);
        }
    }
     public boolean analizaCuvant(String cuvant){//ab
     sir = "";
     String stare=stareInitiala;//q3
     char[] litere=cuvant.toCharArray();
     for(int i=0; i<litere.length;i++){
         
         Tranzitie tranzitie = lista.gasesteTranzitie(stare, litere[i]); //q2 b q3
         if(tranzitie==null){
              
             return false;
         }
         sir += dictionar.get(stare);
         stare=tranzitie.spuneStareFinala();//q3
         
     }
     for(int i=0;i<stariFinale.length;i++) //q3
     if (stare.equals(stariFinale[i])){ 
         sir += dictionar.get(stare);
         return true;
     }
    
     return false; 
     }
     public String getSir(){
         return sir;
     }
} 