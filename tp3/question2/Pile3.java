package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Pile3 implements PileI {

    private Vector<Object> v;
    private int capacite;

    public Pile3() {
       // this(0);
       this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        // traiter le cas <=0
        // à compléter
         if (taille <= 0){
            taille = CAPACITE_PAR_DEFAUT;
        }
        this.v = new Vector<Object>();
        this.capacite = taille;
    }

    public void empiler(Object o) throws PilePleineException {
        // à compléter
         if(estPleine()){
            throw new PilePleineException();
        }
        this.v.add(o);
    }

    public Object depiler() throws PileVideException {
        // à compléter
        if (estVide()){
            throw new PileVideException();
        }
        int d = v.lastIndexOf(sommet());    
        return this.v.remove(d);
       // return null;
    }

    public Object sommet() throws PileVideException {
        // à compléter
         if (estVide())
            throw new PileVideException();
        return this.v.lastElement();
       // return null;
    }

    public int taille() {
        // à compléter
        return this.v.size();
        //return -1;
    }

    public int capacite() {
        // à compléter
        return this.capacite;
        //return -1;
    }

    public boolean estVide() {
        // à compléter
        return this.v.isEmpty();
        //return false;
    }

    public boolean estPleine() {
        // à compléter
        return this.v.size() == this.capacite;
        //return false;
    }

    public String toString() {
        // à compléter
         String s = "[";
        for (int i = this.v.size() - 1; i >= 0; i--) {
            s+= this.v.get(i).toString();
            if(i >0){
                s+= ", ";
            }

        }
        return s + "]"; 
       // return "";
    }

    public boolean equals(Object o) {
        // à compléter
        if( this== o ){
            return true;
        }
        if(!(o instanceof Pile3)){
            return false;
        }
        Pile3 p = (Pile3) o;
        if(this.taille() == p.taille()){
            if(this.capacite() == p.capacite()){
               boolean estEgale = false; 
               for (int i = this.v.size() - 1; i >= 0; i--) {
                    Object tmp = this.v.get(i);
                    boolean existe = false;
                    for(int j = this.v.size() - 1; j >= 0; j--){
                        if((tmp == p.v.get(i))){
                               existe = true;
                        }
                    }
                    if(existe){
                        estEgale = true;
                    } else{
                        return false;
                    }
                   
               }
                return true;
            }
                
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
