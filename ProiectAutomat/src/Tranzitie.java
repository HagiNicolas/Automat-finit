public class Tranzitie {
    private String stareInceput;
    private char simbol;
    private String stareFinala; 

    public Tranzitie(String stareInceput, char simbol, String stareFinala) {
        this.stareInceput = stareInceput;
        this.simbol = simbol;
        this.stareFinala = stareFinala;
    }

    public String spuneStareInceput() {
        return this.stareInceput;
    }

    public char spuneSimbol() {
        return this.simbol;
    }

    public String spuneStareFinala(){
        return this.stareFinala;
    }
}
