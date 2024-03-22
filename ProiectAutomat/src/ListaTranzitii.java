import java.util.ArrayList;


public class ListaTranzitii {
    private ArrayList<Tranzitie>lista;
    
    ListaTranzitii(){
        this.lista=new ArrayList<Tranzitie>();
    }
    
    public void adaugaTranzitie(Tranzitie tr){
        this.lista.add(tr);
    }
    
    Tranzitie gasesteTranzitie(String stare, char simbol){
        for(int i=0; i<this.lista.size(); i++){
            Tranzitie tmp=this.lista.get(i);// 
            if(tmp.spuneStareInceput().equals(stare) && tmp.spuneSimbol()==simbol)
                return tmp;
        }
        return null;
    }  
    

}