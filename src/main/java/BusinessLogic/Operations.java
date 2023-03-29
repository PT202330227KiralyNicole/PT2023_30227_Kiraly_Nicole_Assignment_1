package BusinessLogic;
import DataModels.Monomial;
import DataModels.Polynomial;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Operations {

    private Polynomial polynom1;
    private Polynomial polynom2;

    public Operations(Polynomial polynom1, Polynomial polynom2) {
        this.polynom1 = polynom1;
        this.polynom2 = polynom2;
    }
    public Operations() {
        super();
    }

    public Polynomial addPolynoms(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result = new Polynomial();
        result = polynom1;
        boolean f;
        for (Map.Entry<Integer, Double> entry : polynom2.getPolynoms().entrySet()) {
            f = false;
            int power = entry.getKey();
            double coeff = entry.getValue();
            for (Map.Entry<Integer, Double> entry1 : polynom1.getPolynoms().entrySet()) {
                int powerOther = entry1.getKey();
                double coeffOther = entry1.getValue();

                if(power == powerOther) {
                    f = true;
                    Monomial m = new Monomial(coeff+coeffOther, power);
                    result.formPolynom(m);
                    break;
                }
            }
            if(f == false) {
                Monomial m = new Monomial(coeff, power);
                result.formPolynom(m);
            }
        }
        return result;
    }
    public Polynomial subPolynoms(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result = new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynom1.getPolynoms().entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();
            if (polynom2.getPolynoms().containsKey(power)) {
                double coeffOther = polynom2.getPolynoms().get(power);
                double newCoeff = coeff - coeffOther;
                if (newCoeff != 0) {
                    Monomial m = new Monomial(newCoeff, power);
                    result.formPolynom(m);
                }

            } else {
                Monomial m = new Monomial(coeff, power);
                result.formPolynom(m);
            }
        }
        for (Map.Entry<Integer, Double> entry : polynom2.getPolynoms().entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();
            if (!polynom1.getPolynoms().containsKey(power)) {
                Monomial m = new Monomial(-coeff, power);
                result.formPolynom(m);
            }
        }
        return result;
    }

    public Polynomial mulPolynoms(Polynomial polynom1, Polynomial polynom2) {
        Polynomial result= new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynom1.getPolynoms().entrySet()) {
            Polynomial resultAux= new Polynomial();
            int power = entry.getKey();
            double coeff = entry.getValue();
            for (Map.Entry<Integer, Double> entry1 : polynom2.getPolynoms().entrySet()) {
                int powerOther = entry1.getKey();
                double coeffOther = entry1.getValue();

                Monomial m = new Monomial(coeff * coeffOther, power + powerOther);
                resultAux.formPolynom(m);
            }
            result=addPolynoms(resultAux, result);
        }
        return result;
    }

    public String divPolynoms(Polynomial polynom1, Polynomial polynom2) {
        String res = "";
        Polynomial quotient = new Polynomial();
        Polynomial remainder = new Polynomial();

        TreeMap<Integer, Double> reverseMap1 = new TreeMap<>(Collections.reverseOrder());
        reverseMap1.putAll(polynom1.getPolynoms());
        TreeMap<Integer, Double> reverseMap2 = new TreeMap<>(Collections.reverseOrder());
        reverseMap2.putAll(polynom2.getPolynoms());

        remainder.setPolynoms(reverseMap1);
        polynom2.setPolynoms(reverseMap2);

        while( Collections.max(remainder.getPolynoms().keySet()) >= Collections.max(polynom2.getPolynoms().keySet() )) {
            int powerP = Collections.max(remainder.getPolynoms().keySet());
            int powerQ = Collections.max(polynom2.getPolynoms().keySet());

            Polynomial aux = new Polynomial();
            double coeffP =  reverseMap1.get(powerP);
            double coeffQ = reverseMap2.get(powerQ);

            if(coeffQ == 0 && powerQ ==0) {
                res = res + "You can t divide by 0!!!";
                return res;
            }

            Monomial m = new Monomial(coeffP/coeffQ, powerP-powerQ);
            aux.formPolynom(m);

            quotient.formPolynom(m);
            remainder = subPolynoms(remainder, mulPolynoms(aux, polynom2));
            if(remainder.toString() == ""){
                break;
            }

        }

        res = res + "Quotient: " + quotient.toString() + "     Remainder: " + remainder.toString();
        return res;
    }

    public Polynomial derivPolynom(Polynomial polynom1) {
        Polynomial result= new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynom1.getPolynoms().entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();
            if(power != 0) {
                Monomial m = new Monomial(coeff * (double) power, power-1);
                result.formPolynom(m);
            }
        }
        return result;
    }

    public Polynomial integralPolynom(Polynomial polynom1) {
        Polynomial result= new Polynomial();

        for (Map.Entry<Integer, Double> entry : polynom1.getPolynoms().entrySet()) {
            int power = entry.getKey();
            double coeff = entry.getValue();

            Monomial m = new Monomial(coeff / (double) (power+1),  power+1);
            result.formPolynom(m);
        }
        return result;
    }

    public Polynomial getPolynom1() {
        return polynom1;
    }

    public void setPolynom1(Polynomial polynom1) {
        this.polynom1 = polynom1;
    }

    public Polynomial getPolynom2() {
        return polynom2;
    }

    public void setPolynom2(Polynomial polynom2) {
        this.polynom2 = polynom2;
    }
}