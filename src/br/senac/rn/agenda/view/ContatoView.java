package br.senac.rn.agenda.view;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;

import java.util.Scanner;

public class ContatoView {

    private static ContatoRepository repository = new ContatoRepository();
    private static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        Integer escolha = -1;

        do {
            ContatoView.getMenu();
            escolha = entrada.nextInt();
            switch (escolha) {
                case 1:
                    ContatoView.cadastrar();
                    break;
                case 2:
                    ContatoView.listarTodos();
                    break;
                case 3:
                    ContatoView.buscarContatoPeloNome();
                    break;
                case 4:
                    ContatoView.editarUmContato();
                    break;
                case 5:
                    ContatoView.excluirUmContato();
                    break;
            }
        } while (escolha != 0);
        System.exit(0);

    }

    private static void excluirUmContato() {

    }

    private static void editarUmContato() {
        System.out.print("Digite um nome à buscar: ");
        String nome = entrada.next();
        Contato contato = repository.buscaPeloNome(nome);
        if (contato == null) {
            System.out.println("Contato inexistente!!!");
        } else {
            System.out.println("Deseja alterar o nome? (s/n)");

            String respostaNome = entrada.next();
            if (respostaNome.equals("s")) {
                System.out.println("Informe o novo nome:");
                String novoNome = entrada.next();
                contato.setNome(novoNome);
            }

            System.out.println("Deseja alterar o fone? (s/n)");
            String respostaFone = entrada.next();
            if (respostaFone.equals("s")) {
                System.out.println("Informe o novo fone:");
                String novoFone = entrada.next();
                contato.setFone(novoFone);
            }

            repository.edita(contato);
        }
    }

    private static void buscarContatoPeloNome() {
        System.out.print("Digite um nome à buscar: ");
        String nome = entrada.next();
        Contato contato = repository.buscaPeloNome(nome);
        if (contato == null) {
            System.out.println("Contato inexistente!!!");
        } else {
            String id = contato.getId().toString();
            String nomeContato = contato.getNome();
            String fone = contato.getFone();

            String resposta = id + " - " + nomeContato + " - " + fone;
            System.out.println(resposta);
        }
    }

    private static void listarTodos() {
        for (Contato contato : repository.buscaTodos()) {
            String id = contato.getId().toString();
            String nome = contato.getNome();
            String fone = contato.getFone();

            String saida = id + " - " + nome + " - " + fone;
            System.out.println(saida);
        }
    }

    private static void cadastrar() {
        System.out.print("Digite o nome: ");
        String nome = entrada.next();
        System.out.print("Digite o fone: ");
        String fone = entrada.next();
        Contato contato = new Contato(nome, fone);
        repository.salva(contato);
    }

    private static void getMenu() {
        String menu = "";
        menu += "================================ \n";
        menu += "1 - Cadastrar Novo Contato       \n";
        menu += "2 - Listar Todos os Contatos     \n";
        menu += "3 - Buscar Contato Pelo Nome     \n";
        menu += "4 - Editar um Contato            \n";
        menu += "5 - Excluir um Contato           \n";
        menu += "0 - Sair                         \n";
        menu += "================================ \n";
        menu += "Opção: ";
        System.out.print(menu);
    }

}
