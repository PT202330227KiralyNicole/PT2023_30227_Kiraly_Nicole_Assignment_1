package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import BusinessLogic.Operations;
import DataModels.Polynomial;

public class Controller {
    private View view;

    public Controller(View view) {
        this.view = view;


        this.view.addAddButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                  view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());
                Polynomial polynom2 = Polynomial.retPolynom(view.getSecondInput());

                Operations op = new Operations();
                Polynomial result = op.addPolynoms(polynom1, polynom2);

                view.setResult(result.toString());

            }

        });

        this.view.addSubButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                  view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());
                Polynomial polynom2 = Polynomial.retPolynom(view.getSecondInput());

                Operations op = new Operations();
                Polynomial result = op.subPolynoms(polynom1, polynom2);

                view.setResult(result.toString());

            }


        });

        this.view.addDerivButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                  view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());

                Operations op = new Operations();
                Polynomial result = op.derivPolynom(polynom1);
                view.setResult(result.toString());

            }


        });


        this.view.addIntegrButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                   view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());

                Operations op = new Operations();
                Polynomial result = op.integralPolynom(polynom1);
                view.setResult(result.toString());
            }

        });

        this.view.addMulButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                  view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());
                Polynomial polynom2 = Polynomial.retPolynom(view.getSecondInput());

                Operations op = new Operations();
                Polynomial result = op.mulPolynoms(polynom1, polynom2);

                view.setResult(result.toString());
            }

        });

        this.view.addDivButtonListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                    view.setResult("");
                Polynomial polynom1 = Polynomial.retPolynom(view.getFirstInput());
                Polynomial polynom2 = Polynomial.retPolynom(view.getSecondInput());

                Operations op = new Operations();
                String res = op.divPolynoms(polynom1, polynom2);

                view.setResult(res);
            }

        });
    }
}
