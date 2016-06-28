public class KNOTEN
{
    private DATENELEMENT daten;

    public KNOTEN(DATENELEMENT daten) {
        this.daten = daten;
    }    

    public String getBezeichnung() {
        return daten.getBezeichnung();
    }

    public String getInfo() {
        return daten.getInfo();
    }
    
    public DATENELEMENT getDatenelement() {
        return daten;
    }
    
}
