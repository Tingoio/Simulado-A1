package Views;
import Daos.GerenciadorDeArquivoPessoas;
import Models.Pessoa;
import java.util.Scanner;

public class Menu {

    GerenciadorDeArquivoPessoas gerPessoas = new GerenciadorDeArquivoPessoas();
    Scanner scan = new Scanner(System.in);
    
    public void menuPrincipal(){
        int opcao;
        do {
            System.out.println("--- Menu Principal ---");
            System.out.println("\n1. Menu Pessoa");
            System.out.println("2. Menu Endereço");
            System.out.println("0. Finalizar programa");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    menuPessoa();
                    break;
                case 2:

                    break;
            }
        } while (opcao!=0);
    }

    public void menuPessoa(){
        Pessoa objPessoa = new Pessoa();

        System.out.println("--- Menu Pessoa ---");
        System.out.println("\nPreencha os campos a seguir: ");

        System.out.print("Código: ");
        objPessoa.setCodigo(scan.nextLine());
        scan.nextLine();
        
        System.out.print("Nome: ");
        objPessoa.setNome(scan.nextLine());

        gerPessoas.salvarPessoa(objPessoa);
    }
}
