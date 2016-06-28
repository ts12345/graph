public class ORT implements DATENELEMENT
{
    private String ortsname;
    private int einwohneranzahl;

    public ORT(String ortsname, int einwohneranzahl)
    { 
        this.ortsname = ortsname;
        this.einwohneranzahl = einwohneranzahl;
    }

    public String getBezeichnung() {
        return ortsname;
    }

    public String getInfo() {
        return ortsname + " hat " + einwohneranzahl + " Einwohner";
    }

}
