package arquivos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static view.TelaInicial.pasta;

public class ReadFile {

    public String[] leArquivo(String nomeArquivo) throws Exception {
        //metodo recebe o nome do arquivo
        //abre o arquivo txt
        //percorre linha por linha
        //cria um vetor com as linhas do arquivo
        //retorna esse vetor
        BufferedReader b = new BufferedReader(new FileReader(pasta + nomeArquivo));
        int y = 0;
        String textoDoArquivo[] = new String[100];
        String linha = null;
        while ((linha = b.readLine()) != null) {
            textoDoArquivo[y] = (linha);
            y++;

        }
        b.close();

        return textoDoArquivo;
    }

    public int leTamanho(String nomeArquivo) throws FileNotFoundException, IOException {
        //metodo recebe o nome do arquivo
        //abre o arquivo txt
        //percorre linha por linha
        //incrementa em y cada linha colocada no vetor
        //retorna o valor de y sendo o tamanho exato do vetor
        BufferedReader b = new BufferedReader(new FileReader(pasta + nomeArquivo));
        int y = 0;
        String textoDoArquivo[] = new String[100];
        String linha = null;
        while ((linha = b.readLine()) != null) {
            textoDoArquivo[y] = (linha);
            y++;
        }
        b.close();

        return y;
    }

    public int buscaLinha(String[] vetor, String palavra) {

        //recebe como parametro um vetor e uma String para buscar
        //percorre o vetor verificando se a String para busca está lá
        //retorna o indice do vetor
        try{
        int b = 0;
        for (String p : vetor) {
            if (p.contains(palavra)) {
                return b;
            }
            b++;
        }
        
        } catch (Exception e) {

        }

        return -1;
    }

    public String[] quebra(String vetor) {

        //recebe como parametro uma string que normalmente é uma linha de vetor
        //retorna um vetor divido pelos ":", afinal o arquivo txt segue o padrão "dado:outroDado"
        //dessa forma é retornado im vetor em cada indice representa um dado
        return vetor.split(":");
    }

    public boolean VerificaCod(String[] vetor, String busca, String arq) {
        
        //recebe como parametro um vetor, um palavra para buscar e o nome do arquivo para buscar
        //le o tamanho do arquivo
        //percorre todo o arquivo criando um vetor e verificando se o primeiro indice dele é igual a informação da busca
        //se encontrar algo será retornado false
        //se não encontrar será retornado true
        int taman = 0;
        boolean c = true;
        try {
            taman = leTamanho(arq);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        int b = 0;
        for (int i = 0; i < taman; i++) {
            String vetQuebrado[] = quebra(vetor[i]);
            if (vetQuebrado[0].equals(busca)) {
                b++;
            }

        }
        if (b != 0) {
            c = false;
        }
        return c;
    }

    public String[] VerificaCod(String vetor[], String arq, int p) {
        //recebe como parametro um vetor, o nome do arquivo e um número int que é o indice da posição do dado que quer encontrar
        //le o tamanho do arquivo
        //cria um novo vetor com o tamanho do arquivo afim de evitar a ultima linha vazia
        //percorre todo o arquivo atribuindo o indice desejado ao novo vetor
        //assim criando um vetor apenas com dado da mesma coluna
        //retorna esse novo vetor
        int taman = 0;
        try {
            taman = leTamanho(arq);
        } catch (IOException ex) {
            Logger.getLogger(ReadFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        String soLogin[] = new String[taman];
        for (int i = 0; i < taman; i++) {
            String vetQuebrado[] = quebra(vetor[i]);
            soLogin[i] = vetQuebrado[p];

        }

        return soLogin;
    }
}
