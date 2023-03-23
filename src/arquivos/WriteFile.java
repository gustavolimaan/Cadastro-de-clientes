package arquivos;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static view.TelaInicial.pasta;

public class WriteFile {

    //o metodo recebe como parâmetro a mensagem (registro) que será gravada no txt e o nome do arquivo txt em que será armazenado
    public static void Criar(String registro, String nomeArquivo) throws FileNotFoundException, IOException {

        File arq = null;
        try {

            arq = new File(pasta + nomeArquivo);
            FileWriter fw;

            // Verifica se o arquivo existe
            // Se existir, ele abre para adicionar dados
            // se nao existir, ele cria o arquivo
            if (arq.exists() == true) {
                fw = new FileWriter(arq, true);
            } else {
                fw = new FileWriter(arq);
            }

            BufferedWriter bw = new BufferedWriter(fw);

            //escreve o registro no arquivo e pula uma linha com o \n
            bw.write(registro + "\n");

            //fecha o arquivo
            bw.close();

        } catch (IOException e) {
            System.err.println("Erro ao inserir linhas no arquivo: " + arq);
        }
    }
}
