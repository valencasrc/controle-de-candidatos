import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        String[] candidatos = {"LUCAS", "LOUYSE", "JULIA", "PAULO", "AUGUSTO"};
        for (String candidado: candidatos){
            entrandoEmContato(candidado);
        }

    }

    //método para entrar contato com candidatos;
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }else
                System.out.println("Contato realizado com sucesso");

        }while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu){
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        }else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS " + tentativasRealizadas + " REALIZADAS");
    }

    //Método auxiliar
    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }


    static void imprimirSelecionados(){
        String[] candidatos = {"LUCAS", "LOUYSE", "JULIA", "PAULO", "AUGUSTO"};

        System.out.println("imprimindo a lista de candidatos informando o indice do elemento");

        for (int indice = 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de número: " + (indice+1) + " é " + candidatos[indice]);
        }

    }

    static void selecaoCandidados() {
        // Array com a lista de candidatos com nomes fictícios
        String[] candidatos = {"LUCAS", "LOUYSE", "JULIA", "PAULO", "AUGUSTO", "MÔNICA", "FABRÍCIO", "MIRELA", "DANIELA", "JORGE"};

        int candidatosSelecionados = 0;
        int candidatosAtuais = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtuais < candidatos.length) {
            String candidato = candidatos[candidatosAtuais];
            double salarioPretendido = valorPretendido(); // Chamada da função valorPretendido()

            System.out.println("O candidato " + candidato + " solicitou esse valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtuais++;
        }
    }

    static double valorPretendido() {
        // Gera um valor aleatório entre 1500 e 4000 para o salário pretendido
        return ThreadLocalRandom.current().nextDouble(1500, 4000);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM UMA CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
