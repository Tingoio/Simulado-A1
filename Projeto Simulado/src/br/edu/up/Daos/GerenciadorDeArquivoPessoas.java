package Daos;
import Models.Pessoa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GerenciadorDeArquivoPessoas {

    private static final String nomeArquivo = "src\\br\\edu\\up\\Daos\\Pessoas.csv";
    
    public static void salvarPessoa(Pessoa pessoa){

        try{

            boolean arquivoExiste = new File(nomeArquivo).exists();
        
            FileWriter escritor = new FileWriter(nomeArquivo, true);
        
            if (!arquivoExiste) { 
                escritor.write("codigo;nome\n");
            }

            escritor.write(pessoa.getCodigo() + ";" + pessoa.getNome() + "\n");

            escritor.flush();
            escritor.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Pessoa> listarPessoaCSV (){
        ArrayList<Pessoa> listaPessoas = new ArrayList<>();

        try {

            BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
            boolean primeiraLinha = true;

            while ((linha = leitor.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue;
                }

                String[] dados = linha.split(";");

                String codigo = dados[0];
                String nome = dados[1];

                Pessoa pessoa = new Pessoa(codigo, nome);

                listaPessoas.add(pessoa);

                System.out.println("Codigo: " + codigo + "\nNome: " + nome);

            }

            leitor.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaPessoas;
    }
    
}
