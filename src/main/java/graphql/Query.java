package graphql;

import java.awt.*;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLRootResolver;

import entity.Logement;
import entity.RendezVous;
import repository.LogementRepository;
import repository.RendezVousRepository;

public class Query implements GraphQLRootResolver {
private RendezVousRepository rendezVousRepository;
private  LogementRepository logementRepository;

    public Query (RendezVousRepository repoR , LogementRepository repoLo){
        this.rendezVousRepository= repoR;
        this.logementRepository=repoLo;
    }

    public  List<RendezVous> getallrendezVous(){
        return this.rendezVousRepository.getListeRendezVous();
    }
    public Logement getLogementByRef(int reference) {
        return logementRepository.getLogementsByReference(reference);

    }
    public List<RendezVous> getRdvsByLog(int reference) {
        return rendezVousRepository.getListeRendezVousByLogementRef(reference);
    }
    public List<RendezVous> allRendezVous() {
        return rendezVousRepository.getListeRendezVous();
    }
    public RendezVous getRendezVousbuId(int id){
        for(RendezVous r:rendezVousRepository.getListeRendezVous()){
            if(r.getId()==id)
                return  r ;
        }
        return null;
    }
}
