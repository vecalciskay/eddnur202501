package nur.prog3.arboles.aritmeticos;

public class Operador extends SimboloAritmetico {
    private OperacionMatematica op;

    public Operador(String s) {
        switch(s) {
            case "+":
                op = OperacionMatematica.SUMA;
                break;
            case "-":
                op = OperacionMatematica.RESTA;
                break;
            case "*":
                op = OperacionMatematica.MULT;
                break;
            case "/":
                op = OperacionMatematica.DIV;
                break;
            default:
                op = OperacionMatematica.NOOP;
                break;
        }
    }

    public  Operador(OperacionMatematica o) {
        op = o;
    }

    public Numero evaluar(Numero izq, Numero der) {
        if(op == OperacionMatematica.NOOP)
            return new Numero(Double.MIN_VALUE);
        else if(op == OperacionMatematica.SUMA)
            return new Numero(izq.getValor() + der.getValor());
        else if(op == OperacionMatematica.RESTA)
            return new Numero(izq.getValor() - der.getValor());
        else if(op == OperacionMatematica.MULT)
            return new Numero(izq.getValor() * der.getValor());
        else if(op == OperacionMatematica.DIV)
            return new Numero(izq.getValor() / der.getValor());

        return new Numero(Double.MIN_VALUE);
    }

    @Override
    public String toString() {
        if(op == OperacionMatematica.NOOP) return "ERR";
        else if(op == OperacionMatematica.SUMA) return "+";
        else if(op == OperacionMatematica.RESTA) return "-";
        else if(op == OperacionMatematica.MULT) return "*";
        else if(op == OperacionMatematica.DIV) return "/";

        return "ERR";
    }
}
