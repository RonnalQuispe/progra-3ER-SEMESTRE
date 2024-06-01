package proyecto;

import javax.swing.JOptionPane;

public class procesos {

    double cosTotal;// variable global

    public void iniciar() {// el public hace a la funcion publica 
        
            pedirDatos();//esta llamando a pedir datos 
        
        
    }

    public void pedirDatos() {
        final int valorDia = 100000;
        String restipo = JOptionPane.showInputDialog("ingrese -si- si es subsidiado");
        double costoTrat = validaNeativos("ingrese el costo del tratamiento");
        double costMedic = validaNeativos("ingrese el costo del medicamento");
        int diasHospital = Integer.parseInt(JOptionPane.showInputDialog("ingrese los dias del hospital"));
        calcularValorBase(costMedic, costoTrat, diasHospital, valorDia);//esta mandando las variables a cacularvalor base 
        double resultado = calcularDescuento(restipo);//llama a la funcion/metodo calculardescuento para que haga- imprima lo que esta dentro z
        imprimirResultado(resultado);

    }
    public double validaNeativos(String mnsj){// llama a la funcion con el mensaje que se encuentra en cada variable 
        double num=0;
        do {            
            num=Double.parseDouble(JOptionPane.showInputDialog(mnsj));//num>0 entonces imprime el cuadro de dialogo
            
            if (num<0) {
                System.out.println("el numero debe ser mayor que cero");
                
            }
        } while (num<0);
        return num;//double poner return 
        
    }
     private void imprimirResultado(double resultado) {
         String cad="RESULTADO CALCULO\n";
         cad+="el valor total a pagar es: "+cosTotal+"\n";
         cad+="con el descuento seria "+resultado+"\n";
         System.out.println(cad);
        
    }

    public void calcularValorBase(double costMedic, double costoTrat, int diasHospital, int valorDia) {//esta recibiendo las variables de otro metodo
        int costDias = diasHospital * valorDia;
        cosTotal = costDias + costMedic + costDias;
        System.out.println("el valor base es " + cosTotal);

    }

    public double calcularDescuento(String resp) {//en resultado como es String aqui tmbn se pone, e igual en tipo 
        double valorfinal = 0;
        if (resp.equalsIgnoreCase("si")) {
            valorfinal = (cosTotal - (cosTotal * 0.1));

        } else {
            valorfinal = (cosTotal - (cosTotal * 0.5));
        }
        return valorfinal;

    }

   

}
