
package calculadora;


import java.util.ArrayList;

/**
 *Esta clase modela la calculadora basica y contiene los 
 *metodos principales tanto como los auxiliares para su funcionamiento
 * @author Las integrantes del equipo son:<ul> 
     *                                    <li>Arindal Contreras Arellano</li>
     *                                    <li>Lourdes Angélica Gutiérrez Landa</li>
     *                                    <li>Regina Pérez Ibarra</li>
     *                                    <li>Tamara Terroba Schnaas</li>
     *                                    </ul>
 */
public class Calculadora {

    /**
     * Se asegura que los parentesis estén balanceados
     * @param operacion: String
     * @return resp: boolean <ul> 
     *                       <li> Regresa true si los paréntesis están balanceados </li>
     *                       <li> Regresa false si los paréntesis no están balanceados</li>
     *                       </ul>
     */
    public static boolean revisaParentesis(String operacion){
        PilaA pilaux = new PilaA();
        boolean resp;
        char actual;
        
        for(int i = 0; i < operacion.length(); i++){
            actual = operacion.charAt(i);
            if(actual == '('){
                pilaux.push(operacion.charAt(i));
            }else{
                if(operacion.charAt(i)== ')'){
                    if(!pilaux.isEmpty()){
                        pilaux.pop();
                        
                    } else{
                        resp = false;
                    }
                    
                }
            } 
        }
        if(pilaux.isEmpty()){
            resp = true;
        }else{
            resp = false;
        }
       
        
        return resp;
    }
    
     /**
     * Se asegura que no haya parentesis vacíos
     * @param operacion: String
     * @return resp= boolean<ul> 
     *                       <li> Regresa true si no hay parentesis vacios en la expresión </li>
     *                       <li> Regresa false si hay parentesis vacios en la expresión </li>
     *                       </ul> 
     */
    public static boolean noParentesisVacios(String operacion){
        boolean resp;
        int i = 0;
        boolean parVacios = false;
        
        while(i < operacion.length()-1 && !parVacios){
            if(operacion.charAt(i) == '(' && operacion.charAt(i+1) == ')'){
                parVacios = true;
            }
            
            i++;
        }
        
        if(parVacios){
            resp = false;
        } 
        else{
            resp = true;
        }
        
        return resp;
    }
    
     /**
     * Se asegura que la expresión no inicie con operadores
     * @param operacion: String
     * @return resp: boolean , será excluído el '-' 
     *                       <ul> 
     *                       <li> Regresa true si la expresión no inicia con operadores </li>
     *                       <li> Regresa false si la expresión inicia con opeadores</li>
     *                       </ul>
     */
    public static boolean noOperadorInicio(String operacion){ 
        boolean resp;
        
        switch(operacion.charAt(0)){
            case')':
                resp = false;
                break;
            case'*':
                resp = false;
                break;
            case'/':
                resp = false;
                break;
            case'+':
                resp = false;
                break;
            case'^':
                resp = false;
                break;
            default:
                resp = true;
        }
        
        return resp;
    }
    
    /**
     * Se asegura que no termine con operadores
     * @param operacion: String
     * @return resp: boolean <ul> 
     *                       <li> Regresa true si la expresión no termina con operadores </li>
     *                       <li> Regresa false si la expresión termina con operadores</li>
     *                       </ul>
     */ 
    public static boolean noOperadorFinal(String operacion){
        boolean resp;

        switch(operacion.charAt(operacion.length()-1)){
            case'*':
                resp = false;
                break;
            case'/':
                resp = false;
                break;
            case'^':
                resp = false;
                break;
            case'+':
                resp = false;
                break;
            case'-':
                resp = false;
                break;
            default:
                resp = true;
        }
        
        return resp;
    }
    
     /**
     * Se asegura que no haya dos operadores juntos en la expresión, 
     * se excluye el '-' porque puede haber numeros negativos
     * @param operacion: String
     * @return resp : boolean<ul> 
     *                       <li> Regresa true si no hay operadores juntos en la expresión </li>
     *                       <li> Regresa false si hay operadores juntos en la expresión </li>
     *                       </ul>
     */
    public static boolean noOperadoresJuntos(String operacion){
        int i = 0;
        boolean resp = true;
        char actual;
        char unoDesp='0';
        
        operacion = enNegativo(operacion);
        for(i = 0; i < operacion.length(); i++){
            actual = operacion.charAt(i);
              if(i > 0 && esOperador(actual) && esOperador(unoDesp)){
                 resp = false; 
              }
            unoDesp=actual;
         }
       
        return resp;
    
    }
    /**
     * Se encargara de ponerle un espacio cuando sea un  numero negativo
     * @param operacion: String
     * @return nuevaOperacion: String
     */
    public static String enNegativo(String operacion){
        StringBuilder nuevaOperacion = new StringBuilder();
        boolean bandera = true;
        char actual;
        
        for(int i = 0; i < operacion.length(); i++){
            actual = operacion.charAt(i);
            if(actual == '-' && bandera){
                nuevaOperacion.append( "0");
            }
            nuevaOperacion.append(actual);
            bandera = (esOperador(actual) || actual == '(');
        }
        return nuevaOperacion.toString();
    }
    /**
     * Se asegura de que en la expresión no estén mal colocados los puntos decimales
     * @param operacion: String
     * @return resp: boolean<ul> 
     *                       <li> Regresa true si no hay error con los puntos decimales en la expresión </li>
     *                       <li> Regresa false si hay error con los puntos decimales en la expresión </li>
     *                       </ul>
     */
    public static boolean revisaPuntosDecimales(String operacion){
        boolean resp = true;
        int i = 0;
        int contD = 0;
        
        while(i < operacion.length() && contD < 2){
            if(Character.isDigit(operacion.charAt(i))){
                i++;
            } else if(operacion.charAt(i) == '.'){
                contD++;
                i++;
            } else if(esOperador(operacion.charAt(i))|| operacion.charAt(i) == '(' || operacion.charAt(i) == ')'){
                contD = 0;
                i++;
            }
        }
        if(contD >= 2){
            resp = false;
        }
        return resp;
    }
    
    /**
     * Se encarga de revisar la sintaxis de toda la expresión
     * @param operacion: String
     * @return boolean: resp <ul> 
     *                       <li> Regresa true si no hay error de sintaxis en la expresión </li>
     *                       <li> Regresa false si hay error de sintaxis en la expresión </li>
     *                       </ul>
     */
    public static boolean revisaSintaxis(String operacion){
        boolean resp = false;
        operacion = enNegativo(operacion);
        if(Calculadora.noOperadorFinal(operacion))
            if(Calculadora.noOperadorInicio(operacion))
                if(Calculadora.noOperadoresJuntos(operacion))
                    if(Calculadora.noParentesisVacios(operacion))
                        if(Calculadora.revisaParentesis(operacion))
                            if(Calculadora.revisaPuntosDecimales(operacion))
                                resp = true;
                                
        return resp;
            
    }
    /**
     * Pasa la expresion de infija a postija
     * @param operacionInfija: String
     * @return ArrayList: infijaPosfija
     */
    public static ArrayList<String> infijaPostfija(String operacionInfija){
        ArrayList<String> operacionPost= new ArrayList();
        PilaA <Character> pila= new PilaA();
        int i=0;
        StringBuilder numeros = new StringBuilder();
        operacionInfija = enNegativo(operacionInfija);
        
        if(Calculadora.revisaSintaxis(operacionInfija)){
            while(i<operacionInfija.length()){
            char car=operacionInfija.charAt(i); 
            
            if(car=='('){
                pila.push(car); 
                i++;
            }
            
            else if(Character.isDigit(car) || car== '.'){
                numeros.append(car);
                
                if(i==operacionInfija.length()-1 && !numeros.toString().isEmpty()){
                    operacionPost.add(numeros.toString());
                    numeros.setLength(0);
                }
                i++; 
                
            }
            
            else if(esOperador(car)){
                if(!numeros.toString().isEmpty()){
                    operacionPost.add(numeros.toString());
                    numeros.setLength(0);
                }
                while (!pila.isEmpty() && jerarquia(car) <= jerarquia(pila.peek())) {
                    operacionPost.add(String.valueOf(pila.pop()));
                }
                pila.push(car);
                i++;             
            }
            
            else if( car==')'){
                if(!numeros.toString().isEmpty()){
                    operacionPost.add(numeros.toString());
                    numeros.setLength(0);
                }
                while(!pila.isEmpty() && pila.peek() != '('){
                    operacionPost.add(String.valueOf(pila.pop()));
                }
                if(!pila.isEmpty()){
                    pila.pop();
                }
                i++;
            }    
            
        } 
        
        while (!pila.isEmpty()) {
            operacionPost.add(String.valueOf(pila.pop()));
        }
        } else{ throw new RuntimeException("ERROR SINTAXIS");
        }
        return operacionPost;
    }
    /**
     * Metodo que da jerarquia a los operadores
     * @param operador: char
     * @return resp: int
     */
    public static int jerarquia(char operador){
        int resp = 0;
        
        switch(operador){
            case'*':
                resp = 2;
                break;
            case'/':
                resp = 2;
                break;
            case'^':
                resp = 3;
                break;
            case'+':
                resp = 1;
                break;
            case'-':
                resp = 1;
                break;
        }
        
        return resp;
        
    }
    /**
     * Metodo que pone la funionalidad de los operadores
     * @param num1: double
     * @param num2: double
     * @param operador: String
     * @return operacion: double
     */
    public static double funcionDelOperador(double num1,double num2, String operador){  
        double operacion =0;
        
        switch (operador) {
            case "+":
                operacion= num1+num2;
                break;
            case "-":
                operacion=num1-num2;
                break;
            case "*":
                operacion= num1*num2;
                break;
            case "/":
                if (num2!= 0) {
                    operacion= num1/num2;
                }else{
                     throw new RuntimeException("Se intento una division entre 0");
                }
                break;
            case "^":
                operacion=Math.pow(num1,num2);
                break;
            default:throw new RuntimeException("No es valido el operador");
        }
        
        return operacion;    
    }
    
 
    /**
     * Metodo auxiliar que verifica si es un operador
     * @param car: char
     * @return  resp: boolean<ul> 
     *                       <li> Regresa true si es un operador </li>
     *                       <li> Regresa false si no es un operador </li>
     *                       </ul> 
     */
    public static boolean esOperador(char car){
        boolean resp = false;
        
        
        if(car == '+' || car == '-' || car == '*' ||
           car == '^' || car == '/'){
            resp = true;   
        }
        
        return resp;
    }
    /**
     * Metodo auxiliar que vefirica si es un operador pero para strings
     * @param car: String
     * @return resp: boolean<ul> 
     *                       <li> Regresa true si es un operador </li>
     *                       <li> Regresa false si no es un operador </li>
     *                       </ul>
     */
    public static boolean esOperador2(String car){
        boolean resp = false;
        
        if(car.equals("+") || car.equals("-") || car.equals("*")|| car.equals("/") || car.equals("^") ) {
            resp = true;   
        }
        
        return resp;
    }
    /**
     * Metodo que evalua la expresión una vez ya convertida en postfija
     * @param operacionPostfija: ArrayList
     * @return resp: double
     */ 
    public static double resultadoOperacion( ArrayList<String> operacionPostfija){
        PilaA<Double> pila = new PilaA();
        String operacion;
        double resp=0;
        double numero2, numero1;
               
        //ESTO ESTA MAL 
        for (int i=0; i < operacionPostfija.size(); i++) {
              String caracterActual = operacionPostfija.get(i);
             
            if(!pila.isEmpty()){
                  double ojo= pila.peek();
            }
            
            if (Character.isDigit(caracterActual.charAt(0))) {
                pila.push(Double.parseDouble(caracterActual));
            }
            
            else{
                if(esOperador2(caracterActual) == true){
                    numero2 = pila.pop();
                    numero1 = pila.pop();
                    operacion = caracterActual;
                    resp= funcionDelOperador(numero1,numero2,operacion);
                    pila.push(resp);  
                }

            }   
             
        }
        return pila.pop();
    }
    
 
    
    
    
    
    
    
    public static void main(String[] args) {
        
        String operacion= "(-5-5)*4-(-89-1)";
        System.out.println("Resultado " + resultadoOperacion(infijaPostfija(operacion))); 
        
        
        String operacion2= "-6-(-6)-6";
        System.out.println("Resultado " + resultadoOperacion(infijaPostfija(operacion2))); 
   
        
        String operacion3= "6^2"; 
        System.out.println("Resultado " + resultadoOperacion(infijaPostfija(operacion3))); 
   
      
        
    }
    
}  
     
     
     
     
    
    
    

 
    




