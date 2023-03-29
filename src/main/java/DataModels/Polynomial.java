package DataModels;
import GUI.View;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polynomial {
    private Map< Integer, Double> polynoms ;


    public Polynomial() {
        this.setPolynoms(new HashMap<>());
    }

    public void formPolynom(Monomial m) {
        this.polynoms.put(m.getPower(), m.getCoefficient());
    }


    public static Polynomial retPolynom (String text)  {
        Polynomial result = new Polynomial();
        Pattern p = Pattern.compile("([+-]?\\d*\\.?\\d*)(x?)(\\^([+-]?\\d*\\.?\\d*))?");
        Matcher m = p.matcher(text);

        try {
            if (text.matches("(.*)[a-z][a-z](.*)") || text.matches("(.*)\\+\\-(.*)") || text.matches("(.*)\\+\\+(.*)") || text.matches("(.*)\\-\\+(.*)") || text.matches("(.*)\\-\\-(.*)")) throw new Exception("Bad input");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
            return null;
        }

        while(m.find()) {
            String coeffAux = m.group(1);
            String powerAux = m.group(4);
           String aux = m.group(2);
            Monomial mon = new Monomial();
            double coeff = 0.0;
            int power = 0;


          if (coeffAux.isEmpty() && powerAux == null && aux.equals("")) {
                continue;
            }
            try {

                if(coeffAux.equals("") || coeffAux.equals("+") || coeffAux.equals("-")){
                    if(coeffAux.equals("+") || coeffAux.equals("")){
                        coeff = 1;
                    }
                    if(coeffAux.equals("-")) coeff = -1;
                }
               else if(!coeffAux.isEmpty()){
                    coeff = Double.parseDouble(coeffAux);
                }
//power = 1
                if ( aux!=null && powerAux==null) {
                    power = 1;
                }
//power = 0
                if (powerAux == null && aux.equals("")) {
                     power = 0;
                }

                if ( aux!=null && powerAux!=null) {
                    power = Integer.parseInt(powerAux);
                }


                mon.setCoefficient(coeff);
                mon.setPower(power);
                result.formPolynom(mon);
            } catch (NumberFormatException ex) {
                System.out.println("Bad input");
                return null;
            }
        }
        return result;
}

    public String toString() {
        String res="";
        TreeMap<Integer, Double> reverseMap = new TreeMap<>(Collections.reverseOrder());
        reverseMap.putAll(this.polynoms);
        for (Map.Entry<Integer, Double> entry : reverseMap.entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();

            if(power == 0) {
                if(coeff < 0)
                    res = res + coeff;
                else
                    res = res + "+"+ coeff;
            } else if(power == 1){
                if(coeff < 0)
                    res = res + coeff + "x";
                else
                    res = res + "+"+ coeff + "x";
            } else if(coeff == 1) {
                res = res + "+"+ "x^" + power;
            } else if(coeff < 0) {
                res = res + coeff+"x^"+power;
            } else if(coeff > 0){
                res=res+ "+"+coeff+"x^"+power;
            }
        }
        return res;
    }

    public Map< Integer, Double> getPolynoms() {
        return polynoms;
    }
    public void setPolynoms(Map< Integer, Double> polynoms) {
        this.polynoms = polynoms;
    }
}
