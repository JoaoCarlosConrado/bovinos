import java.util.*;

public class Transporte {
    Fazenda fazenda_remetente;
    Fazenda fazenda_destinataria;
    ArrayList<Viagem> viagens = new ArrayList<Viagem>();
    Caminhao caminhao;

    public void getViagens() {
        for(int i = 0; i < viagens.size() ; i++){
            int posicao = i+1;
            System.out.println("Viagem: " + posicao + ":");
            for(int j = 0; j < viagens[i].bovinos.size() ; j++){
                System.out.println("Bovino: id: " + viagens[i].bovinos[j].id + " ; peso: " + viagens[i].bovinos[j].peso + " ; parida? " + viagens[i].bovinos[j].parida);
            }
        }
    }
}