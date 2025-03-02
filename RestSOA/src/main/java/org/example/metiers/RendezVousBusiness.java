package org.example.metiers;

import org.example.entitites.Logement;
import org.example.entitites.RendezVous;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RendezVousBusiness {
    public static List<RendezVous> listeRendezVous;
    LogementBusiness logementMetier=new LogementBusiness();
    public RendezVousBusiness() {
        listeRendezVous = new ArrayList<RendezVous>();
        listeRendezVous.add(  new RendezVous(1,"12/12/2022","10:30",null,"29874561"));
        listeRendezVous.add(  new RendezVous(2,"14/12/2022","15:30",null,"29774561"));

    }


    public boolean addRendezVous(RendezVous rendezVous){

        int refLogement=rendezVous.getLogement().getReference();

        Logement logement=logementMetier.getLogementsByReference(refLogement);

        if(logement!=null){
            rendezVous.setLogement(logement);
            return listeRendezVous.add(rendezVous);}
        return false;
    }
    public List<RendezVous> getListeRendezVous() {
        return listeRendezVous;
    }

    public void setListeRendezVous(List<RendezVous> listeRendezVous) {
        this.listeRendezVous = listeRendezVous;
    }
    public List<RendezVous> getListeRendezVousByLogementReference(int reference) {
        List<RendezVous> liste=new ArrayList<RendezVous>();
        for(RendezVous r:listeRendezVous){
            if(r.getLogement().getReference()==reference)
                liste.add(r);
        }
        return liste;
    }
    public RendezVous getRendezVousById(int id){
        RendezVous rendezVous=null;
        for(RendezVous r:listeRendezVous){
            if(r.getId()==id)
                rendezVous=r;
        }
        return rendezVous;
    }
    public boolean deleteRendezVous(int id){
        Iterator<RendezVous> iterator=listeRendezVous.iterator();
        while(iterator.hasNext()){
            RendezVous r=iterator.next();
            if(r.getId()==id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    public boolean updateRendezVous(int idRendezVous, RendezVous updatedRendezVous) {
        for (int i = 0; i < listeRendezVous.size(); i++) {
            RendezVous r = listeRendezVous.get(i);
            if (r.getId() == idRendezVous) {

                Logement logement = logementMetier.getLogementsByReference(updatedRendezVous.getLogement().getReference());
                if (logement != null) {

                    listeRendezVous.set(i, updatedRendezVous);
                    return true;
                }
            }
        }
        return false;
    }

}
