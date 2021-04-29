//Usar en caso de emergencia { }, [ ], < >
package aversijala;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class funcionaplsRLS extends Agent{

        private double [] x = {651, 762, 856, 1063, 1190, 1298, 1421, 1440, 1518};
        private double [] y = {23, 26, 30, 34, 43, 48, 52, 57, 58};
        private int xalfa;
        private float nxy, xs, ys, nx2, x2, n=x.length;
        public float m, b;

        protected void setup(){
        System.out.println("Agent" + getLocalName() + "started");
        System.out.println("escriba un numero de preferencia del 1 al 9: ");
        Object [] num = getArguments();
        xalfa = (int) num[0];
        addBehaviour(new ejecutar());
    }

    private class ejecutar extends OneShotBehaviour{

        private int xalfa;
        private float resultado;

        public void action(){

            for(int i=0;i<n;i++)
            {
                nxy += x[i] * y[i];
                xs += x[i];
                ys += y[i];
                nx2 += x[i] * x[i];
            }
            //x2 = nx2 * nx2;
            //beta 1
            m = (n * nxy - (xs * ys)) / ((n * nx2) - xs * xs);
            //beta 0
            b = (ys - (m * xs)) / n;
            
            resultado = b + (m * xalfa);
            System.out.println("Y =  b0 + b1xi");
            System.out.println("y = " + b + " + " + m + " " + xalfa + " = " + resultado);
            
        }

        public int onEnd() {
            myAgent.doDelete();   
            return super.onEnd();
          } 
    }
}

