package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile implements PileI {

    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        // traiter le cas <=0
        // a completer
        if(taille <= 0 ){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(Pile.CAPACITE_PAR_DEFAUT);;
    }

    public void empiler(Object o) throws PilePleineException {
        // a completer
        if (estPleine())
             throw new PilePleineException();
        this.zone[this.ptr] =o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        // a completer
        if(estVide())
           throw new PileVideException();
        this.ptr--;
        return this.zone[ptr];
       // return null;
    }

    public Object sommet() throws PileVideException {
        // a completer
        if (estVide())
            throw new PileVideException();
        return this.zone[ptr-1];    
       // return null;
    }

    public int capacite() {
        // a completer
        return this.zone.length;
       // return -1;
    }

    public int taille() {
        // a completer
        if (estVide()){
            ptr=0;
        }
        return this.ptr;
        //return -1;
    }

    public boolean estVide() {
        // a completer
        return this.ptr == 0;
       // return false;
    }

    public boolean estPleine() {
        // a completer
        return this.ptr == this.zone.length;
       // return false;
    }

    public boolean equals(Object o) {
        // a completer
         if( this== o ){
            return true;
        }      
        if(!(o instanceof Pile)){
            return false;
        }
        Pile p1 = (Pile)o;

        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean estEgale = false;
            for(int i=zone.length - 1; i >=0; i--){
                Object tmp = zone[i];
                boolean egal = false;
                for(int j = zone.length-1; j>=0; j--){
                    if(tmp == p1.zone[i]){
                        egal = true;
                    }       
                }
                if(egal){
                    estEgale = true;
                }else{
                    return false;
                }
            }
            return true;
        }                
        return false;
    }
       // return false;
    

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        // a completer
         StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i].toString());
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
       // return null;
    
}