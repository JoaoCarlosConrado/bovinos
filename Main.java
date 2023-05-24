import java.util.*;

public class Main {
    ArrayList<Transporte> transportes = new ArrayList<Transporte>();
    Scanner scanner = new Scanner(System.in);

    private static void menu_cadastro_bovino(Fazenda fazenda_remetente){
        System.out.println("Hora de Cadastrar os Bovinos da Fazenda Remetente que irá ser transportado");
        System.out.println("Digite a quantidade de Bovinos a ser transportados: ");
        int quant = scanner.nextInt();

        for(int i = 0; i < quant; i++){
            System.out.println("Digite o id do bovino " + i);
            int id = scanner.nextInt();

            System.out.println("Digite o peso do bovino " + i);
            float id = scanner.nextFloat();

            System.out.println("Vaca Parida?");
            System.out.println("1 - Sim");
            System.out.println("2 - Não");
            int op = scanner.nextInt();

            boolean parida = op ? true : false;

            Bovino bovino = new Bovino(id, peso, parida);
            fazenda_remetente.bovinos.add(bovino)
        }

    }

    private static void realizar_transporte(Transporte transporte) {
        while(transporte.fazenda_remetente.bovinos.size() > 0){
            viagem = new Viagem();
            if(transporte.caminhao.carga_atual < transporte.caminhao.peso_suportado){
                for(int i = 0; i < transporte.fazenda_remetente.bovinos.size(); i++){
                    if(fazenda_remetente.bovinos[i].parida){
                        if((transporte.caminhao.carga_atual + 600) <= transporte.caminhao.peso_suportado) {
                        transporte.caminhao.carga_atual += fazenda_remetente.bovinos[i].peso;
                        viagem.bovinos.add(transporte.fazenda_remetente.bovinos[i]);
                        transporte.fazenda_destinataria.bovinos.add(transporte.fazenda_remetente.bovinos[i]);
                        transporte.fazenda_remetente.bovinos.remove(i);
                        }
                    }else{
                        if((transporte.caminhao.carga_atual + fazenda_remetente.bovinos[i].peso) <= transporte.caminhao.peso_suportado) {
                        transporte.caminhao.carga_atual += fazenda_remetente.bovinos[i].peso;
                        viagem.bovinos.add(transporte.fazenda_remetente.bovinos[i]);
                        transporte.fazenda_destinataria.bovinos.add(transporte.fazenda_remetente.bovinos[i]);
                        transporte.fazenda_remetente.bovinos.remove(i);
                        }
                    }
                    
                }
            }else{
                transporte.caminhao.carga_atual = 0;
            }
            transporte.viagens.add(viagem);
        }
        System.out.println("Viagens Concluídas!");
    }

    private static void menu_novo_transporte(){
        Transporte transporte = new Transporte();
        transportes.add(transporte);

        Fazenda fazenda_remetente = new Fazenda();
        Fazenda fazenda_destinataria = new Fazenda();

        transporte.fazenda_remetente = fazenda_remetente;
        transporte.fazenda_destinataria = fazenda_destinataria;
        
        System.out.println("Digite o nome da fazenda remetente");
        fazenda_remetente.nome = scanner.nextLine();

        System.out.println("Digite o nome da fazenda destinatária");
        fazenda_destinataria.nome = scanner.nextLine();

        menu_cadastro_bovino(fazenda_remetente);

        System.out.println("Escolha o caminhão para fazer o transporte:");
        System.out.println("1 - Truck");
        System.out.println("2 - Carreta baixa");
        int op = scanner.nextInt();
        
        Caminhao caminhao;

        boolean ver;
        do{
            ver = false;
            switch (op) {
                case 1:
                    caminhao = new Truck();
                    break;
                case 2:
                    caminhao = new Carreta_baixa();
                    break;
                default:
                    System.out.println("Opção Inválida");
                    ver = true;
                    break;
            }
        }while(ver);

        realizar_transporte(transporte);

    }


    public static void imprimir_viagens(Transporte transporte) {
        transporte.getViagens();
    }

    public static void imprimir_transportes() {
        System.out.println("Selecione um dos Transportes:");
        for(int i = 0; i < transportes.size(); i++){
            int op = i++;
            System.out.println(op + " - " + transportes[i].fazenda_remetente + " para " + transportes.fazenda_destinataria);
        }
        boolean ver = false;
        do{
            int op = scanner.nextInt();

            if(op < 1) || (op >= transportes.size()){
                System.out.println("Opção inválida!");
                ver = true;
            }else{
                int indice = op-1;
                imprimir_viagens(transportes[indice]);
            }
        }while(ver)
        
    }

    private static void menu(){
        int op = 0;
        while(op != 3){
            System.out.println("Selecione uma das opções:");
            System.out.println("");
            System.out.println("1 - Começar um novo Transporte de Bovinos");
            System.out.println("2 - Visualizar dados de Transportes");
            System.out.println("3 - Sair");
            op = scanner.nextInt();
            boolean ver;
            do{
                ver = false;
                switch(op){
                case 1:
                    menu_novo_transporte();
                    break;
                case 2:
                    imprimir_transportes();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    ver = true;
                    break;
                }
            }while(ver);
        }
    }

    public static void main(String[] args) {
        System.out.println("Seja bem vindo ao Programa de Transporte de Bovinos!");
        menu();
    }
}