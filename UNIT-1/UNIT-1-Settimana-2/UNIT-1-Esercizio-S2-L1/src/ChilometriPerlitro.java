public class ChilometriPerlitro {

    public int calcolo(int km,int litri) throws Exception{
        if (km == 0 || litri == 0){
            throw new Exception ("con i dati 0 non si puo calcolcare");
        }
        return km / litri;
    }
}
